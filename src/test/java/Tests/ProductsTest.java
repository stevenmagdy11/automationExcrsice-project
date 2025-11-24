package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void ensureValidationSelectedWomanCategory()
    {
        productsPage=homePage.openproductsPage();
      productsPage.openWomenCategory();
        productsPage.openWomenDress();
        productsPage.clickItemOneWomenDressProducts();

        Assert.assertTrue(productsPage.getActualMassageWhenAddToCartOfProductPage().contains(productsPage.getExpectedMassageWhenAddToCartOfProductPage()));
        productsPage.ClickContinueButton();
        productsPage.clickItemTwoWomenDressProducts();
        Assert.assertEquals(productsPage.getActualMassageWhenAddToCartOfProductPage(),productsPage.getExpectedMassageWhenAddToCartOfProductPage(),"is not matched massage");

        productsPage.ClickContinueButton();

    }
    @Test
    public  void ensureValidationSelectedManCategory()
    {
        productsPage=homePage.openproductsPage();
        productsPage.openMenCategory();
        productsPage.openMenJeans();
        productsPage.clickItemOneMenJeansProductsLocator();
        Assert.assertTrue(productsPage.getActualMassageWhenAddToCartOfProductPage().contains(productsPage.getExpectedMassageWhenAddToCartOfProductPage()));
        productsPage.ClickContinueButton();
        productsPage.clickItemTwoMenJeansProductsLocator();
        Assert.assertTrue(productsPage.getActualMassageWhenAddToCartOfProductPage().contains(productsPage.getExpectedMassageWhenAddToCartOfProductPage()));

    }
    @Test
    public  void ensureValidationSelectedKidsCategory()
    {
       productsPage= homePage.openproductsPage();
       productsPage.openKidsCategory();
       productsPage.openKidsCategory();
       productsPage.openKidsDress();
       productsPage.clickItemOneKidsDressProductsLocator();

       Assert.assertTrue(productsPage.getActualMassageWhenAddToCartOfProductPage().contains(productsPage.getExpectedMassageWhenAddToCartOfProductPage()));
        productsPage.ClickContinueButton();
       productsPage.clickItemTwoKidsDressProductsLocator();
       Assert.assertTrue(productsPage.getActualMassageWhenAddToCartOfProductPage().contains(productsPage.getExpectedMassageWhenAddToCartOfProductPage()));
       productsPage.ClickContinueButton();

        }
       

    }



