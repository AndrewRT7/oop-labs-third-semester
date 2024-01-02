package org.example.java;

import org.example.Configuration;
import org.example.Container;
import org.example.Environment;

public class DummyEnvironment implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        return new MyContainer(configuration);
    }
}