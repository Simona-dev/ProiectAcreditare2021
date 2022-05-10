package org.fasttrackit.pages;

import com.sun.istack.NotNull;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Integer.parseInt;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")

public class CartPage extends PageObject {

    @FindBy(css = "td.product-remove > a")
    private WebElementFacade removeIcon;

    @FindBy(css = ".cart-empty ")
    private WebElementFacade emptyCartParagraph;

    @FindBy(css = "#post-5 > div > div > div > div.woocommerce > p.return-to-shop > a")
    private WebElementFacade returnToShopButton;

    @FindBy(css = " div  td.product-subtotal ")
    private List<WebElementFacade> listOfPrices;

    @FindBy(css = ".product-price  > span")
    private WebElementFacade productPrice;

    @FindBy(css = " .product-subtotal .woocommerce-Price-amount")
    private WebElementFacade totalProductPrice;

    @FindBy(css = ".order-total strong")
    private WebElementFacade totalPrice;

    @FindBy(css = "tr.cart-discount.coupon-percentage > td > span")
    private WebElementFacade couponPercentageAmount;

    @FindBy(css = "button[name='update_cart']")
    private WebElementFacade updateButton;

    @FindBy(css = "input.input-text.qty")
    private WebElementFacade quantityButton;

    @FindBy(className = "checkout-button")
    private WebElementFacade checkoutButton;
    @FindBy(css = "input#coupon_code")
    private WebElementFacade couponCodeField;
    @FindBy(css = "input[name='apply_coupon']")
    private WebElementFacade applyCouponButton;


    public void removeProductsFromCart() {
        waitFor(checkoutButton);
        while (checkoutButton.isVisible()) {
            List<WebElement> listOfElements = getDriver().findElements(By.cssSelector("td.product-remove > a"));
            if (listOfElements.size() != 0) {
                listOfElements.get(0).click();
                getDriver().get("http://qa5.fasttrackit.org:8008/?page_id=5");
            } else {
                break;
            }
        }
    }

    public void clickRemoveIcon() {
        clickOn(removeIcon);
    }

    public void checkEmptyCartMessage(String message) {
        waitForWithRefresh();
        emptyCartParagraph.shouldContainOnlyText(message);
    }

    public String getEmptyCartText() {
        return emptyCartParagraph.getText();
    }

    public boolean isEmptyCartTextDisplayed(String text) {
        System.out.println(emptyCartParagraph.getText());
        return emptyCartParagraph.containsOnlyText(text);
    }

    public boolean isReturnToShopButtonDisplayed() {
        return returnToShopButton.isDisplayed();
    }

    public int getProductPricesSum() {
        int priceTotalCalculated = 0;
        for (WebElementFacade element : listOfPrices) {
            priceTotalCalculated += getPriceFromElementCart(element);
        }
        return priceTotalCalculated;

    }

    private int getPriceFromElementCart(@NotNull WebElementFacade elementFacade) {
        return parseInt(elementFacade.getText().replaceFirst("lei", "")
                .replaceAll(".00", ""));

    }

    public int getTotalPrice() {
        return getPriceFromElementCart(totalPrice);
    }

    public boolean isCartTotalCalculatedCorrectly() {
        System.out.println("productPricesSum is " + getProductPricesSum());
        System.out.println("totalPriceIs " + getTotalPrice());
        return (getProductPricesSum() == getTotalPrice());
    }

    public void clickProceedToCheckoutButton() {
        waitFor(checkoutButton);
        clickOn(checkoutButton);
    }

    public void addQuantity(int value) {
        typeInto(quantityButton, String.valueOf(value));
    }

    public void clickOnUpdateCart() {
        clickOn(updateButton);
    }

    public boolean checkProductQuantity() {
        waitFor(totalProductPrice);
        int priceTotal = getPriceFromElementCart(totalProductPrice);
        int priceTotalCart = getPriceFromElementCart(totalPrice);

        System.out.println("priceTotal: " + priceTotal);
        System.out.println("priceTotalCart: " + priceTotalCart);
        return priceTotal == priceTotalCart;


    }

    public boolean checkQuantityIsChanged() {
        waitFor(totalProductPrice);
        int priceProduct = getPriceFromElementCart(productPrice);
        int priceTotal = getPriceFromElementCart(totalProductPrice);
        System.out.println("priceOfProduct: " + priceProduct);
        System.out.println("priceProductTotal : " + priceTotal);
        return priceTotal != priceProduct;

    }

    public void setCouponCodeField(String text) {
        typeInto(couponCodeField, text);
    }

    public void clickApplyCouponButton() {
        clickOn(applyCouponButton);
    }

    public boolean checkCouponIsApplied() {
        waitForWithRefresh();
        waitFor(waitFor(totalPrice));
        int subtotal = getPriceFromElementCart(totalProductPrice);
        int couponAmount = getPriceFromElementCart(couponPercentageAmount);


        System.out.println("Coupon percentage value is: " + (getTotalPrice() - subtotal));

        return getTotalPrice() == (subtotal + couponAmount);
    }


}
