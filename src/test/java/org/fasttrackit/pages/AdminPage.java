package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-login.php")
public class AdminPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade userLoginField;

    @FindBy(id = "user_pass")
    private WebElementFacade userPasswordField;

    @FindBy(id = "wp-submit")
    private WebElementFacade loginButton;

    @FindBy(css = "#welcome-panel > div > h2")
    private WebElementFacade welcomeMessage;

    @FindBy(css = "#wp-admin-bar-menu-toggle")
    private WebElementFacade menuToggle;

    @FindBy(css = "#menu-posts > a ")
    private WebElementFacade postsMenu;

    @FindBy(css = "#menu-media > a ")
    private WebElementFacade mediaMenu;

    @FindBy(css = "#menu-pages > a ")
    private WebElementFacade pagesMenu;

    @FindBy(css = "#menu-comments > a ")
    private WebElementFacade commentsMenu;

    @FindBy(css = "#toplevel_page_woocommerce > a")
    private WebElementFacade woocommerceMenu;

    @FindBy(css = "#toplevel_page_woocommerce > ul > li:nth-child(3) > a")
    private WebElementFacade couponsTab;

    @FindBy(css = "#toplevel_page_woocommerce > ul > li.current > a")
    private WebElementFacade reportsTab;

    @FindBy(css = "#menu-posts-product > a")
    private WebElementFacade productsMenu;

    @FindBy(css = "#menu-users > a")
    private WebElementFacade usersMenu;



    public void navigateToAdminPage(){
        open();
    }
    public void setUserLoginField(String value){
        typeInto(userLoginField, value);
    }
    public void setUserPasswordField(String value){
        typeInto(userPasswordField, value);
    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }
    public void checkWelcomeUserMessage(String message) {
        welcomeMessage.shouldContainText(message);
    }

    public void clickWoocommerce() {
        clickOn(woocommerceMenu);
    }

    public void clickCoupons() {
        clickOn(couponsTab);
    }

    public void clickProducts() {
        clickOn(productsMenu);
    }



}
