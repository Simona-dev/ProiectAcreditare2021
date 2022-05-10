package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.ProductSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private SearchSteps searchSteps;
    @Steps
    private ProductSteps productSteps;
    @Steps
    private CartSteps cartSteps;

    @Test
    public void selectProductQuantityBeforeAddToCart(){
        loginSteps.navigateToHomePage();
        searchSteps.useSearchBar("Long Sleeve Tee");
        productSteps.changeProductQuantity(3);
        productSteps.clickAddToCartButton();
        productSteps.clickViewCartButton();
        cartSteps.verifyQuantityIsChanged();
    }

    @Test
    public void writeReviewWithLogin() {
        loginSteps.navigateToHomePage();
        loginSteps.doLogin();
        searchSteps.useSearchBar("Beanie with logo");
        productSteps.clickReviewTab();
        productSteps.writeProductReviewLoggedIn();
        productSteps.checkApproval();
    }

    @Test
    public void checkReviewMaximumLength() {
        loginSteps.navigateToHomePage();
        searchSteps.useSearchBar("Cap");
        productSteps.clickReviewTab();
        productSteps.writeProductReviewMaxChar(randomReviewLenghtGenerator());
        productSteps.checkApproval();
    }
    public String randomReviewLenghtGenerator() {
        String review = RandomStringUtils.randomAlphabetic(10000);
        return review;}


}
