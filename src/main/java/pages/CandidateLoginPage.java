package pages;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidateLoginPage extends Base {

    //Page Factory - OR:

    @CacheLookup
    @FindBy(id="JSHeading")
    WebElement heading;

    @CacheLookup
    @FindBy(id="basic_email")
    WebElement username;

    @CacheLookup
    @FindBy(id="basic_password")
    WebElement password;

    @CacheLookup
    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(xpath="//*[@id=\"basic\"]/div[1]/div/div/div[@class=\"ant-alert-message\"]")
    public WebElement loginErrMessage;

    //Initializing the Page Objects:
    public CandidateLoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateLogo(){
        return heading.isDisplayed();
    }

    public CVPage login(String un, String pwd){
        username.clear();
        username.sendKeys(un);
        password.sendKeys(pwd);
        submitBtn.click();
        //loginBtn.click();
        /*
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);
        */
        return new CVPage();
    }

}

