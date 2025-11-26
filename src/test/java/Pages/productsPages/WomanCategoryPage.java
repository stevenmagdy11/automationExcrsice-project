package Pages.productsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WomanCategoryPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public WomanCategoryPage(WebDriver driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }
    By WomanCategoryLocator = By.xpath("(//a[@data-parent='#accordian'])[1]");
    By DressCategoryOfWomanLocator = By.xpath("(//a[text()='Dress '])[1]");
    By TopsCategoryOfWomanLocator = By.xpath("//a[text()='Tops ']");
    By ItemOneWomenDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='3'])[1]");
    By ItemTwoWomanDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='4'])[1]");
    By ClickContinueButtonOfProductsPageLocator =By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage =By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage ="Your product has been added to cart.";


    private void clickElementOfWomanCategory(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    private void clickElement2OfWomanCategory(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void openWomenCategory() {
        clickElementOfWomanCategory(WomanCategoryLocator);
    }

    public String getWomenCategoryText() {
        return driver.findElement(WomanCategoryLocator).getText();
    }
    public void openWomenDress() {
        clickElementOfWomanCategory(DressCategoryOfWomanLocator);
    }

    public void openWomenTops() {
        clickElementOfWomanCategory(TopsCategoryOfWomanLocator);
    }
    public void clickItemOneWomenDressProducts()
    {
        clickElementOfWomanCategory(ItemOneWomenDressProductsLocator);
    }
    public void  clickItemTwoWomenDressProducts()
    {
        clickElementOfWomanCategory(ItemTwoWomanDressProductsLocator);
    }
    public String getExpectedMassageWhenAddToCartOfProductPageInWomanCategoryPage()
    {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }
    public  String getActualMassageWhenAddToCartOfProductPageInWomanCategoryPage()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage))).getText();
    }
    public void ClickContinueButton() {
        clickElement2OfWomanCategory(ClickContinueButtonOfProductsPageLocator);
    }


}
