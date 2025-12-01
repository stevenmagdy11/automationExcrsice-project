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

    By ClickContinueButtonOfProductsPageLocator = By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage = By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage = "Your product has been added to cart.";

    By ItemOneKidsDressProductsLocator = By
            .xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='16'])[1]");
    By ItemTwoKidsDressProductsLocator = By
            .xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='19'])[1]");

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchedProductsHeader = By.xpath("//h2[contains(@class, 'title') and text()='SEARCHED PRODUCTS']");
    By productNames = By.xpath("//div[@class='productinfo text-center']/p");
    By addToCartButtons = By.xpath("//a[contains(@class, 'add-to-cart')]");

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

    public String getExpectedMassageWhenAddToCartOfProductPage() {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }

    public String getActualMassageWhenAddToCartOfProductPage() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage)))
                .getText();
    }

    public void enterSearchQuery(String query) {
        sendKeysWithJS(searchInput, query);
    }

    public void searchProduct(String query) {
        enterSearchQuery(query);
        clickSearchButton();
    }

    public void clickSearchButton() {
        clickElement(searchButton);
    }

    public boolean isSearchedProductsHeaderVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public java.util.List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public void addFirstSearchedProductToCart() {
        java.util.List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (!buttons.isEmpty()) {
            // The first button might be overlay, need to be careful.
            // Usually the first visible one.
            for (WebElement btn : buttons) {
                if (btn.isDisplayed()) {
                    btn.click();
                    break;
                }
            }
        }
    }

    public String getSearchInputPlaceholder() {
        return driver.findElement(searchInput).getAttribute("placeholder");
    }

}
