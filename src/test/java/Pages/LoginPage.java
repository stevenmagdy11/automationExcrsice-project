package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

    }

    By emailOfLoginLocator = By.xpath("//input[@data-qa='login-email']");
    By passwordOfLoginLocator = By.xpath("//input[@data-qa='login-password']");
    By clickLoginButtonLocator = By.xpath("//button[@data-qa='login-button']");
    By errorMessageLocator = By.xpath("//form[@action='/login']/p");

    public void setEmailOfLoginLocator(String emailOfLogin) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOfLoginLocator)).sendKeys(emailOfLogin);
    }

    public void setPasswordOfLoginLocator(String passwordOfLogin) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordOfLoginLocator)).sendKeys(passwordOfLogin);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickLoginButtonLocator)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }

}
