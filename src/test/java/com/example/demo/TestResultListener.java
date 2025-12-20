package com.example.demo;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " - PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " - FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " - SKIP");
    }
}
// mkdir -p src/test/java/com/example/demo

// mv src/main/java/com/example/demo/TestResultListener.java \
//    src/test/java/com/example/demo/
