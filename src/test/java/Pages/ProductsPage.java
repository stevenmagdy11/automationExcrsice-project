package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }


    By WomanCategoryLocator = By.xpath("(//a[@data-parent='#accordian'])[1]");
    By ManCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[2]");
    By KidsCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[3]");
    By DressCategoryOfWomanLocator = By.xpath("(//a[text()='Dress '])[1]");
    By TopsCategoryOfWomanLocator = By.xpath("//a[text()='Tops ']");
    By T_shirtsCategoryOfManLocator = By.xpath("//a[text()='Tshirts ']");
    By JeansCategoryOfManLocator = By.xpath("//a[text()='Jeans ']");
    By DressCategoryOfKidsLocator = By.xpath("(//a[text()='Dress '])[2]");
    By TopsAndShirtsOfKidsCategoryLocator = By.xpath("(//a[text()='Tops & Shirts '])");
    By ItemOneWomenDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='3'])[1]");
    By ItemTwoWomanDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='4'])[1]");
    By ClickContinueButtonOfProductsPageLocator =By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage =By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage ="Your product has been added to cart.";
    By ItemOneMenJeansProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='33'])[1]");
    By ItemTwoMenJeansProductsLocator  =By.xpath ("(//a[@class='btn btn-default add-to-cart' and @data-product-id='37'])[1]");
    By ItemOneKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='16'])[1]");
    By ItemTwoKidsDressProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='19'])[1]");



    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    private void clickElement2(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    private void sendKeysWithJS(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            js.executeScript("arguments[0].value='" + value + "';", element);
        }
    }


    public void openWomenCategory() {
        clickElement(WomanCategoryLocator);
    }

    public void openMenCategory() {
        clickElement(ManCategoryLocator);
    }

    public void openKidsCategory() {
        clickElement(KidsCategoryLocator);
    }

    public void openWomenDress() {
        clickElement(DressCategoryOfWomanLocator);
    }

    public void openWomenTops() {
        clickElement(TopsCategoryOfWomanLocator);
    }

    public void openMenTshirts() {
        clickElement(T_shirtsCategoryOfManLocator);
    }

    public void openMenJeans() {
        clickElement(JeansCategoryOfManLocator);
    }

    public void openKidsDress() {
        clickElement(DressCategoryOfKidsLocator);
    }

    public void openKidsTopsAndShirts() {
        clickElement(TopsAndShirtsOfKidsCategoryLocator);
    }

    public String getWomenCategoryText() {
        return driver.findElement(WomanCategoryLocator).getText();
    }

    public void clickItemOneWomenDressProducts()
    {
        clickElement(ItemOneWomenDressProductsLocator);
    }
    public void  clickItemTwoWomenDressProducts()
    {
        clickElement(ItemTwoWomanDressProductsLocator);
    }
    public void ClickContinueButton() {
        clickElement2(ClickContinueButtonOfProductsPageLocator);
    }
    public String getExpectedMassageWhenAddToCartOfProductPage()
    {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }
    public  String getActualMassageWhenAddToCartOfProductPage()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage))).getText();
    }
    public void clickItemOneMenJeansProductsLocator()
    {
        clickElement(ItemOneMenJeansProductsLocator);
    }
    public  void clickItemTwoMenJeansProductsLocator()
    {
        clickElement(ItemTwoMenJeansProductsLocator);
    }

    public  void clickItemOneKidsDressProductsLocator()
    {
        clickElement   (ItemOneKidsDressProductsLocator);
    }

    public  void clickItemTwoKidsDressProductsLocator()
    {
        clickElement   (ItemTwoKidsDressProductsLocator);
    }






}
