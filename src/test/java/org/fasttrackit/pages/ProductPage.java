package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;

public class ProductPage extends PageObject {

    @FindBy(id = "tab-title-reviews")
    private WebElementFacade reviewsTab;

    @FindBy (css = "a.star-1")
    private WebElementFacade rate1Stars;

    @FindBy (css = "a.star-3")
    private WebElementFacade rate3Stars;

    @FindBy (css = "a.star-5")
    private WebElementFacade rate5Stars;

    @FindBy (id = "comment")
    private WebElementFacade reviewField;

    @FindBy(id = "author")
    private WebElementFacade authorNameField;

    @FindBy(id = "email")
    private WebElementFacade emailAddressField;

    @FindBy (id = "submit")
    private WebElementFacade submitButton;

    @FindBy(css = "input.input-text.qty")
    private WebElementFacade quantityButton;

    @FindBy(css = " .summary.entry-summary button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".button.wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy (css = " p > em")
    private WebElementFacade approvalMessage;



    public void clickReviewsTab(){
        clickOn(reviewsTab);
    }

    public void selectRating1Star () {
        clickOn(rate1Stars);
    }
    public void selectRating3Star () {
        clickOn(rate3Stars);
    }
    public void selectRating5Star () {
        clickOn(rate5Stars);
    }

    public void writeCommentMaxChar(String text){
        typeInto(reviewField, text);

    }
    public void writeReviewComment(){
        typeInto(reviewField, randomReviewGenerator());

    }
    public String randomReviewGenerator() {
        return RandomStringUtils.randomAlphabetic(100);}
    public void fillNameField(String name){
        typeInto(authorNameField, name);
    }
    public void fillEmailAddress(String email){
        typeInto(emailAddressField,email);
    }

    public void clickOnSubmitButton () {
        clickOn(submitButton);
    }

    public boolean checkApprovalMessage (String approval) {
        return approvalMessage.containsText(approval);}

    public void addQuantity(int value) {
        typeInto(quantityButton, String.valueOf(value));
        waitForWithRefresh();
    }
    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }
    public void clickViewCartButton(){
        clickOn(viewCartButton);}


}
