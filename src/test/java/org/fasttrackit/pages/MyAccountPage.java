package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")

public class MyAccountPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade usernameLoginField;
    @FindBy(id = "password")
    private WebElementFacade passwordLoginField;
    @FindBy(css = "[value*='Login']")
    private WebElementFacade loginButton;
    @FindBy(id = "rememberme")
    private WebElementFacade rememberMeCheckBox;
    @FindBy(id = "reg_email")
    private WebElementFacade emailRegisterField;
    @FindBy(id = "reg_password")
    private WebElementFacade passwordRegisterField;
    @FindBy(css = "#customer_login > div.u-column2.col-2 > form > p.woocommerce-FormRow.form-row > button")
    private WebElementFacade registerButton;
    @FindBy(css = ".welcome-user")
    private WebElementFacade welcomeUserMessage; //after registration and after login
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloParagraph;
    @FindBy(css = "#meta-2 > ul > li:nth-child(2) > a")
    private WebElementFacade logoutMetaLink;
    @FindBy(css = "#login > p.message")
    private WebElementFacade logoutMessageParagraph;
    @FindBy(css = ".logout")
    private WebElementFacade logoutLink;
    @FindBy(css = "#post-1 > div > div > header > h2 > a")
    private WebElementFacade helloWorldMessage;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--orders > a")
    private WebElementFacade ordersLink;
    @FindBy(css = "td.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number")
    List<WebElementFacade> listOfOrders;
    @FindBy(css = "td.woocommerce-orders-table__cell-order-number a")
    private WebElementFacade orderNumber;
    @FindBy(css = "li strong")
    private WebElementFacade errorEmailMessage;


    public void setUsernameLoginField(String text) {
        typeInto(usernameLoginField, text);
    }
    public void setPasswordLoginField(String text) {
        typeInto(passwordLoginField, text);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void clickRememberMeCheckBox() {
        clickOn(rememberMeCheckBox);
    }

    public void setEmailRegisterField(String text) {
        typeInto(emailRegisterField, text);
    }

    public void setPasswordRegisterField(String text) {
        typeInto(passwordRegisterField, text);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void checkWelcomeUserMessage() {
        welcomeUserMessage.shouldContainText("Welcome");
    }

    public void isWelcomeMessageDisplayed() {
        isElementVisible(By.cssSelector("Welcome"));
    }

    public boolean checkLoggedIn(String text) {
        return helloParagraph.containsOnlyText("Hello " + text + " (not " + text + "? Log out)");
    }

    public void clickLogoutMetaLink() {
        clickOn(logoutMetaLink);
    }

    public void clickLogoutLink() {
        clickOn(logoutLink);
    }
    public void clickOrdersLink(){
        clickOn(ordersLink);
    }

    public boolean checkExistingOrder(String text) {
        for (WebElementFacade orderNumber : listOfOrders) {
            if (orderNumber.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public void checkLogoutMessage(String message) {
        logoutMessageParagraph.shouldContainText(message);
    }
    public void checkUserIsOut(){
        helloWorldMessage.isDisplayed();
    }
    public void checkErrorMessageDisplayed(){
        errorEmailMessage.isDisplayed();
    }

}
