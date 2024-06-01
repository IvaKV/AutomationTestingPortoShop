package helpers;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelpers {
    private static WebDriver driver;

    private static WebDriverWait wait;


    public static void initializeWebDriver () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement findElement (By locator) {
        return driver.findElement(locator);
    }
    public static WebElement waitAndFindElement (By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitAndLocateElement (By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForClickableElement (By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


   public static void hover (By locator) {
        WebElement element = findElement(locator);
        Actions hover = new Actions(driver);
        hover.moveToElement(element).perform();
   }
}
