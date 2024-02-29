package tests.Friends;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebappsecurityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Trying {
    @Test
    public void Test(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
       SoftAssert softAssert= new SoftAssert();
        String expectedUrl= "http://zero.webappsecurity.com/";
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
        // 8. Online banking menusunu tiklayin
        zeroWebappsecurityPage.onlineBanking.click();
        // 9. Pay Bills sayfasina gidin
        zeroWebappsecurityPage.payBills.click();
        // 10. “Purchase Foreign Currency” tusuna basin
        zeroWebappsecurityPage.foreignPurchaseButton.click();
        // 11. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebappsecurityPage.dropDownMenu.isEnabled(),"dropdown menu erisilemez");
        // 12. “Currency” dropdown menusunden Eurozone’u secin
        zeroWebappsecurityPage.dropDownMenu.sendKeys("Eurozone");
        // 13. "Eurozone (euro)" secildigini dogrulayin
      softAssert.assertEquals(zeroWebappsecurityPage.dropDownMenu,"Eurozone","eurozone secili degil");
        // 14. Dropdown menude 16 option bulundugunu dogrulayin.
        Select selectDdm = new Select(zeroWebappsecurityPage.dropDownMenu);
        //List<WebElement> dropdownMenuList = selectDdm
        // 15. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        // 16. Sayfayi kapatin
      /*  private void assertProductNotInCart(String productName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(), '" + productName + "')]")));

            softAssert.assertTrue(driver.findElements(By.xpath("//td[contains(text(), '" + productName + "')]")).isEmpty(),
                    productName + " is still in the cart.");

       */
        }
    }
