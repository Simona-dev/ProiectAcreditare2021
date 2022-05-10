package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.pages.ProductPage;
import org.junit.Assert;

public class ProductSteps {

    private ProductPage productPage;


    @Step
    public void clickReviewTab(){
        productPage.clickReviewsTab();
    }
    @Step
    public void selectRating1Stars() {
        productPage.selectRating1Star();
    }
    @Step
    public void selectRating3Stars () {
        productPage.selectRating3Star();
    }
    @Step
    public void selectRating5Stars () {
        productPage.selectRating5Star();
    }
    @Step
    public void writeReviewComment() {
        productPage.writeReviewComment();;
    }

    @Step
    public void writeReviewCommentMaxChar(String text) {
        productPage.writeCommentMaxChar(text);;
    }
    @Step
    public void clickSubmitButton () {
        productPage.clickOnSubmitButton();
    }

    @Step
    public void checkApproval () {
        Assert.assertTrue(productPage.checkApprovalMessage("Your review is awaiting approval"));
    }
    @Step
    public void writeProductReviewMaxChar (String text) {
        clickReviewTab();
        selectRating5Stars();
        writeReviewCommentMaxChar(text);
        fillName();
        fillEmailAddress();
        clickSubmitButton();
    }

    @Step
    public void writeProductReviewLoggedIn () {
        clickReviewTab();
        selectRating3Stars();
        writeReviewComment();
        clickSubmitButton();
    }
    @Step
    public void fillName(){
        productPage.fillNameField("Name");
    }
    @Step
    public void fillEmailAddress(){
        productPage.fillEmailAddress(randomStringGenerator());
    }
    public String randomStringGenerator() {
        String string = RandomStringUtils.randomAlphanumeric(10) + "@test.ro";
        return string;}

    @Step
    public void changeProductQuantity(int value){
        productPage.addQuantity(value);
    }
    @Step
    public void clickAddToCartButton(){
        productPage.clickAddToCartButton();
    }
    @Step
    public void clickViewCartButton(){
        productPage.clickViewCartButton();
    }


}

