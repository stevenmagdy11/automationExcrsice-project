package stepdefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShoppingCartPage;
import hooks.Hooks;
import Pages.PaymentCheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    PaymentCheckoutPage paymentCheckoutPage;
    HomePage homePage;
    LoginPage loginPage = new LoginPage(Hooks.getDriver());
    ShoppingCartPage shoppingCartPage =new ShoppingCartPage(Hooks.getDriver());


    public CheckoutSteps() {
        paymentCheckoutPage = new PaymentCheckoutPage(Hooks.getDriver());
    }
    private void initPages() {
        if (homePage == null) {
            homePage = new HomePage(Hooks.getDriver());
        }
    }
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        initPages();
        String title = Hooks.getDriver().getTitle();
        Assert.assertEquals(title, "Automation Exercise");
    }

    @Given("I am logged in")
    public void i_am_logged_in() {

        initPages();
        loginPage=homePage.openLoginPage();
            loginPage.setEmailOfLoginLocator("steve123@gmail.com");

            loginPage.setPasswordOfLoginLocator("steve123456");
            loginPage.clickLoginButton();


    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {

    }

    @When("I enter payment details:")
    public void i_enter_payment_details(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        String nameOfCard = data.get("Name on Card");
        String cardNumber = data.get("Card Number");
        String cvc = data.get("CVC");
        int month = Integer.parseInt(data.get("Expiration Month"));
        int year = Integer.parseInt(data.get("Expiration Year"));

        paymentCheckoutPage.setNameOnCardOfPymentCheckOut(nameOfCard);
        paymentCheckoutPage.setCardNumberOfPymentCheckOut(cardNumber);
        paymentCheckoutPage.setCVCOfPymentCheckOut(cvc);
        paymentCheckoutPage.setExpiryMonthOfPymentCheckOut(month);
        paymentCheckoutPage.setExpiryYearOfPymentCheckOut(year);
    }

    @When("I click \"Pay and Confirm Order\"")
    public void i_click_pay_and_confirm_order() {
        paymentCheckoutPage.clickConfirmOrderButton();
    }

    @Then("I should see the order confirmation message {string}")
    public void i_should_see_the_order_confirmation_message(String expectedMessage) {
        Assert.assertEquals(paymentCheckoutPage.getActualMassageOrderConfirmed(), expectedMessage);
    }

    @Then("I should not see the order confirmation message")
    public void i_should_not_see_the_order_confirmation_message() {
        try {
            String msg = paymentCheckoutPage.getActualMassageOrderConfirmed();
            Assert.fail("Confirmation message should not be visible, but found: " + msg);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Then("I should see the address details")
    public void i_should_see_the_address_details() {
    }

    @Then("I should see the order review")
    public void i_should_see_the_order_review() {
    }

    @And("I click Proceed To Checkout")
    public void iClickProceedToCheckout() {
        initPages();
        shoppingCartPage.clickProceedToCheckOut();
        shoppingCartPage.clickRegisterOrLoginAccountPagesButton();
        loginPage.setEmailOfLoginLocator("stevenmagdy100@gmail.com");
        loginPage.setPasswordOfLoginLocator("steve123456");
        loginPage.clickLoginButton();
        homePage.openCartPage();
        shoppingCartPage.clickProceedToCheckOut();
        shoppingCartPage.clickPlaceOrderButtonLocator();


    }

    @And("I click Pay and Confirm Order")
    public void iClickPayAndConfirmOrder() {
        initPages();
        paymentCheckoutPage.clickConfirmOrderButton();
    }
}
