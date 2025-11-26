package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PymentCheckOutTest extends BaseTest {

    @Test
    public void ensureValidationDataOfPymentCheckOut()
    {
        loginPage=homePage.openLoginPage();
        loginPage.setEmailOfLoginLocator("steve123@gmail.com");
        loginPage.setPasswordOfLoginLocator("steve123456");
        loginPage.clickLoginButton();
        homePage.openproductsPage();
        womanCategoryPage.openWomenCategory();
        womanCategoryPage.openWomenDress();
        womanCategoryPage.clickItemOneWomenDressProducts();
        womanCategoryPage.ClickContinueButton();
        shoppingCartPage=homePage.openCartPage();
        shoppingCartPage.clickProceedToCheckOut();
        shoppingCartPage.clickPlaceOrderButtonLocator();
        paymentCheckoutPage.setNameOnCardOfPymentCheckOut("steve");
        paymentCheckoutPage.setCardNumberOfPymentCheckOut("192837465");
        paymentCheckoutPage.setCVCOfPymentCheckOut("10");
        paymentCheckoutPage.setExpiryMonthOfPymentCheckOut(10);
        paymentCheckoutPage.setExpiryYearOfPymentCheckOut(2004);
        paymentCheckoutPage.clickConfirmOrderButton();
        Assert.assertTrue(paymentCheckoutPage.getActualMassageOrderConfirmed().contains(paymentCheckoutPage.getExpectedMassageOrderConfirmed()));


    }

}
