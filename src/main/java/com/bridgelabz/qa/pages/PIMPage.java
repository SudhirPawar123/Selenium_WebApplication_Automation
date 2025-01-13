package com.bridgelabz.qa.pages;

import com.bridgelabz.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends BaseTest {
    public PIMPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Add Employee')]")
    @CacheLookup
    WebElement addEmployee;

    @FindBy(name="firstName")
    @CacheLookup
    WebElement firstName;

    @FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    @CacheLookup
    WebElement middelName;

    @FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    @CacheLookup
    WebElement lastName;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    @CacheLookup
    WebElement saveButton;



    public void clickOnAddEmployeeModule() throws InterruptedException {
        addEmployee.click();
        Thread.sleep(3000);
    }

    public void addEmployee(String fn,String mn,String ln) throws InterruptedException {
        firstName.sendKeys(fn);
        middelName.sendKeys(mn);
        lastName.sendKeys(ln);
        saveButton.click();
        Thread.sleep(5000);
    }
}
