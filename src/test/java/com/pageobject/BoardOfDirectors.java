package com.pageobject;

import com.utilities.pageScrollingUtility;
import com.utilities.propertiesFileUtility;
import com.utilities.waitCommandUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoardOfDirectors {

        WebDriver driver;
        SoftAssert softAssert;
        propertiesFileUtility property;
        waitCommandUtility wait;
        pageScrollingUtility pageScrollingUtility;
        /**
         * Constructor to initialize WebDriver and utilities.
         *
         * @param driver The WebDriver instance to interact with the browser.
         */
        public BoardOfDirectors(WebDriver driver) {

            this.driver = driver;
            this.softAssert = new SoftAssert();
            this.property = new propertiesFileUtility(driver);
            this.wait = new waitCommandUtility(this.driver);
            this.pageScrollingUtility = new pageScrollingUtility(this.driver);
        }

        private By startDate = By.id("StartDate");
        private By toDate = By.id("EndDate");
        private By dateRangeTxtArea = By.xpath("//h5[text()=\"Date Range\"]");
        private By statusDropdownBtn = By.xpath("//span[@class=\"dropdown-multiselect__caret\"]");
        private By unSelectBtn = By.xpath("//div[text()=\"UnSelect All\"]");
        private By passedBtn = By.xpath("(//div[text()=\"Passed\"])[1]");
        private By keyWord = By.xpath("//input[@formcontrolname=\"Keyword\"]");
        private By resolutionNumber = By.xpath("//input[@formcontrolname=\"Id\"]");
        private By applyBtn = By.xpath("//button[text()='Apply']");
        private By statusTxt = By.xpath("//h5[text()=\"Status\"]");
        private By errorMsgTxt = By.xpath("//span[text()='Please select a date range, keyword, or status.']");
        private By noOfResolutionsPresent = By.id("ag-21-row-count");
       // private By firstRow = By.xpath("(//div[contains(@class,'position-absolute ag-row-first')])[2]");
       private By firstRow = By.xpath("((//div[@ref=\"eContainer\"])[2]//div)[1]");
       private By firstRowTitle = By.id("viewResolutions1_tvResolutionst0");
       private By noResultsFoundTxt = By.xpath("//div[text()='No results found.']");

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return currentDate.format(formatter);
    }

        public void dateRangeField() throws IOException {
            this.wait.explicitWaitForElementToBeLocated(startDate);
            WebElement fromDateRange = driver.findElement(startDate);
            fromDateRange.clear();
            fromDateRange.sendKeys(this.property.getDataFromPropertyFile("startDate"));
           // String currentDate = getCurrentDate();
            WebElement toDatefield = driver.findElement(toDate);
            toDatefield.clear();
            toDatefield.sendKeys(getCurrentDate());
            driver.findElement(dateRangeTxtArea).click();

        }

        public void keyWordfield() throws IOException {
            this.wait.explicitWaitForElementToBeLocated(keyWord);
            driver.findElement(keyWord).sendKeys(this.property.getDataFromPropertyFile("keyWordForBoardOfDirectors"));

        }

public void resolutionNumberField() throws IOException {
        this.wait.explicitWaitForElementToBeLocated(resolutionNumber);
        driver.findElement(resolutionNumber).sendKeys(this.property.getDataFromPropertyFile("resolutionNumberForBoardOfDirectors"));

    }
    public void  resolutionNumberFieldInvalid() throws IOException {
        this.wait.explicitWaitForElementToBeLocated(resolutionNumber);
driver.findElement(resolutionNumber).sendKeys(this.property.getDataFromPropertyFile("resolutionNumberForBoardOfDirectorsinvalid"));

    }

    public void statusDropdown(){
        pageScrollingUtility.setScroll600();
        this.wait.explicitWaitForElementToBeLocated(statusDropdownBtn);
        driver.findElement(statusDropdownBtn).click();
        driver.findElement(unSelectBtn).click();
        driver.findElement(passedBtn).click();
        driver.findElement(statusTxt).click();
    }

    public void clickApplyBtn() throws InterruptedException {
       this.wait.explicitWaitForElementToBeLocated(applyBtn);
        driver.findElement(applyBtn).click();
        Thread.sleep(5000);
    }



    public String getResolutionCountText() {
    this.wait.explicitWaitForElementToBeLocated(noOfResolutionsPresent);
        WebElement count = driver.findElement(noOfResolutionsPresent);
        String countText = count.getText();
        System.out.println("Resolution count text is " + countText);
         return countText;
    }

    public void noInputPassed(){
        this.wait.explicitWaitForElementToBeLocated(startDate);
        WebElement fromDateRange = driver.findElement(startDate);
        fromDateRange.clear();
        fromDateRange.click();
        WebElement toDatefield = driver.findElement(toDate);
        toDatefield.clear();
        driver.findElement(dateRangeTxtArea).click();
        driver.findElement(statusDropdownBtn).click();
        driver.findElement(unSelectBtn).click();
        driver.findElement(statusTxt).click();

    }
public void getErrorMsgTxt(){
        this.wait.explicitWaitForElementToBeLocated(errorMsgTxt);
        WebElement errorMsg = driver.findElement(errorMsgTxt);
        String errormsgtxt = errorMsg.getText();
        System.out.println(errormsgtxt);
    Assert.assertEquals(errormsgtxt , "Please select a date range, keyword, or status.");
}

public void firstRow(){
       this.wait.explicitWaitForElementToBeLocated(firstRow);
        WebElement firstRowData = driver.findElement(firstRow);
        String fetchFirstRowData = firstRowData.getText();
        System.out.println(fetchFirstRowData);
        firstRowData.click();
}

public void clickFirstRowTitle(){
    this.wait.explicitWaitForElementToBeLocated(firstRowTitle);
    driver.findElement(firstRowTitle).click();
    System.out.println("PDF is Displayed");

}

public void invalidResolutionNumber() throws IOException {
        this.wait.explicitWaitForElementToBeLocated(resolutionNumber);
        driver.findElement(resolutionNumber).sendKeys(this.property.getDataFromPropertyFile("resolutionNumberForBoardOfDirectorsinvalid"));

}

public void noResultsFoundText(){
    WebElement invalidTxt = driver.findElement(noResultsFoundTxt);
    String invalidText = invalidTxt.getText();
    System.out.println(invalidText);
    Assert.assertEquals(invalidText , "No results found.");
}

}
