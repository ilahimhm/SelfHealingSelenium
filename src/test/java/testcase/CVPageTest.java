package testcase;

import base.Base;
import pages.CandidateLoginPage;
import pages.HomePage;
import pages.WelcomePage;
import pages.CVPage;
//import util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class CVPageTest extends Base {
    CandidateLoginPage candidateLoginPage;
    WelcomePage welcomePage;
    CVPage cvPage;
    HomePage homePage;


    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        homePage.clickCandidateButton();
        candidateLoginPage = new CandidateLoginPage();
        candidateLoginPage.login(prop.getProperty("CandidateUsername"), prop.getProperty("CandidatePassword"));
        cvPage = new CVPage();
    }


    @Test(priority = 1)
    public void CanditatePageHeaderTest() {
        Assert.assertTrue(cvPage.validateCVPageHeader());
    }

    @Test(priority = 2, dataProvider = "LoginData")
    public void CandidatePageForm_Filling(String name, String DOB, String exp, String skill) {
        cvPage = cvPage.fillCv(name, DOB, exp, skill);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object[][] getDataFromDataProvider(Method m) throws Exception {
        switch (m.getName()) {
            case "CandidatePageForm_Filling":
                return new Object[][]{{"Sameera", "2022-04-20", "2", "Senior QA Engineer"}};
        }
        return null;
    }

}
