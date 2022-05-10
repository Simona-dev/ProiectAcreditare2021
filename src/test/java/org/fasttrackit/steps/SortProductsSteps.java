package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SortProductsSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void verifySortByPriceAscending() {
        setSortByPrice();
        Assert.assertTrue("Price is not ordered ascending!",
                searchResultsPage.isSortByPriceAscending());
    }
    @Step
    public void verifySortByPriceDescending() {
        setSortByPriceDesc();
        Assert.assertTrue("Price is not ordered descending!",
                searchResultsPage.isSortByPriceDescending());
    }
    @Step
    public void setSortByPrice() {
        searchResultsPage.setSortByDropdown("Sort by price: low to high");
    }
    @Step
    public void setSortByPriceDesc() {
        searchResultsPage.setSortByDropdown("Sort by price: high to low");
    }
    @Step
    public void setSortByPopularity() {
        searchResultsPage.setSortByDropdown("Sort by popularity");
    }
    @Step
    public void setSortByRating() {
        searchResultsPage.setSortByDropdown("Sort by average rating");
    }
    @Step
    public void setSortByDate() {
        searchResultsPage.setSortByDropdown("Sort by newness");
    }
    @Step
    public void setSortByRelevance() {
        searchResultsPage.setSortByDropdown("Relevance");
    }





}
