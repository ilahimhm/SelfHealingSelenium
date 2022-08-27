package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.epam.reportportal.annotations.Step;
import util.Log;



public class HomePage extends Base{

    @FindBy(id = "candidateBtn")
    WebElement CandidateButton;

    @FindBy(id = "employeeBtn")
    WebElement EmployeeButton;

    public static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCandidateButton() {
        return CandidateButton.isDisplayed();
    }

    public CVPage clickCandidateButton() {
        CandidateButton.click();
        LOGGER.info("Healing using 'candidateBtn1' element ");
        Log.info("Healing using 'candidateBtn1' element ");
        return new CVPage();
    }

    public CVPage clickEmployeeButton(){
        EmployeeButton.click();
        return new CVPage();
    }
}
