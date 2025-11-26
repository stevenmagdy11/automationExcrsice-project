package stepdefinitions;

import hooks.Hooks;
import Pages.HomePage;
import Pages.SignUpPage;
import Pages.AccountInformationPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SignUpSteps {

    HomePage homePage;
    SignUpPage signUpPage;
    AccountInformationPage accountInformationPage;

    private void initPages() {
        if (homePage == null) {
            homePage = new HomePage(Hooks.getDriver());
        }
    }

    @Given("I navigate to the sign up page")
    public void i_navigate_to_the_sign_up_page() {
        initPages();
        signUpPage = homePage.signUpPage();
    }

    @When("I enter name {string} and email {string}")
    public void i_enter_name_and_email(String name, String email) {
        if (name != null && !name.isEmpty())
            signUpPage.setNameUserSignupLocator(name);
        if (email != null && !email.isEmpty())
            signUpPage.setEmailOfSignUpLocator(email);
    }

    @When("I click the sign up button")
    public void i_click_the_sign_up_button() {
        signUpPage.clickSignUpButton();
    }

    @Then("I should verify sign up status {string}")
    public void i_should_verify_sign_up_status(String isValidStr) {
        boolean isValid = Boolean.parseBoolean(isValidStr);
        if (isValid) {
            accountInformationPage = new AccountInformationPage(Hooks.getDriver());
            try {
                String title = accountInformationPage.getActualTitleOfAccountPage();
                Assert.assertEquals(title, "ENTER ACCOUNT INFORMATION");
            } catch (Exception e) {
                Assert.fail("Failed to navigate to Account Information page: " + e.getMessage());
            }
        } else {
            boolean onAccountPage = false;
            try {
                accountInformationPage = new AccountInformationPage(Hooks.getDriver());
                accountInformationPage.getActualTitleOfAccountPage();
                onAccountPage = true;
            } catch (Exception e) {
                onAccountPage = false;
            }
            Assert.assertFalse(onAccountPage, "Expected NOT to be on Account Information page");
        }
    }
}
