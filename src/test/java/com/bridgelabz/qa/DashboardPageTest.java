package com.bridgelabz.qa;

import com.bridgelabz.qa.base.BaseTest;
import com.bridgelabz.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    LeavePage leavePage;
    RecruitmentPage recruitmentPage;
    DirectoryPage directoryPage;
    PIMPage pimPage;

    public DashboardPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        leavePage = new LeavePage();
        recruitmentPage = new RecruitmentPage();
        directoryPage = new DirectoryPage();
        pimPage = new PIMPage();
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyDashboardTitleTest() {
        String title = dashboardPage.verifyDashboardPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2)
    public void clickOnAdminPageLinkTest() throws InterruptedException {
        adminPage = dashboardPage.clickOnAdminPageLink();
    }

    @Test(priority = 3)
    public void clickOnLeavePageLinkTest() throws InterruptedException {
        leavePage = dashboardPage.clickOnLeavePageLink();
    }

    @Test(priority = 4)
    public void clickOnRecruitmentPageLinkTest() throws InterruptedException {
        recruitmentPage = dashboardPage.clickOnRecruitmentPageLink();
    }

    @Test(priority = 5)
    public void clickOnDirectoryPageLinkTest() throws InterruptedException {
        directoryPage = dashboardPage.clickOnDirectoryPageLink();
    }

    @Test(priority = 6)
    public void clickOnPIMPageLinkTest() throws InterruptedException {
        pimPage = dashboardPage.clickOnPIMPageLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
