package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.productsPages.ProductsPage;
import Pages.productsPages.ManCategoryPage;
import Pages.productsPages.KidsCategoryPage;
import Pages.productsPages.WomanCategoryPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductsSteps {

    HomePage homePage;
    ProductsPage productsPage;
    WomanCategoryPage womanCategoryPage;
    ManCategoryPage manCategoryPage;
    KidsCategoryPage kidsCategoryPage;

    private void initPages() {
        if (homePage == null) {
            homePage = new HomePage(Hooks.getDriver());
        }
    }

    @Given("I navigate to the products page")
    public void i_navigate_to_the_products_page() {
        initPages();
        productsPage = homePage.openproductsPage();
    }

    @When("I open the Women category")
    public void i_open_the_women_category() {
        womanCategoryPage = new WomanCategoryPage(Hooks.getDriver());
        womanCategoryPage.openWomenCategory();
    }

    @When("I select the Dress subcategory")
    public void i_select_the_dress_subcategory() {
        womanCategoryPage.openWomenDress();
    }

    @When("I add the first dress to the cart")
    public void i_add_the_first_dress_to_the_cart() {
        womanCategoryPage.clickItemOneWomenDressProducts();
    }

    @When("I open the Men category")
    public void i_open_the_men_category() {
        manCategoryPage = new ManCategoryPage(Hooks.getDriver());
        manCategoryPage.openMenCategory();
    }

    @When("I select the Jeans subcategory")
    public void i_select_the_jeans_subcategory() {
        manCategoryPage.openMenJeans();
    }

    @When("I add the first jeans to the cart")
    public void i_add_the_first_jeans_to_the_cart() {
        manCategoryPage.clickItemOneMenJeansProductsLocator();
    }

    @When("I open the Kids category")
    public void i_open_the_kids_category() {
        kidsCategoryPage = new KidsCategoryPage(Hooks.getDriver());
        kidsCategoryPage.openKidsCategory();
    }

    @When("I select the Kids Dress subcategory")
    public void i_select_the_kids_dress_subcategory() {
        kidsCategoryPage.openKidsDress();
    }

    @When("I add the first kids dress to the cart")
    public void i_add_the_first_kids_dress_to_the_cart() {
        kidsCategoryPage.clickItemOneKidsDressProductsLocator();
    }

    @When("I select the T-shirts subcategory")
    public void i_select_the_t_shirts_subcategory() {
        manCategoryPage.openMenTshirts();
    }

    @Then("I should see the Men T-shirts products")
    public void i_should_see_the_men_t_shirts_products() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url != null && url.contains("Tshirts"), "Expected URL to contain 'Tshirts'");
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String expectedMessage) {
        String actualMessage = "";
        if (womanCategoryPage != null) {
            try {
                actualMessage = womanCategoryPage.getActualMassageWhenAddToCartOfProductPageInWomanCategoryPage();
            } catch (Exception e) {
            }
        }
        if (actualMessage.isEmpty() && manCategoryPage != null) {
            try {
                actualMessage = manCategoryPage.getActualMassageWhenAddToCartOfProductPage();
            } catch (Exception e) {
            }
        }
        if (actualMessage.isEmpty() && kidsCategoryPage != null) {
            try {
                actualMessage = kidsCategoryPage.getActualMassageWhenAddToCartOfProductPage();
            } catch (Exception e) {
            }
        }
        // Check PoloBrandPage if others failed
        if (actualMessage.isEmpty()) {
            try {
                Pages.BrandsPages.PoloBrandPage poloBrandPage = new Pages.BrandsPages.PoloBrandPage(Hooks.getDriver());
                actualMessage = poloBrandPage.getActualMassageWhenAddToCartOfProductPage();
            } catch (Exception e) {
            }
        }
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
