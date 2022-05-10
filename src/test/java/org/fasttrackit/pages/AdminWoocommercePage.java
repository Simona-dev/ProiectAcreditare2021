package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminWoocommercePage extends PageObject {
    @FindBy(css = ".page-title-action")//#wpbody-content > div.wrap > a
    private WebElementFacade addCouponButton;
    @FindBy(css = "input#title")
    private WebElementFacade couponCodeField;
    @FindBy(css = "select#discount_type")
    private WebElementFacade discountFromDropdown;
    @FindBy(id = "coupon_amount")
    private WebElementFacade couponAmountField;
    @FindBy(id = "free_shipping")
    private WebElementFacade freeShippingCheckbox;
    @FindBy(css = "#message > p")
    private WebElementFacade updateCouponMessage;

    public void setAddCouponButton() {
        addCouponButton.waitUntilClickable();
        clickOn(addCouponButton);
    }

    public void setCouponCodeField(String text) {
        couponCodeField.waitUntilClickable();
        typeInto(couponCodeField, text);
    }

    public void setDiscountFromDropdown(String value) {
        discountFromDropdown.selectByVisibleText(value);
    }

    public void setCouponAmountField(String value) {
        typeInto(couponAmountField, value);
    }

    public void setFreeShippingCheckbox() {
        clickOn(freeShippingCheckbox);
    }

    public boolean verifyUpdateCouponMessage(String text) {
        waitFor(updateCouponMessage);
        return updateCouponMessage.containsText(text);
    }

}
