package Tests.BrandsTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class PoloBrandTest extends BaseTest {

    @Test
    public void  ensureValidationPoloBrand() throws InterruptedException {
       productsPage= homePage.openproductsPage();
       poloBrandPage.clickPoloBrandButton();
       poloBrandPage.clickItemOneOfPoloBrand();
       Thread.sleep(3000);
       poloBrandPage.clickContinueButtonOfPoloBrand();
    

    }
}
