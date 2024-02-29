package tests.Friends;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebappsecurityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Question2 {
    @Test
    public void test(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"anasayfada degilsiniz");
        // 3. Sign in butonuna basin
        ZeroWebappsecurityPage zeroWebappsecurityPage = new ZeroWebappsecurityPage();
        zeroWebappsecurityPage.signIn.click();
        // 4. Login kutusuna “username” yazin
        zeroWebappsecurityPage.signInUsername.click();
        zeroWebappsecurityPage.signInUsername.sendKeys(ConfigReader.getProperty("zeroUsername"));
        // 5. Password kutusuna “password” yazin
        zeroWebappsecurityPage.signInpassword.sendKeys(ConfigReader.getProperty("zeroPassword"));
        // 6. Sign in tusuna basin
        zeroWebappsecurityPage.signInButton.click();
        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebappsecurityPage.loginAvaliable.isDisplayed(), "login sayfasına erişilemedi");
        // 9. Online banking menusunu tiklayin
        zeroWebappsecurityPage.onlineBanking.click();
        // 10. Pay Bills sayfasina gidin
        zeroWebappsecurityPage.payBills.click();
        // 11. “Purchase Foreign Currency” tusuna basin
        zeroWebappsecurityPage.foreignPurchaseButton.click();
        // 12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebappsecurityPage.dropDownMenu.isEnabled(),"Dropdown menu ulasılır degil");
        // 13. “Currency” dropdown menusunden Eurozone’u secin
        zeroWebappsecurityPage.dropDownMenu.sendKeys("Eurozone");
        // 14. "Eurozone (euro)" secildigini dogrulayin
        System.out.println(zeroWebappsecurityPage.dropDownMenu.getText());
        softAssert.assertTrue(zeroWebappsecurityPage.dropDownMenu.getText().contains("Eurozone"),"icermiyor");
        // 15. Dropdown menude 16 option bulundugunu dogrulayin.
        Select selectDdm = new Select(zeroWebappsecurityPage.dropDownMenu);
        List<WebElement> optionList = selectDdm.getOptions();
        int expectedDdm= 16;
        int actualDdm = optionList.size();
       softAssert.assertEquals(actualDdm,expectedDdm,"Sayiları esit degil");
        // 16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        softAssert.assertTrue(zeroWebappsecurityPage.dropDownMenu.getText().contains("Canada (dollar)"),"yok");
        // 17. Sayfayi kapatin
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
