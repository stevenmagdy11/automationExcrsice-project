package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {
    WebDriver driver;
    WebDriverWait wait;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By testCasesHeader = By.xpath("//h2/b[text()='Test Cases']");
    By testCasesList = By.className("panel-group");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isTestCasesHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader)).isDisplayed();
    }

    public boolean isTestCasesListVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesList)).isDisplayed();
    }

    public boolean isTestCaseVisible(String testCaseName) {
        return wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + testCaseName + "')]")))
                .isDisplayed();
    }
}
