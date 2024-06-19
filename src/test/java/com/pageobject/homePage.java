package com.pageobject;

import com.utilities.propertiesFileUtility;
import com.utilities.waitCommandUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
/**
 * Page Object Model (POM) class for the SWAPA Home page.
 */
public class homePage {

    WebDriver driver;
    SoftAssert softAssert;
    propertiesFileUtility property;
    waitCommandUtility wait ;
    /**
     * Constructor to initialize WebDriver and utilities.
     *
     * @param driver The WebDriver instance.
     */
    public homePage(WebDriver driver) {

        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.property = new propertiesFileUtility(driver);
        this.wait = new waitCommandUtility(this.driver);
    }
    // Locators for elements on the Home Page
    private By resources = By.xpath("//span[text() = 'Resources']");
    private By SrcForms = By.xpath("(//a[contains(text(),'SRC')])[1]");
    private By PilotPollingForm = By.xpath("(//a[contains(text(),'Pilot')])[3]");
    private By Calculators = By.linkText("Calculators");
    private By DisabilityCalculator = By.xpath("(//a[contains(text(),'Calculators')])[1]/../div[3]/a[3]");
    private By yourUnion = By.xpath("//span[text()='Your Union']");
    private By boardOfDirectors = By.xpath("(//a[text()='Board of Directors'])[1]");
    /**
     * Clicks on the 'Resources' link.
     */
    public void clickResources() {
        // Wait for the 'Resources' link to be located
        this.wait.explicitWaitForElementToBeLocated(resources);
        // Click on the 'Resources' link
        driver.findElement(resources).click();
    }

    /**
     * Clicks on the 'SRC Forms' link.
     */
    public void clickSRC_Forms() {

        // Wait for the 'SRC Forms' link to be located
        this.wait.explicitWaitForElementToBeLocated(SrcForms);
        // Click on the 'SRC Forms' link
        driver.findElement(SrcForms).click();
    }

    /**
     * Clicks on the 'Pilot Polling Form' link and verifies the page title.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void clickPilotPollingForm() throws IOException {
        // Wait for the 'PilotPollingForm' link to be located
        this.wait.explicitWaitForElementToBeLocated(PilotPollingForm);
        // Click on the 'Pilot Polling Form' link
        driver.findElement(PilotPollingForm).click();
        // Verify the page title
        String ActualPilotPollingFormPageTitle = driver.getTitle();
        this.softAssert.assertEquals(ActualPilotPollingFormPageTitle, this.property.getDataFromPropertyFile("ExceptedPilotPollingFormPageTitle"), "Home Page Tile Mismatch");
        this.softAssert.assertAll();

    }

    /**
     * Clicks on the 'Calculators' link.
     */
    public void clickCalculators() {
        // Wait for the 'Calculators' link to be located
        this.wait.explicitWaitForElementToBeLocated(Calculators);
        // Click on the 'Calculators' link
        driver.findElement(Calculators).click();
    }

    /**
     * Clicks on the 'Disability Calculator' link and verifies the page title.
     *
     * @throws IOException If there is an error reading from the properties file.
     */
    public void clickDisabilityCalculator() throws IOException {
        // Wait for the 'DisabilityCalculator' link to be located
        this.wait.explicitWaitForElementToBeLocated(DisabilityCalculator);
        // Click on the 'Disability Calculator' link
        driver .findElement(DisabilityCalculator).click();
        // Verify the page title
        String ActualDisabilityCalculatorPageTitle = driver.getTitle();
        this.softAssert.assertEquals(ActualDisabilityCalculatorPageTitle, this.property.getDataFromPropertyFile("ExceptedDisabilityCalculatorPageTitle"), "Disability Calculator Page Tile Mismatch");
        this.softAssert.assertAll();
    }

    public void clickYourUnion() {
        wait.explicitWaitForElementToBeLocated(yourUnion);
        driver.findElement(yourUnion).click();

    }

    public void boardOfDirectors() throws IOException {
        wait.explicitWaitForElementToBeLocated(boardOfDirectors);
        driver.findElement(boardOfDirectors).click();
        String boardOfDirectorsPageTitle = driver.getTitle();
        this.softAssert.assertEquals(boardOfDirectorsPageTitle, this.property.getDataFromPropertyFile("expectedBoardofDirectorsPageTitle"), "Disability Calculator Page Tile Mismatch");
        this.softAssert.assertAll();

    }


}
