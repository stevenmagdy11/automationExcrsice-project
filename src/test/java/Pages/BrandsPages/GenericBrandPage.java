package Pages.BrandsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class GenericBrandPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String brandName;

    public GenericBrandPage(WebDriver driver, String brandName) {
        this.driver = driver;
        this.brandName = brandName;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    By brandTitleLocator = By.cssSelector(".features_items > h2");
    By addToCartButton = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    By continueButton = By.xpath("//button[text()='Continue Shopping']");
    By viewCartLink = By.xpath("//u[text()='View Cart']");
    By successMessage = By.xpath("//p[text()='Your product has been added to cart.']");
    By productItems = By.className("single-products");
    By brandsSidebar = By.className("brands_products");

    public String getBrandTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(brandTitleLocator)).getText();
    }

    public void clickFirstProductAddToCart() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void clickContinueButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        js.executeScript("arguments[0].click();", element);
    }

    public void clickViewCart() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        js.executeScript("arguments[0].click();", element);
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public int getProductCount() {
        List<WebElement> products = driver.findElements(productItems);
        return products.size();
    }

    public boolean isBrandsSidebarVisible() {
        return driver.findElement(brandsSidebar).isDisplayed();
    }
}
