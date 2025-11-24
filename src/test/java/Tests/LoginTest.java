package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest  extends BaseTest {
    @Test
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{

                {"wrong@gmail.com", "steve123456", false},
                {"", "steve123456", false},
                {"steve123@gmail.com", "", false},
                {"steve123@gmail.com", "steve123456", true}
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password, boolean isValid) {


        loginPage = homePage.openLoginPage();

        loginPage.setEmailOfLoginLocator(email);
        loginPage.setPasswordOfLoginLocator(password);
        loginPage.clickLoginButton();





    }

}
