package com.example.pvtest;

public class MyCallable implements MyProvider {
    public MyCallable() {
        System.out.println("constructor being called");
    }

    @Override
    public void hello() {
        System.out.println("hello being called");
    }
}
