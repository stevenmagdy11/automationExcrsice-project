package Pages;

import Pages.productsPages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    By RemoveButtonOfShoppingCartLocator = By.xpath("//a[@class='cart_quantity_delete']");
    By proceedToCheckOut =By.xpath("//a[text()='Proceed To Checkout']");
    By actualTitleOfShoppingCart = By.xpath("//li [@ class='active']");
    String expectedTitleOfShoppingCart ="Shopping Cart";
    By ContinueOnCartLocator =By.xpath("//button[text()='Continue On Cart']");
    By RegisterOrLoginAccountPages =By.xpath("//u[text()='Register / Login']");
    By  PlaceOrderButtonLocator =By.xpath("//a[text()='Place Order']");
    public void clickRemoveButtonOfShoppingCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveButtonOfShoppingCartLocator)).click();

    }
    public void clickProceedToCheckOut()
    {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut)).click();
    }
    public String getExpectedTitleOfShoppingCart()
    {
        return expectedTitleOfShoppingCart;
    }
    public String getActualTitleOfShoppingCart()
    {
        return driver.findElement(actualTitleOfShoppingCart).getText();
    }
    public void clickContinueOnCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ContinueOnCartLocator)).click();
    }
    public void clickRegisterOrLoginAccountPagesButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(RegisterOrLoginAccountPages)).click();
    }
    public void clickPlaceOrderButtonLocator()
    {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderButtonLocator));


        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript("arguments[0].click();", element);
    }






}
