package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.MyAccountPage;
import org.junit.Assert;

public class OrdersSteps {
    private MyAccountPage myAccountPage;

    @Step
    public void goToOrders(){
        myAccountPage.clickOrdersLink();

    }
    @Step
    public void checkExistingOrders () {
        Assert.assertTrue(myAccountPage.checkExistingOrder("#767"));
    }


}
