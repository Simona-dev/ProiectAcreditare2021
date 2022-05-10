package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.MyAccountPage;

public class LogoutSteps  {
    private MyAccountPage myAccountPage;

    @Step
    public void clickLogoutLink(){
        myAccountPage.clickLogoutLink();

    }
    @Step
    public void clickLogoutMetaLink(){
        myAccountPage.clickLogoutMetaLink();
    }
    @Step
    public void verifyLogoutMessage(String message) {
        myAccountPage.checkLogoutMessage(message);

    }
    @Step
    public void verifyUserIsOut(){
        myAccountPage.checkUserIsOut();
    }
}
