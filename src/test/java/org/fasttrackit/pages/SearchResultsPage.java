package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.util.List;


public class SearchResultsPage extends PageObject {

    @FindBy(css = " li.post-633.product")
    private WebElementFacade SunglassesMK;

    @FindBy(css = "li.product")
    private List<WebElementFacade> listOfProducts;

    @FindBy(className = "collection_title")
    private List<WebElementFacade>  listProductNames;

    @FindBy(css = " li.post-500.product")
    private WebElementFacade SpecialEditionWordPressBannerK;

    @FindBy(css = ".orderby ")
    private WebElementFacade sortByDropdown;

    @FindBy(css = " .summary.entry-summary button")
    private WebElementFacade addToCartButton;

    public boolean isProductInList(String productName) {
        for (WebElementFacade element : listOfProducts)
            if (element.findElement(By.cssSelector(".collection_title"))
                    .getText().equalsIgnoreCase(productName)) {
                return true;
            }
        return false;
    }

    public void setSortByDropdown(String value){
        sortByDropdown.selectByVisibleText(value);

    }
    private int getPriceFromProduct(@NotNull WebElementFacade element){
        return Integer.parseInt(element.find(By.cssSelector(".price")).getText().replaceAll("lei","").replace(".00",""));

    }
    public boolean isSortByPriceDescending() {
        int firstPrice = getPriceFromProduct(listOfProducts.get(0));
        int lastPrice = getPriceFromProduct(listOfProducts.get(listOfProducts.size()-1));
        if (firstPrice>=lastPrice)
            return true;
        return false;
    }

    public boolean isSortByPriceAscending() {
        int firstPrice = getPriceFromProduct(listOfProducts.get(0));
        int lastPrice = getPriceFromProduct(listOfProducts.get(listOfProducts.size()-1));
        if (firstPrice<=lastPrice)
            return true;
        return false;
    }

    public boolean verifySearchedWord(String productName) {
        for (WebElementFacade elementFacade : listOfProducts){
            System.out.println("actual product text: " +elementFacade.findElement(By.cssSelector(".collection_title"))
                    .getText() );
            System.out.println("expected product text: " + productName);
            if (elementFacade.findElement(By.cssSelector(".collection_title"))
                    .getText().equalsIgnoreCase(productName)){
                return true; }
        }
        return false;
    }
    public void clickAddToCartButton(){
        clickOn(addToCartButton);

    }
}
