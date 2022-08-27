package testcase;

import base.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import pages.CVPage;
import pages.HomePage;
import pages.CandidateLoginPage;
//import util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import util.Log;

import java.lang.reflect.Method;


public class CandidateLoginPageTest extends Base{
    CandidateLoginPage candidateLoginPage;
    HomePage homePage;
    CVPage cvPage;


    public CandidateLoginPageTest() {
        super();
    }
    public static final Logger LOGGER = LoggerFactory.getLogger(CandidateLoginPageTest.class);

/*
    @BeforeTest
    public void setupTestData(){
        //set testdata excel and sheet
        ExcelUtil.setExcelFileSheet("LoginData");
    }

 */
    @BeforeMethod
    public void setup(){
        initialization();
        homePage = new HomePage();
        homePage.clickCandidateButton();
        Log.warn("log");
        Log.info("Healing using 'candidateBtn1' element ");
        candidateLoginPage = new CandidateLoginPage();
    }



    @Test(priority = 1)
    public void loginPageLogoTest() {
        String title = candidateLoginPage.validateLoginPageTitle();
        Assert.assertTrue(candidateLoginPage.validateLogo());
        Reporter.log("test assert logo");
    }

    @Test(priority = 2, dataProvider = "LoginData")
    public void loginTest_Valid(String username, String password) throws InterruptedException {
        cvPage = candidateLoginPage.login(username, password);
        //wait(2000) ;
        Assert.assertTrue(cvPage.validateCVPageHeader());
    }

    @Test(priority = 2, dataProvider = "LoginData")
    public void loginTest_InvalidUser(String username, String password, String errMessage) throws InterruptedException {
        cvPage = candidateLoginPage.login(username, password);
        System.out.println(username + " " + password + " " + errMessage + "**");
        if(!errMessage.equals(null)){
            Thread.sleep(3000);
            Assert.assertTrue(driver.getPageSource().contains(errMessage));
        }

    }

    @Test(priority = 2, dataProvider = "LoginData")
    public void loginTest_NoPassWord(String username, String password, String errMessage) throws InterruptedException {
        cvPage = candidateLoginPage.login(username, password);
        System.out.println(username + " " + password + " " + errMessage + "**");
        if(!errMessage.equals(null)){
            Thread.sleep(3000);
            Assert.assertTrue(driver.getPageSource().contains(errMessage));
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object[][] getDataFromDataProvider(Method m) throws Exception {
        switch (m.getName()) {
            case "loginTest_Valid":
                return new Object[][]{{"c.a.sameera@gmail.com", "Qwer!234"}};

            case "loginTest_InvalidUser":
                return new Object[][]{{"ilahi123@gmail.com", "wer123","User does not exist."}};

            case "loginTest_InvalidPassword":
                return new Object[][]{{"ilahi123@gmail.com", "wer123","Incorrect username or password."}};

            case "loginTest_NoPassWord":
                return new Object[][]{{"ilahi123@gmail.com", "","Password is required"}};

            }
        return null;
    }







}
