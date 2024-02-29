package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroWebappsecurityPage {
    public ZeroWebappsecurityPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "signin_button")
    public WebElement signIn;
    @FindBy(id = "user_login")
    public WebElement signInUsername;
    @FindBy(id = "user_password")
    public WebElement signInpassword;
    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBanking;
    @FindBy(id = "pay_bills_link")
    public WebElement payBills;
    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement signInButton;
    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement foreignPurchaseButton;
    @FindBy(id = "pc_currency")
    public WebElement dropDownMenu;
    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement loginAvaliable;
    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElementi;
}
