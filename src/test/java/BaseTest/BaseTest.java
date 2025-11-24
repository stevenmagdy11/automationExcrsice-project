package BaseTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
protected  HomePage homePage;
protected LoginPage loginPage;
protected SignUpPage signUpPage;
protected ProductsPage productsPage;
protected AccountInformationPage accountInformationPage;
    @BeforeClass
    public void setup(){
        driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage=new HomePage(driver);
    }
    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://automationexercise.com/");

    }
 /*   @AfterClass
    public void teardown(){
        driver.quit();
    }*/
}
