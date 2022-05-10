package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?post_type=product")

public class ShopProductsPage extends PageObject {

    @FindBy(css = "ul > li.post-26.product")
    private WebElementFacade beanieProduct;

    @FindBy(css = "ul > li.post-27.product")
    private WebElementFacade beltProduct;

    @FindBy(css = "ul > li.post-33.product")
    private WebElementFacade poloProduct;

    @FindBy(css = "div.summary.entry-summary  button")
    private WebElementFacade addToCartButton;

    @FindBy(css = "button wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy(className = "woocommerce-message")
    private WebElementFacade confirmMessage;

    @FindBy(css = "ul > li.post-34.product")
    private WebElementFacade albumProduct;

    @FindBy(css = "li.post-22.product")
    private WebElementFacade vNeckTShirtVariableProduct;

    @FindBy(css = "[name='attribute_pa_color']")
    private WebElementFacade selectColorFromDropdown;

    @FindBy(id = "pa_size")
    private WebElementFacade selectSizeFromDropdown;

    @FindBy(css = "#primary > div > nav > ul > li:nth-child(2)")
    private WebElementFacade goToPage2;

    @FindBy(css = "#primary > div > nav > ul > li:nth-child(4)")
    private WebElementFacade goToPage4;


    public void clickBeanieProduct(){
        clickOn(beanieProduct);
    }
    public void clickBeltProduct(){
        clickOn(beltProduct);
    }
    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }
    public boolean isAddedToCart(){
        return confirmMessage.containsText("has been added to your cart");
    }
    public void clickAlbumProduct(){
        clickOn(albumProduct);
    }

    public void clickVNeckTShirtVariableProduct(){
        clickOn(vNeckTShirtVariableProduct);
    }

    public void selectColorFromDropdown(String value){
        selectColorFromDropdown.selectByVisibleText(value);
    }
    public void selectSizeFromDropdown(String value){
        selectSizeFromDropdown.selectByVisibleText(value);
    }
    public void clickGoToPage2(){
        clickOn(goToPage2);
    }
    public void clickGoToPage4(){
        clickOn(goToPage4);
    }

    public void clickPoloProduct() {
        clickOn(poloProduct);
    }
}
