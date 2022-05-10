package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=6")
public class CheckoutPage extends PageObject {

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameField;

    @FindBy(id= "billing_country")
    private WebElementFacade selectCountry;

    @FindBy(id = "billing_address_1")
    private WebElementFacade streetAddress1Field;

    @FindBy(id = "billing_address_2")
    private WebElementFacade streetAddress2Field;

    @FindBy(id = "billing_city")
    private WebElementFacade cityField;

    @FindBy(id = "billing_state")
    private WebElementFacade selectCounty;

    @FindBy(id = "billing_postcode")
    private WebElementFacade postcodeField;

    @FindBy(id = "billing_phone")
    private WebElementFacade telephoneField;

    @FindBy(id = "billing_email")
    private WebElementFacade emailAddressField;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElementFacade emailErrorMessage;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElementFacade mandatoryFieldErrorMessage;

    @FindBy(css = ".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received")
    private WebElementFacade orderReceivedMessage;

    public void setFirstFiled(String firstname) {
        typeInto(firstNameField, firstname);
    }

    public void setLastField(String lastname) {
        typeInto(lastNameField, lastname);
    }

    public void selectCountry(String country) {
        waitFor(selectCountry);
        selectCountry.selectByVisibleText(country);

    }
    public void setAddress1(String address) {
        typeInto(streetAddress1Field, address);
    }
    public void setAddress2(String address) {
        typeInto(streetAddress2Field, address);
    }

    public void setCity(String city) {
        typeInto(cityField, city);
    }

    public void setCounty(String county){
        waitFor(selectCounty);
        selectCounty.selectByVisibleText(county);
    }
    public void setPostcode(String postcode) {
        typeInto(postcodeField, postcode);
    }

    public void setPhone(String phone) {
        typeInto(telephoneField, phone);
    }

    public void setEmailAddress(String emailAddress){
        typeInto(emailAddressField, emailAddress);
    }

    public boolean checkInvalidEmailError(String errorMessage) {
        return emailErrorMessage.containsText(errorMessage);
    }
    public boolean checkRequiredFieldMessage(String errorMessage) {
        return mandatoryFieldErrorMessage.containsText(errorMessage);
    }
    public void clickOnOrderButton() {
        clickOn(placeOrderButton);
    }

    public void checkOrderReceivedMessage(String message){
        waitFor(orderReceivedMessage);
        orderReceivedMessage.shouldContainOnlyText(message);
    }

    public boolean checkPlaceOrderButton() {
        return placeOrderButton.isDisplayed();

    }
}



