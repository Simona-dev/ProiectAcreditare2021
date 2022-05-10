package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CheckoutPage;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;

    @Step
    public void setFirstName() {
        checkoutPage.setFirstFiled("Ana");
    }

    @Step
    public void setLastName() {
        checkoutPage.setLastField("Blandiana");
    }

    @Step
    public void selectCountry() {
        checkoutPage.selectCountry("Romania");
    }

    @Step
    public void fillAddress() {
        checkoutPage.setAddress1("Strada Observatorului 3");
        checkoutPage.setAddress2("");
    }

    @Step
    public void fillCity() {
        checkoutPage.setCity("CN");
    }

    @Step
    public void selectCounty(){
        checkoutPage.setCounty("Cluj");
    }

    @Step
    public void fillPostcode() {
        checkoutPage.setPostcode("11111");
    }

    @Step
    public void completeValidPhone() {
        checkoutPage.setPhone("0123456789");
    }

    @Step
    public void completeValidEmailAddress(){
        checkoutPage.setEmailAddress("anablandiana2@test.ro");
    }
    @Step
    public void completeInvalidEmailAddress(){
        checkoutPage.setEmailAddress("anablandiana2test.ro");
    }

    @Step
    public void completeInvalidPhone() {
        checkoutPage.setPhone("1");
    }

    @Step
    public void checkInvalidEmailAddressError(String message) {
        checkoutPage.checkInvalidEmailError(message);
    }

    @Step
    public void clickOrderButton() {
        checkoutPage.clickOnOrderButton();

    }
    @Step
    public void validBillingDetails(){
        setFirstName();
        setLastName();
        selectCountry();
        fillAddress();
        fillCity();
        selectCounty();
        fillPostcode();
        completeValidPhone();
        completeValidEmailAddress();}

    @Step
    public void verifyCheckoutIsComplete(String text){
        checkoutPage.checkOrderReceivedMessage(text);}
    @Step
    public void invalidBillingDetails(){
        setFirstName();
        setLastName();
        selectCountry();
        fillAddress();
        fillCity();
        selectCounty();
        fillPostcode();
        completeValidPhone();;
        completeInvalidEmailAddress();

    }
    public void isPlaceOrderButtonVisible() {
        checkoutPage.checkPlaceOrderButton();
    }
}

