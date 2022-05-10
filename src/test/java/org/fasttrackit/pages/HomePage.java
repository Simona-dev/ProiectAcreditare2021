package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")

public class HomePage extends PageObject {
    @FindBy(css = "#menu-item-69 > a")
    private WebElementFacade homeLink;

    @FindBy(css = "#menu-item-70 > a")
    private WebElementFacade myAccountMenuLink;

    @FindBy(css = "#menu-item-71 > a")
    private WebElementFacade checkoutMenuLink;

    @FindBy(css = "#menu-item-72 > a")
    private WebElementFacade cartMenuLink;

    @FindBy(css = "#menu-item-73 > a")
    private WebElementFacade shopMenuLink;

    @FindBy(css = "div.login-woocommerce > a")
    private WebElementFacade loginLink;

    @FindBy(css = ".view-cart a")
    private WebElementFacade viewCartIcon;

    @FindBy(css = "div.search-form > form > input.search-field")
    private WebElementFacade searchProductField;

    @FindBy(css = ".searchsubmit")
    private WebElementFacade searchButton;

    @FindBy(css = "#search-2 > form > input.search-field")
    private WebElementFacade searchProductMetaField;

    @FindBy(css = "#search-2 > form > button > i")
    private WebElementFacade searchMetaButton;

    @FindBy(css = "#meta-2 > ul > li:nth-child(2) > a")
    private WebElementFacade loginMetaLink;


    public void clickAccountMenuLink() {
        clickOn(myAccountMenuLink);
    }

    public void clickCartMenuLink() {
        clickOn(cartMenuLink);
    }

    public void clickShopLink() {
        clickOn(shopMenuLink);
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void clickViewShoppingCartIcon() {
        clickOn(viewCartIcon);
    }

    public void setSearchProductField(String text) {
        typeInto(searchProductField, text);
    }

    public void clickSearchProductButton() {
        clickOn(searchButton);
    }

    public void setSearchProductsMetaField(String text) {
        typeInto(searchProductMetaField, text);
    }

    public void clickSearchMetaButton() {
        clickOn(searchMetaButton);
    }

    public void clickLoginMetaLink() {
        clickOn(loginMetaLink);
    }

}
