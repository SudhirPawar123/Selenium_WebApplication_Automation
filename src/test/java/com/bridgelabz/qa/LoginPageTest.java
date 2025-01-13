package com.bridgelabz.qa;

import com.bridgelabz.qa.base.BaseTest;
//import com.bridgelabz.qa.extentreportlistener.ExtentReporterNG;
import com.bridgelabz.qa.pages.DashboardPage;
import com.bridgelabz.qa.pages.LoginPage;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        logger= Logger.getLogger(LoginPageTest.class);
        logger.info("***************************Starting text cases execution ******************************");
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageTitleTest() throws InterruptedException {
        logger.info("****************************** starting test case *****************************************");
        logger.info("****************************** OrangeHRMTitleTest *****************************************");
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
        Thread.sleep(2000);
        logger.info("****************************** Ending test case *****************************************");
        logger.info("****************************** OrangeHRMTitleTest *****************************************");
    }

    @Test(priority = 2)
    public void validateOrangeHRMImageTest() throws InterruptedException {
        boolean flag = loginPage.validateOrangeHRMImage();
        Assert.assertTrue(flag);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Description("User Login the Application ")
    @Feature("Login: 1")
    @Story("The User enter the valid name and password then login theApplication")
    public void loginPageTest() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage = loginPage.login(properties.getProperty("usrname"), properties.getProperty("password"));
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        logger.info("*************************** Finished text cases execution ******************************");
    }
}
