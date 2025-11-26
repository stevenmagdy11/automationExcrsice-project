package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentCheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentCheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    By NameOnCardOfPymentCheckOutLocator = By.xpath("//input[@class='form-control']");
    By CardNumberOfPymentCheckOutLocator = By.name("card_number");
    By CVCOfPymentCheckOutLocator = By.name("cvc");
    By expiryMonthOfPymentCheckOutLocator = By.name("expiry_month");
    By expiryYearOfPymentCheckOutLocator = By.name("expiry_year");
    By ConfirmOrderButtonLocator = By.id("submit");
    By actualMassageOrderConfirmed = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    String expectedMassageOrderConfirmed ="Congratulations! Your order has been confirmed!";


    private WebElement waitAndClear(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        return element;
    }


    public void setNameOnCardOfPymentCheckOut(String nameOnCard) {
        waitAndClear(NameOnCardOfPymentCheckOutLocator).sendKeys(nameOnCard);
    }

    public void setCardNumberOfPymentCheckOut(String cardNumber) {
        waitAndClear(CardNumberOfPymentCheckOutLocator).sendKeys(cardNumber);
    }

    public void setCVCOfPymentCheckOut(String cvcOfPymentCheckOut) {
        waitAndClear(CVCOfPymentCheckOutLocator).sendKeys(cvcOfPymentCheckOut);
    }

    public void setExpiryMonthOfPymentCheckOut(int expiryMonthOfPymentCheckOut) {
        waitAndClear(expiryMonthOfPymentCheckOutLocator).sendKeys(String.valueOf(expiryMonthOfPymentCheckOut));
    }

    public void setExpiryYearOfPymentCheckOut(int expiryYearOfPymentCheckOut) {
        waitAndClear(expiryYearOfPymentCheckOutLocator).sendKeys(String.valueOf(expiryYearOfPymentCheckOut));
    }

    public void clickConfirmOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrderButtonLocator)).click();
    }
    public String getExpectedMassageOrderConfirmed()
    {
        return expectedMassageOrderConfirmed;
    }
    public String getActualMassageOrderConfirmed()
    {
        return driver.findElement(actualMassageOrderConfirmed).getText();
    }
}
