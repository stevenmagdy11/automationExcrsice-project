package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(20));

    }
    By emailOfLoginLocator =By.xpath("(//input[@type='email'])[1]");
    By passwordOfLoginLocator =By.xpath("(//input[@type='password'])[1]");
    By clickLoginButtonLocator = By.xpath("(//button[@type='submit'])[1]");

    public void setEmailOfLoginLocator(String emailOfLogin)
    {
        driver.findElement(emailOfLoginLocator).sendKeys(emailOfLogin);
    }

    public void setPasswordOfLoginLocator(String  passwordOfLogin)
    {
        driver.findElement(passwordOfLoginLocator).sendKeys(passwordOfLogin);
    }
    public void clickLoginButton()
    {
       wait.until(ExpectedConditions.elementToBeClickable(clickLoginButtonLocator)).click();
    }



}
