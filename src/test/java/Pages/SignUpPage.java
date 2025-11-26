package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    By NameUserSignupLocator = By.xpath("//input[@data-qa='signup-name']");
    By emailOfSignUpLocator = By.xpath("//input[@data-qa='signup-email']");
    By signUpButtonLocator = By.xpath("//button[@data-qa='signup-button']");
    By errorMessageLocator = By.xpath("//form[@action='/signup']/p");

    public void setEmailOfSignUpLocator(String emailOfSignUp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOfSignUpLocator)).sendKeys(emailOfSignUp);
    }

    public void setNameUserSignupLocator(String nameUserSignup) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameUserSignupLocator)).sendKeys(nameUserSignup);
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }

}
