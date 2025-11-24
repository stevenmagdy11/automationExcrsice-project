package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public  HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    By openLoginOrSignUpPageLocator =By.xpath("//a [text()=' Signup / Login']");
    By openProductsPageLocator =By.xpath("//a[text()=' Products']");

public LoginPage openLoginPage()
{
    driver.findElement(openLoginOrSignUpPageLocator).click();
    return new LoginPage(driver);

}
public SignUpPage signUpPage()
{
    driver.findElement(openLoginOrSignUpPageLocator).click();
    return new SignUpPage(driver);
}
public ProductsPage openproductsPage()
{
    driver.findElement(openProductsPageLocator).click();
    return new ProductsPage(driver);
}





}
