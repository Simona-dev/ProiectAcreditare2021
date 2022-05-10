package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.pages.AdminPage;
import org.fasttrackit.pages.AdminProductsPage;
import org.fasttrackit.pages.AdminWoocommercePage;

public class AdminSteps {

    private AdminPage adminPage;
    private AdminProductsPage adminProductsPage;
    private AdminWoocommercePage adminWoocommercePage;


    @Step
    public void navigateToAdminPage() {
        adminPage.navigateToAdminPage();
    }

    @Step
    public void enterCredentials(String user, String password) {
        adminPage.setUserLoginField(user);
        adminPage.setUserPasswordField(password);
    }

    @Step
    public void clickLogin() {
        adminPage.clickLoginButton();
    }

    @Step
    public void verifyUserIsLogged(String message) {
        adminPage.checkWelcomeUserMessage(message);
    }

    @Step
    public void doLoginAdminPage(String user, String password) {
        enterCredentials(user, password);
        clickLogin();

    }
    @Step
    public void clickToProducts() {
        adminPage.clickProducts();
    }

    @Step
    public void goToProducts(String user, String password) {
        navigateToAdminPage();
        doLoginAdminPage(user, password);
        clickToProducts();
    }
    @Step
    public void clickAddNew() {
        adminProductsPage.clickAddNewButton();
    }

    @Step
    public void setProductPrice(String value) {
        adminProductsPage.setRegularPrice(value);
    }

    @Step
    public void selectClothingCategory() {
        adminProductsPage.clickClothing();
    }
    @Step
    public void setProductName(String text ) {
        adminProductsPage.setProductName(text);
    }

    @Step
    public void clickPublishButton() {
        adminProductsPage.clickPublishButton1();
    }

    @Step
    public void isProductPublished() {
        adminProductsPage.isProductPublished();
    }

    @Step
    public void clickWoocommerce() {
        adminPage.clickWoocommerce();
    }

    @Step
    public void goToCoupons() {
        clickWoocommerce();
        adminPage.clickCoupons();
    }

    @Step
    public void clickAddCoupon() {
        adminWoocommercePage.setAddCouponButton();
    }
    @Step
    public void checkUpdateCouponMessage(String message){
        adminWoocommercePage.verifyUpdateCouponMessage(message);}

    @Step
    public void selectDiscountTypePercent() {
        adminWoocommercePage.setDiscountFromDropdown("Percentage discount");
    }

    @Step
    public void clickFreeShippingCheckbox() {
        adminWoocommercePage.setFreeShippingCheckbox();

    }

    @Step
    public void fillCouponCodeField(String text) {
        adminWoocommercePage.setCouponCodeField(text);
    }

    @Step
    public void fillCouponAmountField(String value) {
        adminWoocommercePage.setCouponAmountField(value);
    }


    @Step
    public void fillCouponPercentageDetails() {
        fillCouponCodeField("Percentage");
        selectDiscountTypePercent();
        fillCouponAmountField(randomValueGenerator());
        clickFreeShippingCheckbox();
    }
    public String randomValueGenerator() {
        return RandomStringUtils.randomNumeric(1,2);
    }



}
