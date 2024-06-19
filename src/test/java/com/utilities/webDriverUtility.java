package com.utilities;

import org.openqa.selenium.WebDriver;
/**
 * Utility class for managing WebDriver window operations.
 */
public class webDriverUtility {


    /**
     * Constructor (empty).
     */
    public webDriverUtility() {
    }
    /**
     * Maximizes the browser window.
     *
     * @param driver The WebDriver instance.
     */
    public void maximize(WebDriver driver) {
        // Maximize the browser window
        driver.manage().window().maximize();
    }
    /**
     * Minimizes the browser window.
     *
     * @param driver The WebDriver instance.
     */
    public void minimize(WebDriver driver) {
        // Minimize the browser window
        driver.manage().window().minimize();
    }

}


