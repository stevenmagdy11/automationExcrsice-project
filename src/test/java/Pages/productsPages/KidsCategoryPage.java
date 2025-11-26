package Pages.productsPages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KidsCategoryPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public KidsCategoryPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;

    }
    By KidsCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[3]");

    By DressCategoryOfKidsLocator = By.xpath("(//a[text()='Dress '])[2]");
    By TopsAndShirtsOfKidsCategoryLocator = By.xpath("(//a[text()='Tops & Shirts '])");

    By ClickContinueButtonOfProductsPageLocator =By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage =By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage ="Your product has been added to cart.";

    By ItemOneKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='16'])[1]");
    By ItemTwoKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='19'])[1]");

    private void clickElementOneOfKidsCategoryPage(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    private void clickElementTwoOfKidsCategoryPage(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    public void openKidsCategory() {
        clickElementOneOfKidsCategoryPage(KidsCategoryLocator);
    }


    public void ClickContinueButton() {
        clickElementTwoOfKidsCategoryPage(ClickContinueButtonOfProductsPageLocator);
    }

    public void openKidsDress() {
        clickElementOneOfKidsCategoryPage(DressCategoryOfKidsLocator);
    }

    public void openKidsTopsAndShirts() {
        clickElementOneOfKidsCategoryPage(TopsAndShirtsOfKidsCategoryLocator);
    }
    public String getExpectedMassageWhenAddToCartOfProductPage()
    {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }
    public  String getActualMassageWhenAddToCartOfProductPage()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage))).getText();
    }


    public  void clickItemOneKidsDressProductsLocator()
    {
        clickElementOneOfKidsCategoryPage(ItemOneKidsDressProductsLocator);
    }

    public  void clickItemTwoKidsDressProductsLocator()
    {
        clickElementOneOfKidsCategoryPage(ItemTwoKidsDressProductsLocator);
    }


}
