package Tests.ProductsTest;
import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManCategoryTest extends BaseTest
{

    @Test
    public void ensureAddToCartOfManCategoryPage()
    {
        productsPage=homePage.openproductsPage();
        manCategoryPage.openMenCategory();
        manCategoryPage.openMenJeans();
        manCategoryPage.clickItemOneMenJeansProductsLocator();

        Assert.assertTrue(manCategoryPage.getActualMassageWhenAddToCartOfProductPage().contains(manCategoryPage.getExpectedMassageWhenAddToCartOfProductPage()));
        manCategoryPage.ClickContinueButton();
        manCategoryPage.clickItemTwoMenJeansProductsLocator();

        Assert.assertTrue(manCategoryPage.getActualMassageWhenAddToCartOfProductPage().contains(manCategoryPage.getExpectedMassageWhenAddToCartOfProductPage()));
    }
}
