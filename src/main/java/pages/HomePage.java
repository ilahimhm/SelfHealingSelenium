package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Base{

    @FindBy(id = "candidateBtn")
    WebElement CandidateButton;

    @FindBy(id = "employeeBtn")
    WebElement EmployeeButton;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCandidateButton() {
        return CandidateButton.isDisplayed();
    }

    public CVPage clickCandidateButton() {
        CandidateButton.click();
        return new CVPage();
    }

    public CVPage clickEmployeeButton(){
        EmployeeButton.click();
        return new CVPage();
    }
}
