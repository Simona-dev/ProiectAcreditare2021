package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;


public class CartTest extends BaseTest {
    @Steps
    private SearchSteps searchSteps;
    @Steps
    private CartSteps cartSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test
    public void addProductToCartWithoutLogin() {
        loginSteps.navigateToHomePage();
        cartSteps.navigateToShop();
        cartSteps.addBeanieToCart();
        cartSteps.verifyProductInCart();

    }

    @Test
    public void addMultipleProductsToCart() {
        loginSteps.navigateToHomePage();
        cartSteps.addBeanieToCart();
        cartSteps.verifyProductInCart();
        cartSteps.addBeltToCart();
        cartSteps.verifyProductInCart();
        cartSteps.addAlbumToCart();
        cartSteps.verifyProductInCart();
    }

    @Test
    public void addToCartVariableProduct() {
        loginSteps.navigateToHomePage();
        cartSteps.navigateToShop();
        cartSteps.goToProductsPage4();
        cartSteps.addVariableProductToCart();
        cartSteps.verifyProductInCart();
    }

    @Test
    public void removeProductsFromCart() {
        addMultipleProductsToCart();
        cartSteps.emptyCart();
        cartSteps.verifyCartIsEmpty("Your cart is currently empty.");
    }

    @Test
    public void addToCartWithLogin() {
        loginSteps.doLogin();
        cartSteps.addProductInCartWithSearch("Single");
        cartSteps.verifyProductInCart();
        cartSteps.addProductInCartWithSearch("Sunglasses MK");
        cartSteps.verifyProductInCart();

    }
    @Test
    public void removeProductsCartLoggedIn() {
        addToCartWithLogin();
        cartSteps.emptyCart();
        //cartSteps.verifyCartIsEmpty("Your cart is currently empty.");
    }

    @Test
    public void verifyCartTotals() {
        loginSteps.navigateToHomePage();
        cartSteps.addProductInCartWithSearch("Polo");
        cartSteps.addProductInCartWithSearch("Single");
        cartSteps.addProductInCartWithSearch("Sunglasses MK");
        cartSteps.viewCart();
        cartSteps.verifyProductPriceIsCorrect();
    }

    @Test
    public void verifyCartTotalsAfterChangeQuantity() {
        loginSteps.navigateToHomePage();
        cartSteps.addAlbumToCart();
        cartSteps.viewCart();
        cartSteps.changeQuantity(7);
        cartSteps.clickUpdateButton();
        cartSteps.checkTotalCartPrice();
    }

}
