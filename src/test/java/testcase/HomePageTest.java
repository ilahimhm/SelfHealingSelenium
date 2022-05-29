package testcase;

import base.Base;
import pages.CVPage;
import pages.CandidateLoginPage;
import pages.HomePage;
//import util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.*;
import util.TestUtil;

public class HomePageTest extends Base{
    CandidateLoginPage candidateLoginPage;
    HomePage  homePage;
    CVPage  cvPage;
    TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void HomePageIsDisplayed() {
        Assert.assertTrue(homePage.verifyCandidateButton());
    }


}
