package Tests;

import BaseTest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][]{

                {"", "steve123@gmail.com", false},
                {"steven", "", false},
                {"steven", "invalidEmail", false},
                {"", "", false},
                {"steven", "steve123@gmail.com", true}

        };
    }


    @Test(dataProvider = "signUpData")
    public void ensureValidationOfSignUp(String name, String email, boolean isValid) {
        signUpPage = homePage.signUpPage();

        signUpPage.setNameUserSignupLocator(name);
        signUpPage.setEmailOfSignUpLocator(email);

        signUpPage.clickSignUpButton();


    }
}
