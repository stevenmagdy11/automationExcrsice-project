package Pages.productsPages;

import Pages.ShoppingCartPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    protected ShoppingCartPage shoppingCartPage;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }



    By ManCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[2]");
    By KidsCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[3]");



    By ClickContinueButtonOfProductsPageLocator =By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage =By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage ="Your product has been added to cart.";

    By ItemOneKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='16'])[1]");
    By ItemTwoKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='19'])[1]");



    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    private void clickElement2(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    private void sendKeysWithJS(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            js.executeScript("arguments[0].value='" + value + "';", element);
        }
    }




    public void ClickContinueButton() {
        clickElement(ClickContinueButtonOfProductsPageLocator);
    }
    public String getExpectedMassageWhenAddToCartOfProductPage()
    {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }
    public  String getActualMassageWhenAddToCartOfProductPage()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage))).getText();
    }








}
