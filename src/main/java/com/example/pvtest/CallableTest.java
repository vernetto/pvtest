package com.example.pvtest;

import java.util.concurrent.Callable;

public class CallableTest {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        System.out.println("about to call");
        callableTest.testCallable(() -> new MyCallable());

    }

    private void testCallable(final Callable<MyProvider> callable) {
        try {
            System.out.println("about to call 2");
            callable.call();
            System.out.println("down with call");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
