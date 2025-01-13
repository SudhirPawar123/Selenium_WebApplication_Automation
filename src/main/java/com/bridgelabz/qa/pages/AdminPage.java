package com.bridgelabz.qa.pages;

import com.bridgelabz.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BaseTest {

    @FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
    WebElement adminLabel;
    @FindBy(xpath ="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])[1]")
    WebElement verifyAddLabel;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
    WebElement verifySearchButton;

    @FindBy(xpath ="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary'])[1]")
    WebElement clickOnAddButton;

    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
    WebElement clickOnSearchButton;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAdminPageLabel(){
       return adminLabel.isDisplayed();
    }

    public boolean verifyAddButtonLabel(){
        return verifyAddLabel.isDisplayed();
    }

    public boolean verifySearchButtonElement(){
         return verifySearchButton.isDisplayed();
    }

    public void clickOnAddButtonOnAdmin(){
        clickOnAddButton.click();
    }

    public void clickOnSearchButtonOnAdmin(){
        clickOnSearchButton.click();
    }

}
