package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.BrandsPages.PoloBrandPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class BrandsSteps {

    HomePage homePage;
    PoloBrandPage poloBrandPage;

    private void initPages() {
        if (homePage == null) {
            homePage = new HomePage(Hooks.getDriver());
        }
    }

    @When("I select the {string} brand")
    public void i_select_the_brand(String brandName) {
        initPages();
        if (brandName.equalsIgnoreCase("Polo")) {
            poloBrandPage = homePage.openPoloBrand();
        }
    }

    @Then("I should see the Polo brand products page")
    public void i_should_see_the_polo_brand_products_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("brand_products/Polo"));
    }

    @Then("I should see {string} brand items")
    public void i_should_see_brand_items(String brandName) {
        String title = poloBrandPage.getBrandTitle();
        Assert.assertTrue(title.contains("BRAND - " + brandName.toUpperCase() + " PRODUCTS"));
    }

    @When("I add the first Polo product to the cart")
    public void i_add_the_first_polo_product_to_the_cart() {
        poloBrandPage.clickItemOneOfPoloBrand();
    }

    @When("I click \"View Cart\"")
    public void i_click_view_cart() {
        poloBrandPage.clickViewCartLinkOfPoloBrand();
    }

    @Then("I should be redirected to the cart page")
    public void i_should_be_redirected_to_the_cart_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("view_cart"));
    }

    @When("I click \"Continue Shopping\"")
    public void i_click_continue_shopping() {
        poloBrandPage.clickContinueButtonOfPoloBrand();
    }

    @Then("I should remain on the Polo brand products page")
    public void i_should_remain_on_the_polo_brand_products_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("brand_products/Polo"));
    }
}
