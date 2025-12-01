package Pages;

import Pages.BrandsPages.PoloBrandPage;
import Pages.productsPages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    By openLoginOrSignUpPageLocator = By.xpath("//a [text()=' Signup / Login']");
    By openProductsPageLocator = By.xpath("//a[text()=' Products']");
    By cartButton = By.linkText("Cart");
    By PoloBrandButtonLocator = By.xpath("(//span[@class='pull-right'])[1]");
    By loggedInAsLocator = By.xpath("//li/a[contains(text(), 'Logged in as')]");
    By contactUsButton = By.xpath("//a[text()=' Contact us']");
    By testCasesButton = By.xpath("//a[text()=' Test Cases']");
    By subscriptionInput = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By subscriptionSuccessMessage = By.id("success-subscribe");
    By footer = By.id("footer");

    public boolean isLoggedIn() {
        try {
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(loggedInAsLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public LoginPage openLoginPage() {
        driver.findElement(openLoginOrSignUpPageLocator).click();
        return new LoginPage(driver);

    }

    public SignUpPage signUpPage() {
        driver.findElement(openLoginOrSignUpPageLocator).click();
        return new SignUpPage(driver);
    }

    public ProductsPage openproductsPage() {
        driver.findElement(openProductsPageLocator).click();
        return new ProductsPage(driver);
    }

    public ShoppingCartPage openCartPage() {
        driver.findElement(cartButton).click();
        return new ShoppingCartPage(driver);
    }

    public PoloBrandPage openPoloBrand() {
        driver.findElement(PoloBrandButtonLocator).click();
        return new PoloBrandPage(driver);
    }



    public TestCasesPage openTestCasesPage() {
        driver.findElement(testCasesButton).click();
        return new TestCasesPage(driver);
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionInput).sendKeys(email);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribeButton).click();
    }

    public void subscribe(String email) {
        enterSubscriptionEmail(email);
        clickSubscribeButton();
    }

    public String getSubscriptionSuccessMessage() {
        return wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                .visibilityOfElementLocated(subscriptionSuccessMessage)).getText();
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        try {
            return wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                    .visibilityOfElementLocated(subscriptionSuccessMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToFooter() {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(footer));
    }

    public boolean isFooterVisible() {
        return driver.findElement(footer).isDisplayed();
    }

    public boolean isSubscriptionInputVisible() {
        return driver.findElement(subscriptionInput).isDisplayed();
    }

    public Pages.BrandsPages.GenericBrandPage openBrand(String brandName) {
        By brandLocator = By.xpath("//div[@class='brands_products']//a[contains(text(),'" + brandName + "')]");
        org.openqa.selenium.WebElement element = wait
                .until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(brandLocator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        return new Pages.BrandsPages.GenericBrandPage(driver, brandName);
    }

}
