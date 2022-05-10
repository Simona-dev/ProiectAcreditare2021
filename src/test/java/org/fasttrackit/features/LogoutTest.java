package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.LogoutSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class LogoutTest extends BaseTest {
    @Steps
    LoginSteps loginSteps;
    @Steps
    LogoutSteps logoutSteps;

    @Test
    public void logoutTest(){
        loginSteps.doLogin();
        logoutSteps.clickLogoutLink();
        logoutSteps.verifyUserIsOut();
    }
    @Test
    public void logoutMetaMenuTest(){
        loginSteps.goToLoginMeta();
        loginSteps.enterCredentialsMeta(Constants.USER_NAME, Constants.USER_PASSWORD);
        loginSteps.clickRememberMeBox();
        loginSteps.clickLoginButtonMeta();
        logoutSteps.clickLogoutMetaLink();
        logoutSteps.verifyLogoutMessage("You are now logged out.");
    }

}

