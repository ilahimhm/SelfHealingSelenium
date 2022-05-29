package pages;


import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class CVPage extends Base {

    @CacheLookup
    @FindBy(id = "candidatepage")
    WebElement CandidatePageHead;

    @CacheLookup
    @FindBy(id = "candidateCv_fullName")
    WebElement CandidateFullName;

    @CacheLookup
    @FindBy(id = "candidateCv_dob")
    WebElement CandidateDOB;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[1]/div[2]/table/tbody/tr[4]/td[5]")
    WebElement date;

    @CacheLookup
    @FindBy(id = "candidateCv_yearsOfExperience")
    WebElement CandidateExp;

    @CacheLookup
    @FindBy(id = "candidateCv_skill")
    WebElement CandidateSkill;

    @CacheLookup
    @FindBy(id = "SaveBtn")
    WebElement SaveBtn;

    public CVPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateCVPageHeader() {
        return CandidatePageHead.isDisplayed();
    }

    public CVPage fillCv(String name, String dob, String exp, String skill){
        CandidateFullName.clear();
        CandidateFullName.sendKeys(name);
        /*
        CandidateDOB.clear();
        date.click();
        CandidateExp.click();
        Select selectExp = new Select(CandidateExp);
        selectExp.selectByVisibleText(exp);
        CandidateSkill.click();
        Select selectSkill = new Select((CandidateSkill));
        selectSkill.selectByVisibleText(skill);
         */
        SaveBtn.click();
        return new CVPage();
    }


}
