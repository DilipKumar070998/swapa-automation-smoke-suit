package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for implementing different types of waits in Selenium WebDriver.
 */
public class waitCommandUtility {
   WebDriver driver;
   WebDriverWait wait;

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @param driver The WebDriver instance.
     */
    public waitCommandUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Sets the implicit wait for the WebDriver instance.
     * Implicit wait specifies the maximum amount of time the WebDriver should wait
     * when trying to find an element that is not immediately available.
     */
    public void implicitWaitCommand() {
        // Set the implicit wait timeout to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    /**
     * Waits until the page title contains the specified text.
     *
     * @param pageTitle The text to be present in the page title.
     */
    public void explicitWaitForPageTitle(String pageTitle) {
        // Wait until the page title contains the specified text
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }
    /**
     * Waits until the given element is selected.
     *
     * @param element The WebElement to wait for.
     */
    public void explicitWaitForElementToBeSelected(WebElement element) {
        // Wait until the element is selected
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    /**
     * Waits until the given element is clickable.
     *
     * @param element The WebElement to wait for.
     */

    public void explicitWaitForElementToBeClickable(WebElement element) {
        // Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until an element located by the given locator is present in the DOM.
     *
     * @param locator The locator strategy for finding the element.
     * @return
     */
    public WebElement explicitWaitForElementToBeLocated(By locator) {
        // Wait until the element located by the given locator is present
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return null;
    }
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
         return null;
    }

}


