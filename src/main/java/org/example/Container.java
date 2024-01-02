package org.example;

public interface Container {
    <T> T getComponent(Class<T> clazz);
}