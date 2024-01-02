package org.example.java;

import org.example.Binder;

public class DummyBinder implements Binder {
    @Override
    public <T> void bind(Class<T> clazz) {

    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {

    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {

    }
}