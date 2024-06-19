package com.test;

import com.baseclass.baseClass;
import com.pageobject.BoardOfDirectors;
import com.pageobject.disabilityCalculatorPage;
import com.pageobject.homePage;
import com.pageobject.loginPage;
import com.utilities.CustomTestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

@Listeners(CustomTestNGListener.class)
public class BoardOfDirectorsTest  extends baseClass {
    BoardOfDirectors BOD = new BoardOfDirectors(driver);;


    public BoardOfDirectorsTest() throws FileNotFoundException {
    }

    public void init() throws IOException {

        loginPage login = new loginPage(driver);
        login.ClickMainLogin();
        login.setUsername(properties.getDataFromPropertyFile("username"));
        login.setPassword(properties.getDataFromPropertyFile("password"));
        login.ClickLoginbutton();
        // Instantiate swapaHomePage
        homePage home = new homePage(driver);
        // Click on Your union
        home.clickYourUnion();
        // Click on Board of Directors
        home.boardOfDirectors();
    }

  //  @BeforeMethod
//    public void loginAndNavigatetoBoardOfDirectorsPage() throws IOException {
//            // Perform login
//            loginPage login = new loginPage(driver);
//            login.ClickMainLogin();
//            login.setUsername(properties.getDataFromPropertyFile("username"));
//            login.setPassword(properties.getDataFromPropertyFile("password"));
//            login.ClickLoginbutton();
//        // Instantiate swapaHomePage
//             homePage home = new homePage(driver);
//        // Click on Your union
//             home.clickYourUnion();
//        // Click on Board of Directors
//             home.boardOfDirectors();
//    }

//Date range
    @Test()
    public void boardOfDirectorsTest() throws IOException, InterruptedException {
        init();
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.clickApplyBtn();
        BOD.firstRow();
        BOD.getResolutionCountText();
        BOD.clickFirstRowTitle();

    }

    //Date range and Keyword field
    @Test()
public void boardOfDirectorsKeywordTest() throws IOException, InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.keyWordfield();
        BOD.clickApplyBtn();
        BOD.firstRow();
        BOD.getResolutionCountText();
        BOD.clickFirstRowTitle();

    }

    //Date range and resolution number field
    @Test()
    public void boardOfDirectorsResolutionsTest() throws IOException, InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.resolutionNumberField();
        BOD.clickApplyBtn();
        BOD.firstRow();
        BOD.getResolutionCountText();
        BOD.clickFirstRowTitle();

    }



    //Date Range, Resolution number and Keyword Field
    @Test()
    public void boardOfDirectorsMainTest() throws IOException, InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.keyWordfield();
        BOD.resolutionNumberField();
        BOD.clickApplyBtn();
        BOD.firstRow();
        BOD.getResolutionCountText();
        BOD.clickFirstRowTitle();
    }

    //Invalid Resolution number provided
    @Test()
    public void invalidResolutionNumberTest() throws IOException, InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.invalidResolutionNumber();
        BOD.clickApplyBtn();
        BOD.noResultsFoundText();
    }

//No inputs provided and error msg verified.
    @Test()
public void noInputsPassedTest() throws InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.noInputPassed();
        BOD.clickApplyBtn();
        BOD.getErrorMsgTxt();
    }

    @Test()
    public void boardOfDirectorsDropdownTest() throws IOException, InterruptedException {
        BoardOfDirectors BOD = new BoardOfDirectors(driver);
        BOD.dateRangeField();
        BOD.statusDropdown();
        BOD.clickApplyBtn();
        BOD.firstRow();
        BOD.getResolutionCountText();
        BOD.clickFirstRowTitle();
    }



}
