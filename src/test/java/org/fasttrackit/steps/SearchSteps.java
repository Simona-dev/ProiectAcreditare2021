package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;


    @Step
    public void useSearchBar(String text) {
        homePage.setSearchProductField(text);
        homePage.clickSearchProductButton();
    }
    @Step
    public void searchByKeywordMetaMenu(String text) {
        homePage.setSearchProductsMetaField(text);
        homePage. clickSearchMetaButton();
        verifyResultsContains(text);
    }
    @Step
    public void verifyResultsContains(String value) {
        Assert.assertTrue("The product was not found!",
                searchResultsPage.isProductInList(value));
    }

    @Step
    public void isSearchedWordThere(String productName) {
        Assert.assertTrue(searchResultsPage.verifySearchedWord(productName));
    }
    @Step
    public void searchProductByName(String productName){
        useSearchBar(productName);
        isSearchedWordThere(productName);}




}



