package Pages.BrandsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PoloBrandPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    WebElement element;

    public PoloBrandPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;

    }

    By PoloBrandButtonLocator = By.xpath("(//span[@class='pull-right'])[1]");
    By ItemOneOfPoloBrandLocator = By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='1'])[1]");
    By ContinueButtonOfPoloBrandLocator = By.cssSelector("button.close-modal.btn-success.btn");
    By ItemTwoOfPoloBrandLocator = By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='8'])[1]");
    By ViewCartLinkOfPoloBrandLocator = By.xpath("//u[text()='View Cart']");
    By ActualMassageWhenAddToCartOfProductPage = By.xpath("//p[text()='Your product has been added to cart.']");
    By BrandTitleLocator = By.cssSelector(".features_items > h2");

    public String getActualMassageWhenAddToCartOfProductPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ActualMassageWhenAddToCartOfProductPage))
                .getText();
    }

    public String getBrandTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(BrandTitleLocator)).getText();
    }

    public void clickPoloBrandButton() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PoloBrandButtonLocator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript("arguments[0].click();", element);
    }

    public void clickItemOneOfPoloBrand() {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(ItemOneOfPoloBrandLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
        js.executeScript("arguments[0].click();", element1);
    }

    public void clickItemTwoOfPoloBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(ItemTwoOfPoloBrandLocator)).click();
    }

    public void clickContinueButtonOfPoloBrand() {
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOfPoloBrandLocator));
       element2.click();

    }

    public void clickViewCartLinkOfPoloBrand() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ViewCartLinkOfPoloBrandLocator)).click();
    }

}
