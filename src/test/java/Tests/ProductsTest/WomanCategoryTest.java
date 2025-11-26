package Tests.ProductsTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WomanCategoryTest extends BaseTest {


    @Test
    public void ensureAddToCartOfWomanCategoryPage()
    {
       productsPage= homePage.openproductsPage();
       womanCategoryPage.openWomenCategory();
       womanCategoryPage.openWomenDress();
       womanCategoryPage.clickItemOneWomenDressProducts();
       Assert.assertTrue(womanCategoryPage.getActualMassageWhenAddToCartOfProductPageInWomanCategoryPage().contains(womanCategoryPage.getExpectedMassageWhenAddToCartOfProductPageInWomanCategoryPage()));

       womanCategoryPage.ClickContinueButton();
    }
}
