package com.bridgelabz.qa;

import com.bridgelabz.qa.base.BaseTest;
import com.bridgelabz.qa.pages.AdminPage;
import com.bridgelabz.qa.pages.DashboardPage;
import com.bridgelabz.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;


    public AdminPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyAdminPageLabelTest() {
        Assert.assertTrue(adminPage.verifyAdminPageLabel());
    }

    @Test(priority = 2)
    public void verifyAddButtonLabelTest() throws InterruptedException {
        dashboardPage.clickOnAdminPageLink();
        boolean flag = adminPage.verifyAddButtonLabel();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void verifySearchButtonElementTest() throws InterruptedException {
        dashboardPage.clickOnAdminPageLink();
        Assert.assertTrue(adminPage.verifySearchButtonElement());
    }

    @Test(priority = 4)
    public void clickOnAddButtonOnAdminTest() throws InterruptedException {
        dashboardPage.clickOnAdminPageLink();
        Thread.sleep(3000);
        adminPage.clickOnAddButtonOnAdmin();
    }

    @Test(priority = 5)
    public void clickOnSearchButtonOnAdminTest() throws InterruptedException {
        dashboardPage.clickOnAdminPageLink();
        Thread.sleep(3000);
        adminPage.clickOnSearchButtonOnAdmin();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
