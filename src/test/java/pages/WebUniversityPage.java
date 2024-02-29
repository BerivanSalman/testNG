package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversityPage {
    public WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    public WebElement loginPortalLinki;
    @FindBy(xpath ="//h1[text()='CONTACT US']")
    public WebElement contactPortalLinki;
    @FindBy(xpath = "//*[@id='text']")
    public WebElement usernameKutusu;
    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginKutusu;
    @FindBy(xpath ="//*[@id='password']" )
    public WebElement passwordKutusu;
}
