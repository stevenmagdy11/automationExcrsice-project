package BaseTest;

import Pages.*;
import Pages.BrandsPages.PoloBrandPage;
import Pages.productsPages.KidsCategoryPage;
import Pages.productsPages.ManCategoryPage;
import Pages.productsPages.ProductsPage;
import Pages.productsPages.WomanCategoryPage;
import org.openqa.selenium.WebDriver;
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
    public WomanCategoryPage womanCategoryPage;
    public ManCategoryPage manCategoryPage;
    public KidsCategoryPage kidsCategoryPage;
    public ShoppingCartPage shoppingCartPage;
    public PaymentCheckoutPage paymentCheckoutPage;
    protected PoloBrandPage poloBrandPage;
    @BeforeClass
    public void setup(){
        driver =new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage=new HomePage(driver);  homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        productsPage = new ProductsPage(driver);
        accountInformationPage = new AccountInformationPage(driver);
        womanCategoryPage = new WomanCategoryPage(driver);
        manCategoryPage =new ManCategoryPage(driver);
        kidsCategoryPage=new KidsCategoryPage(driver);
        shoppingCartPage =new ShoppingCartPage(driver);
        paymentCheckoutPage= new PaymentCheckoutPage(driver);
        poloBrandPage =new PoloBrandPage(driver);



    }
    @BeforeMethod
    public void goToHomePage(){
        driver.get("https://automationexercise.com/");

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
