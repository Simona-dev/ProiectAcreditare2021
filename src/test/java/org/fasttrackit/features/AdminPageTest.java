package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.AdminSteps;
import org.fasttrackit.utils.BaseTest;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class AdminPageTest extends BaseTest {

    @Steps
    private AdminSteps adminSteps;


    @Test
    public void navigateToAdminPage(){
        adminSteps.navigateToAdminPage();
        adminSteps.doLoginAdminPage("admin", "parola11");
        adminSteps.verifyUserIsLogged("Welcome to WordPress!");

    }
    @Test
    public void addNewProduct(){
        adminSteps.goToProducts("admin", "parola11");
        adminSteps.clickAddNew();
        adminSteps.setProductPrice(randomPriceGenerator());
        adminSteps.selectClothingCategory();
        adminSteps.setProductName("Product " + randomNameGenerator());
        adminSteps.clickPublishButton();
        adminSteps.isProductPublished();
    }
    @NotNull
    private String randomNameGenerator() {
        return RandomStringUtils.randomAlphabetic(9);
    }

    @NotNull
    private String randomPriceGenerator() {
        return RandomStringUtils.randomNumeric(2, 4);
    }


    @Test
    public void createCouponPercentage(){
        navigateToAdminPage();
        adminSteps.goToCoupons();
        adminSteps.clickAddCoupon();
        adminSteps.fillCouponPercentageDetails();
        adminSteps.clickPublishButton();
        adminSteps.checkUpdateCouponMessage("Coupon updated.");
    }
    @Test
    public void createCoupon10Percentage(){
        navigateToAdminPage();
        adminSteps.goToCoupons();
        adminSteps.clickAddCoupon();
        adminSteps.fillCouponPercentageDetails();
        adminSteps.clickPublishButton();
        adminSteps.checkUpdateCouponMessage("Coupon updated.");
    }

}
