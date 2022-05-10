package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.OrdersSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class OrdersTest extends BaseTest {
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private OrdersSteps ordersSteps;

    @Test
    public void existingOrders() {
        loginSteps.doLogin();
        loginSteps.clickMyAccountLink();
        ordersSteps.goToOrders();
        ordersSteps.checkExistingOrders();
    }
}

