package org.example.java;

import org.example.Binder;
import org.example.Configuration;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        binder.bind(UseA.class);
    }
}