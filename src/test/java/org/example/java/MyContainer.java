package org.example.java;

import org.example.Configuration;
import org.example.Container;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
public class MyContainer implements Container {

    public final MyBinder binder;

    public MyContainer(Configuration configuration) {
        this.binder = new MyBinder(this);
        configuration.configure(binder);
    }
    public final Map<Class<?>, Supplier<?>> prototypeSuppliers = new HashMap<>();
    public final Map<Class<?>, Object> singletonObjects = new HashMap<>();

    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (singletonObjects.containsKey(clazz)) {
            return clazz.cast(singletonObjects.get(clazz));
        }
        else if (prototypeSuppliers.containsKey(clazz)) {
            Supplier<?> supplier = prototypeSuppliers.get(clazz);
            return clazz.cast(supplier.get());
        }
        throw new IllegalArgumentException("no type available: " + clazz.getName());
    }
}