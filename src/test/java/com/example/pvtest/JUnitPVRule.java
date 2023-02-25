package com.example.pvtest;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class JUnitPVRule implements TestRule, TestExecutionExceptionHandler {
    @Override
    public Statement apply(Statement statement, Description description) {
        return null;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        System.out.println("Exception=" + extensionContext.getExecutionException().isPresent());
        System.out.println("Class " + extensionContext.getRequiredTestClass());
        System.out.println("Method " + extensionContext.getRequiredTestMethod());
        System.out.println(extensionContext);

    }
}
