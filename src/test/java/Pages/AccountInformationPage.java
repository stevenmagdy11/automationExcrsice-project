package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountInformationPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    By selectedGenderOfMaleLocator = By.id("id_gender1");
    By selectedGenderOfFemaleLocator = By.id("id_gender2");
    By nameLocator = By.id("name");
    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By DateOfBirthLocator = By.id("days");
    By MonthOfBirthLocator = By.id("months");
    By YearOfBirthLocator = By.id("years");
    By newsletterButtonLocator = By.id("newsletter");
    By checkBoxButtonOfPartners = By.id("partners");
    By FriNameLocator = By.id("first_name");
    By LasNameLocator = By.id("last_name");
    By companyLocator = By.id("company");
    By addressOneLocator = By.id("address1");
    By AddressTwoLocator = By.id("address2");
    By countryLocator = By.id("country");
    By stateLocator = By.id("state");
    By cityLocator = By.id("city");
    By zipcodeLocator = By.id("zipcode");
    By mobileNumberLocator = By.id("mobile_number");
    By createAccountLocator = By.xpath("(//button[@type='submit'])[1]");
    By ActualTitleOfAccountPage =By.xpath("//b[text()='Enter Account Information']");
    String ExpectedTitleOfAccountPage ="ENTER ACCOUNT INFORMATION";


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

    public void selectMaleGender() {
        wait.until(ExpectedConditions.elementToBeClickable(selectedGenderOfMaleLocator)).click();
    }

    public void selectFemaleGender() {
        wait.until(ExpectedConditions.elementToBeClickable(selectedGenderOfFemaleLocator)).click();
    }

    public void setName(String name) {
        sendKeysWithJS(nameLocator, name);
    }

    public void setEmail(String email) {
        sendKeysWithJS(emailLocator, email);
    }

    public void setPassword(String password) {
        sendKeysWithJS(passwordLocator, password);
    }

    public void setDay(String day) {
        sendKeysWithJS(DateOfBirthLocator, day);
    }

    public void setMonth(String month) {
        sendKeysWithJS(MonthOfBirthLocator, month);
    }

    public void setYear(String year) {
        sendKeysWithJS(YearOfBirthLocator, year);
    }

    public void clickNewsletter() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterButtonLocator)).click();
    }

    public void clickPartners() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxButtonOfPartners)).click();
    }

    public void setFirstName(String firstName) {
        sendKeysWithJS(FriNameLocator, firstName);
    }

    public void setLastName(String lastName) {
        sendKeysWithJS(LasNameLocator, lastName);
    }

    public void setCompany(String company) {
        sendKeysWithJS(companyLocator, company);
    }

    public void setAddressOne(String address1) {
        sendKeysWithJS(addressOneLocator, address1);
    }

    public void setAddressTwo(String address2) {
        sendKeysWithJS(AddressTwoLocator, address2);
    }

    public void setCountry(String country) {
        sendKeysWithJS(countryLocator, country);
    }

    public void setState(String state) {
        sendKeysWithJS(stateLocator, state);
    }

    public void setCity(String city) {
        sendKeysWithJS(cityLocator, city);
    }

    public void setZipcode(String zipcode) {
        sendKeysWithJS(zipcodeLocator, zipcode);
    }

    public void setMobileNumber(String mobile) {
        sendKeysWithJS(mobileNumberLocator, mobile);
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLocator)).click();
    }
    public String getExpectedTitleOfAccountPage()
    {
        return ExpectedTitleOfAccountPage;
    }
    public String getActualTitleOfAccountPage()
    {
        return driver.findElement(ActualTitleOfAccountPage).getText();
    }

}
