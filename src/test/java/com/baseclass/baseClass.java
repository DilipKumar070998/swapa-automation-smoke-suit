package com.baseclass;

import com.utilities.propertiesFileUtility;
import com.utilities.waitCommandUtility;
import com.utilities.webDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Base utility class for setting up and tearing down WebDriver instances.
 */
public class baseClass {
    public WebDriver driver;

    public webDriverUtility webDriverUtils;
    public waitCommandUtility wait;
    public propertiesFileUtility properties;

    public baseClass() throws FileNotFoundException {

        this.webDriverUtils = new webDriverUtility();
        this.properties = new propertiesFileUtility(driver);
        wait = new waitCommandUtility(driver);
    }

    /**
     * Method to open the browser and initialize WebDriver based on the browser specified in the properties file.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    @BeforeMethod
    public void OpenBrowser() throws IOException {

        // Get the browser name from the properties file
        String browserName = properties.getDataFromPropertyFile("BrowserName");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        }
        // Maximize the browser window
        webDriverUtils.maximize(driver);

        // Initialize WaitUtils and set implicit wait
        wait = new waitCommandUtility(driver);
        wait.implicitWaitCommand();

        // Open the URL specified in the properties file
        driver.get(properties.getDataFromPropertyFile("url"));
    }


    /**
     * Method to close the browser and quit the WebDriver.
     */
    @AfterMethod
    public void CloseBrowser() throws InterruptedException {

        // Quit the WebDriver
        //webDriverUtils.minimize(driver);
        driver.quit();
    }
}
