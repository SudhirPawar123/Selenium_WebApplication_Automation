package com.bridgelabz.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bridgelabz.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties properties;
    public static Logger logger;
    public BaseTest() {
        properties = new Properties();
        try {
            FileInputStream inputProperties = new FileInputStream("C:\\Users\\dell\\Desktop\\PageObjectModel\\src\\main\\java\\com\\bridgelabz\\qa\\config\\config.properties");
            properties.load(inputProperties);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browser = properties.getProperty("browser");
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }
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

    public static String captureScreenshot(String testName) {
        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        String screenshotPath = screenshotDir + testName + ".png";

        try {
            // Capture screenshot as Base64 string
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            // Create directory if it doesn't exist
            Files.createDirectories(new File(screenshotDir).toPath());

            // Decode Base64 string and save as a file
            byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Screenshot);
            Files.write(new File(screenshotPath).toPath(), decodedBytes);

            // Return Base64 string for embedding in Extent Report
            return "data:image/png;base64," + base64Screenshot; // Return Base64 string prefixed for embedding
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null; // Return null in case of failure
        }
    }


}
