package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;


public class RegisterSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;

    @Step
    public void  navigateToHomePage(){
        homePage.open();
    }
    @Step
    public void goToMyAccountLink(){
        homePage.clickAccountMenuLink();
    }

    @Step
    public void enterRegisterInformation(String email, String password){
        myAccountPage.setEmailRegisterField(email);
        myAccountPage.setPasswordRegisterField(password);}

    @Step
    public void clickRegisterButton(){
        myAccountPage.clickRegisterButton();
    }
    @Step
    public void doRegister(String email, String password){
        navigateToHomePage();
        goToMyAccountLink();
        enterRegisterInformation(email, password);
        clickRegisterButton();
    }
    @Step
    public void checkSuccessRegister(){
        myAccountPage.isWelcomeMessageDisplayed();
        myAccountPage.checkWelcomeUserMessage();
    }
    @Step
    public void verifyValidEmailErrorMessage() {
        myAccountPage.checkErrorMessageDisplayed();
    }
}


