package com.bridgelabz.qa;

import com.bridgelabz.qa.base.BaseTest;
import com.bridgelabz.qa.pages.DashboardPage;
import com.bridgelabz.qa.pages.LoginPage;
import com.bridgelabz.qa.pages.PIMPage;
import com.bridgelabz.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PIMPageTest extends BaseTest {
    PIMPage pimPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    String sheetName = "AddEmployee";

    public PIMPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        pimPage = new PIMPage();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void clickOnAddEmployeeModuleTest() throws InterruptedException {
        dashboardPage.clickOnPIMPageLink();
        pimPage.clickOnAddEmployeeModule();
    }

    @DataProvider
    public Object[][] getOrangeHRMData() {
        return TestUtil.getTestData(sheetName);
    }

    @Test(dataProvider = "getOrangeHRMData", priority = 2)
    public void addEmployeeTest(String firstName, String middelName, String lastName) throws InterruptedException {
        dashboardPage.clickOnPIMPageLink();
        pimPage.clickOnAddEmployeeModule();
        pimPage.addEmployee(firstName, middelName, lastName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
