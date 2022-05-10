package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.fasttrackit.pages.ShopProductsPage;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

public class CartSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ShopProductsPage shopProductsPage;
    private CartPage cartPage;


    @Step
    public void navigateToShop() {
        homePage.clickShopLink();
    }


    @Step
    public void addBeanieToCart() {
        navigateToShop();
        shopProductsPage.clickBeanieProduct();
        shopProductsPage.clickAddToCartButton();

    }

    @Step
    public void addBeltToCart() {
        navigateToShop();
        shopProductsPage.clickBeltProduct();
        shopProductsPage.clickAddToCartButton();
    }

    @Step
    public void addAlbumToCart() {
        navigateToShop();
        shopProductsPage.clickAlbumProduct();
        shopProductsPage.clickAddToCartButton();
    }
    @Step
    public void addVariableProductToCart(){
        shopProductsPage.clickVNeckTShirtVariableProduct();
        shopProductsPage.selectColorFromDropdown("Green");
        shopProductsPage.selectSizeFromDropdown("Medium");
        shopProductsPage.clickAddToCartButton();
    }
    @Step
    public void goToProductsPage2(){
        shopProductsPage.clickGoToPage2();
    }

    @Step
    public void goToProductsPage4(){
        shopProductsPage.clickGoToPage4();
    }

    @Step
    public void verifyProductInCart() {
        Assert.assertTrue(shopProductsPage.isAddedToCart());

    }
    @Step
    public void emptyCart() {
        viewCart();
        cartPage.removeProductsFromCart();
    }

    @Step
    public void verifyCartIsEmpty(String text) {

        cartPage.checkEmptyCartMessage(text);
    }

    @Step
    public void isEmptyCartMessageDisplayed(String text) {
        Assert.assertTrue(cartPage.isEmptyCartTextDisplayed(text));}

    @Step
    public void isReturnToShopButtonVisible() {
        cartPage.isReturnToShopButtonDisplayed();
    }
    @Step
    public void getEmptyCartTextParagraph(@NotNull String text) {
        Assert.assertEquals(text.toLowerCase(), cartPage.getEmptyCartText().toLowerCase());
    }

    @Step
    public void removeItem() {
        viewCart();
        cartPage.clickRemoveIcon();
    }
    @Step
    public void addProductInCartWithSearch(String text) {
        homePage.setSearchProductField(text);
        homePage.clickSearchProductButton();
        searchResultsPage.clickAddToCartButton();
    }
    @Step
    public void viewCart() {
        homePage.clickCartMenuLink();
    }
    @Step
    public void viewShoppingCart() {
        homePage.clickViewShoppingCartIcon();
    }
    @Step
    public void verifyProductPriceIsCorrect() {
        Assert.assertTrue(cartPage.isCartTotalCalculatedCorrectly());
    }
    @Step
    public void clickProceedToCheckoutButton() {
        cartPage.clickProceedToCheckoutButton();
    }
    @Step
    public void changeQuantity(int value) {
        cartPage.addQuantity(value);
    }
    @Step
    public void checkTotalCartPrice () {
        Assert.assertTrue(cartPage.checkProductQuantity());
    }
    @Step
    public void clickUpdateButton (){
        cartPage.clickOnUpdateCart();
    }
    @Step
    public void verifyQuantityIsChanged() {
        Assert.assertTrue(cartPage.checkQuantityIsChanged());
    }
    @Step
    public void inputCouponCode(String text){
        cartPage.setCouponCodeField(text);
    }
    @Step
    public void clickApplyCouponButton (){
        cartPage.clickApplyCouponButton();
    }
    @Step
    public void verifyCouponAppliedCorrectly(){
        Assert.assertTrue(cartPage.checkCouponIsApplied());
    }
    @Step
    public void addPoloToCart() {
        navigateToShop();
        shopProductsPage.clickGoToPage2();
        shopProductsPage.clickPoloProduct();
        shopProductsPage.clickAddToCartButton();
    }
}

