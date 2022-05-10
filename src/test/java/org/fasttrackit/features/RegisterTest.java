package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;



    @Test
    public void createNewUserValid(){
        registerSteps.doRegister(randomStringGenerator(), Constants.USER_PASSWORD);
        registerSteps.checkSuccessRegister();
    }
    @NotNull
    private String randomStringGenerator() {
        return RandomStringUtils.randomAlphanumeric(10) + "@test.ro";}

    @Test
    public void verifyMandatoryEmailField(){
        registerSteps.navigateToHomePage();
        registerSteps.goToMyAccountLink();
        registerSteps.enterRegisterInformation("","");
        registerSteps.clickRegisterButton();
        registerSteps.verifyValidEmailErrorMessage();
    }

}

