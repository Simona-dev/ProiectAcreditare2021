package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.CheckoutSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class CheckoutTest extends BaseTest {
    @Steps
    CheckoutSteps checkoutSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    CartSteps cartSteps;

    @Test
    public void proceedToCheckoutComplete() {
        loginSteps.navigateToHomePage();
        cartSteps.addProductInCartWithSearch("Polo");
        cartSteps.viewShoppingCart();
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.isPlaceOrderButtonVisible();
    }
    @Test
    public void validCheckout() {
        loginSteps.navigateToHomePage();
        cartSteps.addAlbumToCart();
        cartSteps.viewCart();
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.validBillingDetails();
        checkoutSteps.clickOrderButton();
        checkoutSteps.verifyCheckoutIsComplete("Thank you. Your order has been received.");
    }
    @Test
    public void validCheckoutWithLogin() {
        loginSteps.doLogin();
        validCheckout();
    }

    @Test
    public void invalidCheckout () {
        loginSteps.navigateToHomePage();
        cartSteps.addBeltToCart();
        cartSteps.viewCart();
        cartSteps.clickProceedToCheckoutButton();
        checkoutSteps.invalidBillingDetails();
        checkoutSteps.clickOrderButton();
        checkoutSteps.checkInvalidEmailAddressError(" Billing Email address is not a valid email address.");
    }
    @Test
    public void invalidCheckoutWithLogin () {
        loginSteps.doLogin();
        invalidCheckout();
    }





}

