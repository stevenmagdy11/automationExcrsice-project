package Tests.ProductsTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KidsCategoryTest extends BaseTest
{
    @Test
    public void ensureValidationSelectedKidsCategory()
    {
       productsPage= homePage.openproductsPage();
       kidsCategoryPage.openKidsCategory();
       kidsCategoryPage.openKidsDress();
       kidsCategoryPage.clickItemOneKidsDressProductsLocator();

       Assert.assertTrue(kidsCategoryPage.getActualMassageWhenAddToCartOfProductPage().contains(kidsCategoryPage.getExpectedMassageWhenAddToCartOfProductPage()));
       kidsCategoryPage.ClickContinueButton();
       kidsCategoryPage.clickItemTwoKidsDressProductsLocator();
       Assert.assertEquals(kidsCategoryPage.getActualMassageWhenAddToCartOfProductPage(),kidsCategoryPage.getExpectedMassageWhenAddToCartOfProductPage(),"is not matched massage");
       kidsCategoryPage.ClickContinueButton();
    }



}
