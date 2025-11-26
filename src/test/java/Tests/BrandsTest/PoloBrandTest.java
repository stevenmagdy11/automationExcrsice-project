package Tests.BrandsTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class PoloBrandTest extends BaseTest {

    @Test
    public void  ensureValidationPoloBrand()
    {
       productsPage= homePage.openproductsPage();
       poloBrandPage.clickPoloBrandButton();
       poloBrandPage.clickItemOneOfPoloBrand();;
       poloBrandPage.clickContinueButtonOfPoloBrand();
    

    }
}
