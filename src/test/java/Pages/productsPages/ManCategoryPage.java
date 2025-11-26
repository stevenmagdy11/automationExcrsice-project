package Pages.productsPages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManCategoryPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public ManCategoryPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;

    }
    By ManCategoryLocator = By.xpath("(//a[@data-toggle='collapse'])[2]");

    By T_shirtsCategoryOfManLocator = By.xpath("//a[text()='Tshirts ']");
    By JeansCategoryOfManLocator = By.xpath("//a[text()='Jeans ']");

    By ClickContinueButtonOfProductsPageLocator =By.xpath("//button[text()='Continue Shopping']");
    By ActualMassageWhenAddToCartOfProductPage =By.xpath("//p[text()='Your product has been added to cart.']");
    String ExpectedMassageWhenAddToCartOfProductPage ="Your product has been added to cart.";
    By ItemOneMenJeansProductsLocator =By.xpath("(//a[@class='btn btn-default add-to-cart' and @data-product-id='33'])[1]");
    By ItemTwoMenJeansProductsLocator  =By.xpath ("(//a[@class='btn btn-default add-to-cart' and @data-product-id='37'])[1]");


    private void clickElementOneOfManCategoryPage(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    private void clickElementTwoOfManCategoryPage(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    public void openMenCategory() {
        clickElementOneOfManCategoryPage(ManCategoryLocator);
    }

    public void openMenTshirts() {
        clickElementOneOfManCategoryPage(T_shirtsCategoryOfManLocator);
    }

    public void openMenJeans() {
        clickElementTwoOfManCategoryPage(JeansCategoryOfManLocator);
    }
    public void clickItemOneMenJeansProductsLocator()
    {
        clickElementOneOfManCategoryPage(ItemOneMenJeansProductsLocator);
    }
    public  void clickItemTwoMenJeansProductsLocator()
    {
        clickElementTwoOfManCategoryPage(ItemTwoMenJeansProductsLocator);
    }
    public void ClickContinueButton() {
        clickElementTwoOfManCategoryPage(ClickContinueButtonOfProductsPageLocator);
    }
    public String getExpectedMassageWhenAddToCartOfProductPage()
    {
        return ExpectedMassageWhenAddToCartOfProductPage;
    }
    public  String getActualMassageWhenAddToCartOfProductPage()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(ActualMassageWhenAddToCartOfProductPage))).getText();
    }


}
