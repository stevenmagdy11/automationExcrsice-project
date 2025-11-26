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

}
