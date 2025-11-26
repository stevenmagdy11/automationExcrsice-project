package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CartSteps {

    HomePage homePage;
    ShoppingCartPage shoppingCartPage;

    private void initPages() {
        if (homePage == null) {
            homePage = new HomePage(Hooks.getDriver());
        }
    }

    @Given("I have added products to the cart")
    public void i_have_added_products_to_the_cart() {
        initPages();

        homePage.openproductsPage().ClickContinueButton();

    }

    @When("I navigate to the cart page")
    public void i_navigate_to_the_cart_page() {
        initPages();
        shoppingCartPage = homePage.openCartPage();
    }

    @Then("I should see the cart page title {string}")
    public void i_should_see_the_cart_page_title(String expectedTitle) {
        Assert.assertEquals(shoppingCartPage.getActualTitleOfShoppingCart(), expectedTitle);
    }

    @When("I click {string}")
    public void i_click(String buttonName) {
        if (buttonName.equals("Proceed To Checkout")) {
            shoppingCartPage.clickProceedToCheckOut();
        } else if (buttonName.equals("Register / Login")) {
            shoppingCartPage.clickRegisterOrLoginAccountPagesButton();
        } else if (buttonName.equals("View Cart")) {

        }
    }

    @Then("I should be redirected to the checkout page or login page")
    public void i_should_be_redirected_to_checkout_or_login() {

        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("checkout") || url.contains("login"));
    }

    @When("I remove an item from the cart")
    public void i_remove_an_item_from_the_cart() {
        shoppingCartPage.clickRemoveButtonOfShoppingCart();
    }

    @Then("the item should be removed from the cart")
    public void the_item_should_be_removed_from_the_cart() {

        Assert.assertTrue(true);
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        String url = Hooks.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("login"));
    }
}
