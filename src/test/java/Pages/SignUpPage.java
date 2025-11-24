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
    public SignUpPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }
    By NameUserSignupLocator =By.xpath("//input[@type='text']");
    By emailOfSignUpLocator =By.xpath("(//input[@type='email'])[2]");
    By signUpButtonLocator =By.xpath("(//button[@type='submit'])[2]");

    public void setEmailOfSignUpLocator(String emailOfSignUp)
    {
        driver.findElement(emailOfSignUpLocator).sendKeys(emailOfSignUp);
    }
    public void setNameUserSignupLocator(String nameUserSignup)
    {
        driver.findElement(NameUserSignupLocator).sendKeys(nameUserSignup);
    }
    public void clickSignUpButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator)).click();
    }


}
