package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void ensureAddToItemInCartPage()
    {
       productsPage= homePage.openproductsPage();
       womanCategoryPage.openWomenCategory();
       womanCategoryPage.openWomenDress();
       womanCategoryPage.clickItemOneWomenDressProducts();
       womanCategoryPage.ClickContinueButton();
       homePage.openCartPage();
        Assert.assertTrue(shoppingCartPage.getActualTitleOfShoppingCart().contains(shoppingCartPage.getExpectedTitleOfShoppingCart()));
       shoppingCartPage.clickProceedToCheckOut();

    }
}
