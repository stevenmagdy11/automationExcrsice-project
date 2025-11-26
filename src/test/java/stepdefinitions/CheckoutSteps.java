package stepdefinitions;

import hooks.Hooks;
import Pages.PaymentCheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class CheckoutSteps {

    PaymentCheckoutPage paymentCheckoutPage;

    public CheckoutSteps() {
        paymentCheckoutPage = new PaymentCheckoutPage(Hooks.getDriver());
    }

    @Given("I am logged in")
    public void i_am_logged_in() {

    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {

    }

    @When("I enter payment details:")
    public void i_enter_payment_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> paymentData = data.get(0);

        paymentCheckoutPage.setNameOnCardOfPymentCheckOut(paymentData.get("Name on Card"));
        paymentCheckoutPage.setCardNumberOfPymentCheckOut(paymentData.get("Card Number"));
        paymentCheckoutPage.setCVCOfPymentCheckOut(paymentData.get("CVC"));
        paymentCheckoutPage.setExpiryMonthOfPymentCheckOut(Integer.parseInt(paymentData.get("Expiration Month")));
        paymentCheckoutPage.setExpiryYearOfPymentCheckOut(Integer.parseInt(paymentData.get("Expiration Year")));
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
}
