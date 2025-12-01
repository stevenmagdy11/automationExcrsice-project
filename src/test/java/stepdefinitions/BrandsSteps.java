package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.BrandsPages.PoloBrandPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class BrandsSteps {

    HomePage homePage;
    PoloBrandPage poloBrandPage;
    Pages.BrandsPages.GenericBrandPage genericBrandPage;

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
            genericBrandPage = null;
        } else {
            genericBrandPage = homePage.openBrand(brandName);
            poloBrandPage = null;
        }
    }

    @Then("I should see the Polo brand products page")
    public void i_should_see_the_polo_brand_products_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url != null && url.contains("brand_products/Polo"));
    }

    @Then("I should see the {string} brand products page")
    public void i_should_see_the_brand_products_page(String brandName) {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertNotNull(url);
        if (brandName.equals("H&M")) {
            Assert.assertTrue(url.contains("brand_products/H&M") || url.contains("brand_products/H%26M"));
        } else {
            Assert.assertTrue(url.contains("brand_products/" + brandName));
        }
    }

    @Then("I should see {string} brand items")
    public void i_should_see_brand_items(String brandName) {
        String title = "";
        if (poloBrandPage != null) {
            title = poloBrandPage.getBrandTitle();
        } else if (genericBrandPage != null) {
            title = genericBrandPage.getBrandTitle();
        }
        Assert.assertTrue(title.toUpperCase().contains("BRAND - " + brandName.toUpperCase() + " PRODUCTS"));
    }

    @When("I add the first Polo product to the cart")
    public void i_add_the_first_polo_product_to_the_cart() {
        poloBrandPage.clickItemOneOfPoloBrand();
    }

    @When("I add the first {string} product to the cart")
    public void i_add_the_first_brand_product_to_the_cart(String brandName) {
        if (brandName.equalsIgnoreCase("Polo")) {
            poloBrandPage.clickItemOneOfPoloBrand();
        } else if (genericBrandPage != null) {
            genericBrandPage.clickFirstProductAddToCart();
        }
    }

    @When("I click \"View Cart\"")
    public void i_click_view_cart() {
        if (poloBrandPage != null) {
            poloBrandPage.clickViewCartLinkOfPoloBrand();
        } else if (genericBrandPage != null) {
            genericBrandPage.clickViewCart();
        }
    }

    @Then("I should be redirected to the cart page")
    public void i_should_be_redirected_to_the_cart_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url != null && url.contains("view_cart"));
    }

    @When("I click \"Continue Shopping\"")
    public void i_click_continue_shopping() {
        if (poloBrandPage != null) {
            poloBrandPage.clickContinueButtonOfPoloBrand();
        } else if (genericBrandPage != null) {
            genericBrandPage.clickContinueButton();
        }
    }

    @Then("I should remain on the Polo brand products page")
    public void i_should_remain_on_the_polo_brand_products_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url != null && url.contains("brand_products/Polo"));
    }

    @Then("I should remain on the {string} brand products page")
    public void i_should_remain_on_the_brand_products_page(String brandName) {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertNotNull(url);
        if (brandName.equals("H&M")) {
            Assert.assertTrue(url.contains("brand_products/H&M") || url.contains("brand_products/H%26M"));
        } else {
            Assert.assertTrue(url.contains("brand_products/" + brandName));
        }
    }

    @Then("I should see the brands sidebar")
    public void i_should_see_the_brands_sidebar() {
        if (genericBrandPage != null) {
            Assert.assertTrue(genericBrandPage.isBrandsSidebarVisible());
        }
    }

    @Then("I should see at least one product")
    public void i_should_see_at_least_one_product() {
        if (genericBrandPage != null) {
            Assert.assertTrue(genericBrandPage.getProductCount() > 0);
        }
    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String text) {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url != null && url.contains(text));
    }

    @Then("I should see the brand header {string}")
    public void i_should_see_the_brand_header(String header) {
        if (genericBrandPage != null) {
            Assert.assertTrue(genericBrandPage.getBrandTitle().equalsIgnoreCase(header));
        }
    }

    @Then("I should see the brand success message {string}")
    public void i_should_see_the_brand_success_message(String expectedMessage) {
        String actualMessage = "";
        if (poloBrandPage != null) {
            actualMessage = poloBrandPage.getActualMassageWhenAddToCartOfProductPage();
        } else if (genericBrandPage != null) {
            actualMessage = genericBrandPage.getSuccessMessage();
        }
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
