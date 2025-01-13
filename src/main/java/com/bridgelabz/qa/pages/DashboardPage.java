package com.bridgelabz.qa.pages;

import com.bridgelabz.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseTest {

    @FindBy(xpath = "//h6[contains(text(),'OrangeHRM')]")
    @CacheLookup
    WebElement dashboardTitle;

    @FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"])[1]")
    @CacheLookup
    WebElement adminLink;

    @FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"])[3]")
    @CacheLookup
    WebElement leaveLink;

    @FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"])[5]")
    @CacheLookup
    WebElement recruitmentLink;

    @FindBy(xpath = "(//a[@class=\"oxd-main-menu-item\"])[8]")
    @CacheLookup
    WebElement directoryLink;

    @FindBy(xpath = "(//li[@class=\"oxd-main-menu-item-wrapper\"])[2]")
    @CacheLookup
    WebElement pimLink;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyDashboardPageTitle() {
        return driver.getTitle();
    }

    public AdminPage clickOnAdminPageLink() throws InterruptedException {
        adminLink.click();
        Thread.sleep(3000);
        return new AdminPage();
    }

    public LeavePage clickOnLeavePageLink() throws InterruptedException {
        leaveLink.click();
        Thread.sleep(3000);
        return new LeavePage();
    }

    public RecruitmentPage clickOnRecruitmentPageLink() throws InterruptedException {
        recruitmentLink.click();
        Thread.sleep(3000);
        return new RecruitmentPage();
    }

    public DirectoryPage clickOnDirectoryPageLink() throws InterruptedException {
        directoryLink.click();
        Thread.sleep(3000);
        return new DirectoryPage();
    }
    public PIMPage clickOnPIMPageLink() throws InterruptedException {
        pimLink.click();
        Thread.sleep(5000);
        return new PIMPage();
    }
}
