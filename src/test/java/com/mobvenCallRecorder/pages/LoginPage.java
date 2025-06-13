package com.mobvenCallRecorder.pages;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
public class LoginPage extends BasePage {
//------------------------------------------------###### LOCATORS ######-----------------------------------------------\\

    @iOSXCUITFindBy(accessibility = "usernameTextField")
    private WebElement usernameField;

    @iOSXCUITFindBy(accessibility = "passwordTextField")
    private WebElement passwordField;

    @iOSXCUITFindBy(accessibility = "loginButton")
    private WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "errorMessage")
    private WebElement errorMessage;

    //------------------------------------------------###### METHODS ######-----------------------------------------------\\


    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
