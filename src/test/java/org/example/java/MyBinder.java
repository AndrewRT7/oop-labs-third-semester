package org.example.java;

import org.example.Binder;

import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.function.Supplier;

public class MyBinder implements Binder {
    private final MyContainer container;

    public MyBinder(MyContainer container) {
        this.container = container;
    }

    @Override
    public <T> void bind(Class<T> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<?> chosenConstructor = null;
        boolean isSingleton = clazz.isAnnotationPresent(Singleton.class);

        for (Constructor<?> constructor : constructors) {
            if (chosenConstructor == null || constructor.getParameterCount() < chosenConstructor.getParameterCount()) {
                chosenConstructor = constructor;
            }
        }

        if (chosenConstructor != null) {
            final Constructor<?> finalChosenConstructor = chosenConstructor;
            Supplier<T> supplier = () -> {
                try {
                    if (finalChosenConstructor.getParameterCount() == 0) {
                        return clazz.getDeclaredConstructor().newInstance();
                    } 
                    else {
                        Object[] params = Arrays.stream(finalChosenConstructor.getParameterTypes())
                                .map(param -> container.getComponent(param))
                                .toArray();
                        return clazz.cast(finalChosenConstructor.newInstance(params));
                    }
                } 
                catch (Exception e) {
                    throw new RuntimeException("can't instantiate class: " + clazz.getName(), e);
                }
            };

            if (isSingleton) {
                T instance = supplier.get();
                container.singletonObjects.put(clazz, instance);
            } 
            else {
                container.prototypeSuppliers.put(clazz, supplier);
            }
        } 
        else {
            throw new RuntimeException("no constructor for " + clazz.getName());
        }
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        boolean isSingleton = implementation.isAnnotationPresent(Singleton.class);

        if (isSingleton) {
            try {
                T instance = container.getComponent(implementation);
                container.singletonObjects.put(clazz, instance);
            } 
            catch (Exception e) {
                throw new RuntimeException("can't instantiate singleton class: " + implementation.getName(), e);
            }
        } 
        else {
            container.prototypeSuppliers.put(clazz, () -> {
                try {
                    return container.getComponent(implementation);
                } 
                catch (Exception e) {
                    throw new RuntimeException("can't instantiate class: " + implementation.getName(), e);
                }
            }
            );
        }
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        container.singletonObjects.put(clazz, instance);
    }

}