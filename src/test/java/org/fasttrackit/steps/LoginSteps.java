package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.MyAccountPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;

public class LoginSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();}
    @Step
    public void clickMyAccountLink(){
        homePage.clickAccountMenuLink();
    }
    @Step
    public void goToLogin(){
        homePage.clickLoginLink();
    }
    @Step
    public void enterCredentials(String email, String password) {
        myAccountPage.setUsernameLoginField(email);
        myAccountPage.setPasswordLoginField(password);
    }
    @Step
    public void clickLoginButton(){
        myAccountPage.clickLoginButton();
    }

    @Step
    public void doLogin(){
        navigateToHomePage();
        goToLogin();
        enterCredentials(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        clickLoginButton();

    }
    @Step
    public void clickRememberMe(){
        myAccountPage.clickRememberMeCheckBox();
    }
    @Step
    public void isUserLoggedIn(){
        myAccountPage.isWelcomeMessageDisplayed();
        //myAccountPage.checkWelcomeUserMessage();
    }
    @Step
    public void checkLoggedIn(String username) {
        Assert.assertTrue(myAccountPage.checkLoggedIn(username));
    }
    @Step
    public void goToLoginMeta(){
        homePage.open();
        homePage.clickLoginMetaLink();
    }
    @Step
    public void enterCredentialsMeta(String name, String password){
        loginPage.setUserNameField(name);
        loginPage.setUserPasswordField(password);
    }
    @Step
    public void clickRememberMeBox(){
        loginPage.clickRememberMeBox();
    }
    @Step
    public void clickLoginButtonMeta(){
        loginPage.clickLoginButtonMeta();
    }
    @Step
    public void checkLoginError(String message){
        loginPage.verifyErrorMessage(message);
    }
    @Step
    public void verifyInvalidEmailErrorMessage() {
        myAccountPage.checkErrorMessageDisplayed();
    }



}

