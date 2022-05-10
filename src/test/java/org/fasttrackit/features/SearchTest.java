package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.steps.SortProductsSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {
    @Steps
    private SearchSteps searchSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private SortProductsSteps sortProductsSteps;

    @Test
    public void searchProductByWord() {
        loginSteps.navigateToHomePage();
        searchSteps.searchProductByName("Sunglasses");
        searchSteps.verifyResultsContains("Sunglasses SP");
    }
    @Test
    public void searchProductByWordMetaMenu(){
        loginSteps.navigateToHomePage();
        searchSteps.searchByKeywordMetaMenu("Beanie");
        searchSteps.verifyResultsContains("Beanie with logo");
    }
    @Test
    public void checkSortByPriceAscendingFunction(){
        loginSteps.navigateToHomePage();
        searchSteps.useSearchBar("banner");
        sortProductsSteps.setSortByPrice();
        sortProductsSteps.verifySortByPriceAscending();
    }
    @Test
    public void checkSortByPriceDescendingFunction(){
        loginSteps.navigateToHomePage();
        searchSteps.useSearchBar("Sunglasses");
        sortProductsSteps.setSortByPriceDesc();
        sortProductsSteps.verifySortByPriceDescending();

    }




}
