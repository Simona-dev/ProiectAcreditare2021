package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Steps
    LoginSteps loginSteps;


    @Test
    public void loginWithValidCredentials(){
        loginSteps.navigateToHomePage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        loginSteps.clickLoginButton();
        loginSteps.checkLoggedIn(Constants.USER_NAME);

    }
    @Test
    public void loginWithInvalidPassword(){
        loginSteps.navigateToHomePage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL, "ana");
        loginSteps.clickLoginButton();
        loginSteps.checkLoginError("The password you entered for the email address"
                + Constants.USER_EMAIL + " is incorrect. ");

    }
    @Test
    public void loginWithInvalidEmail(){
        loginSteps.navigateToHomePage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials("anablandiana1island.ro",Constants.USER_PASSWORD);
        loginSteps.clickLoginButton();
        loginSteps.verifyInvalidEmailErrorMessage();
    }
    @Test
    public void verifyRequiredField() {
        loginSteps.navigateToHomePage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials("", "");
        loginSteps.clickLoginButton();
        loginSteps.checkLoginError(" Username is required.");
    }

    @Test
    public void loginFromMetaMenu(){
        loginSteps.goToLoginMeta();
        loginSteps.enterCredentialsMeta(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        loginSteps.clickRememberMeBox();
        loginSteps.clickLoginButtonMeta();
    }
    @Test
    public void doLoginWithRememberMe(){
        loginSteps.navigateToHomePage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        loginSteps.clickRememberMe();
        loginSteps.clickLoginButton();

    }







}

