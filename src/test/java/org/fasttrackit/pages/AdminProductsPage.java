package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class AdminProductsPage extends PageObject {
    @FindBy(css = "#wpbody-content > div.wrap > a:nth-child(2)")
    private WebElementFacade addNewButton;
    @FindBy(id = "title")
    private WebElementFacade productNameField;
    @FindBy(css = "#popular-product_cat-15 > label")
    private WebElementFacade uncategorizedCategory;
    @FindBy(css = "ul#product_catchecklist-pop > li:nth-of-type(2) > .selectit")
    private WebElementFacade clothingCategory;
    @FindBy(id = "product-type")
    private WebElementFacade selectDropdownType;
    @FindBy(css = "#post-750 > td.name.column-name.has-row-actions.column-primary > strong > a")
    private WebElementFacade albumTestProduct;
    @FindBy(css = ".selectit #in-product_cat-15")
    private WebElementFacade clickUncategorizedCategory;
    @FindBy(css = "#wp-excerpt-media-buttons > button")
    private WebElementFacade addMediaButton;
    @FindBy(css = "#__attachments-view-220 > li:nth-child(11) > div > div")
    private WebElementFacade clickImageOfProduct; //sunglasses
    @FindBy(css = "#__wp-uploader-id-3 > div.media-frame-toolbar > div > div.media-toolbar-primary.search-form > button")
    private WebElementFacade insertIntoProductButton;
    @FindBy(css = "#_regular_price")
    private WebElementFacade regularPriceField;
    @FindBy(css = "#_sale_price")
    private WebElementFacade salePriceField;
    @FindBy(css = "#_sku")
    private WebElementFacade sKUCodeField;
    @FindBy(css = "li.inventory_options.inventory_tab.show_if_simple.show_if_variable.show_if_grouped.show_if_external.active > a > span")
    private WebElementFacade clickInventory;
    @FindBy(css = "#_manage_stock")
    private WebElementFacade manageStockCheckbox;
    @FindBy(css = "#_stock")
    private WebElementFacade stockQuantityField;
    @FindBy(css = "#tinymce")
    private WebElementFacade shortDescriptionField;
    @FindBy(id = "publish")
    private WebElementFacade publishButton;
    @FindBy(css = "#message > p > a")
    private WebElementFacade viewProductLink;
    @FindBy(css = "#cb-select")
    private WebElementFacade selectCheckboxProduct;
    @FindBy(css = "#bulk-action-selector-top")
    private WebElementFacade selectBulkAction;
    @FindBy(css = "#doaction2")
    private WebElementFacade applyButton;
    @FindBy(css = "#delete-action > a")
    private WebElementFacade moveToTrashLink;
    @FindBy(css = ".updated > p")
    private WebElementFacade deletedProductsMessage;
    @FindBy(css = "#product_cat-tabs > li:nth-child(1) > a")
    private WebElementFacade allCategory;
    @FindBy(css = "#product_catdiv > h2 > span")
    private WebElementFacade productCategory;


    public void clickAddNewButton() {
        clickOn(addNewButton);
    }

    public void setProductName(String name) {
        typeInto(productNameField, name);
    }

    public void clickClothing() {
        clickOn(clothingCategory);
    }

    public void setRegularPrice(String value) {
        typeInto(regularPriceField, value);
    }
    public void clickPublishButton1() {
        WebElement element = getDriver().findElement(By.id("publish"));
        element.click();
    }
    public boolean isProductPublished() {
        viewProductLink.isDisplayed();
        return false;
    }


}
