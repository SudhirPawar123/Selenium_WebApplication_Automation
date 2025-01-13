package com.bridgelabz.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bridgelabz.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
