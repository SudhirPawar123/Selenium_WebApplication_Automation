package com.bridgelabz.qa.listener;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bridgelabz.qa.base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ListenerWithExtentReport extends BaseTest implements ITestListener {
    ExtentReports extent = new ExtentReports();
    ExtentTest test;
    private static WebDriver driver; // Ensure your tests initialize this driver.

    public ListenerWithExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)  {
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());
        // Capture and attach screenshot
        String base64Screenshot = captureScreenshot(result.getMethod().getMethodName());
        if (base64Screenshot != null) {
            test.addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        } else {
            test.log(Status.WARNING, "Screenshot could not be captured.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    /**
     * Captures a screenshot and returns the file path.
     *
     * @param testName The name of the test case.
     * @return The file path of the captured screenshot.
     */
//    public static String captureScreenshot(String testName) {
//
//        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
//        String screenshotPath = screenshotDir + testName + ".png";
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            // Create directory if it doesn't exist
//            Files.createDirectories(new File(screenshotDir).toPath());
//
//            // Save screenshot to the specified path
//            Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());
//        } catch (IOException e) {
//            System.out.println("Failed to capture screenshot: " + e.getMessage());
//        }
//        return screenshotPath;
//    }

    /**
     * Sets the WebDriver instance for screenshot capture.
     *
     * @param webDriver The WebDriver instance.
     */
//    public static void setWebDriver(WebDriver webDriver) {
//        driver = webDriver;
//    }
}
