package ui.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test " + result.getMethod().getMethodName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test " + result.getMethod().getMethodName() + " passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test " + result.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Tests finished");
    }
}
