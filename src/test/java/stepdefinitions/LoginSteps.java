package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    HomePage homePage;
    LoginPage loginPage;

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

    @Given("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        initPages();
        loginPage = homePage.openLoginPage();
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password) {
        if (email != null && !email.isEmpty())
            loginPage.setEmailOfLoginLocator(email);
        if (password != null && !password.isEmpty())
            loginPage.setPasswordOfLoginLocator(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should verify login status {string}")
    public void i_should_verify_login_status(String isValidStr) {
        boolean isValid = Boolean.parseBoolean(isValidStr);
        if (isValid) {
            Assert.assertTrue(homePage.isLoggedIn(), "Expected to be logged in");
        } else {
            Assert.assertFalse(homePage.isLoggedIn(), "Expected NOT to be logged in");
        }
    }
}
