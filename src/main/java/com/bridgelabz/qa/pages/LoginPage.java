package com.bridgelabz.qa.pages;

import com.bridgelabz.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    @FindBy(name = "username")
    @CacheLookup
    WebElement username;
    @FindBy(name = "password")
    @CacheLookup
    WebElement password;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    @CacheLookup
    WebElement loginButton;
    @FindBy(xpath = "//div[@class=\"orangehrm-login-branding\"]")
    @CacheLookup
    WebElement orangeHRMImage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateOrangeHRMImage() {
        return orangeHRMImage.isDisplayed();
    }

    public DashboardPage login(String un, String pw) {
        username.sendKeys(un);
        password.sendKeys(pw);
        loginButton.click();
        return new DashboardPage();
    }

}
