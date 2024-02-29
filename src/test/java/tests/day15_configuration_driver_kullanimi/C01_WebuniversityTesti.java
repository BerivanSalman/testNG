package tests.day15_configuration_driver_kullanimi;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_WebuniversityTesti {
    //quit driver acılan iki sayfayı da kapatır. Window birden fazla acılıyor bazen
    @Test
    public void negatifLoginTesti(){
        //1."http://webdriveruniversity.com/" adresine gidin
   Driver.getDriver().get(ConfigReader.getProperty("webuniUrl"));

        //2."Login Portal" a  kadar asagi inin
        WebUniversityPage webUniversityPage = new WebUniversityPage();
        ReusableMethods.istenenelemanascrollyapma(Driver.getDriver(), webUniversityPage.contactPortalLinki);
        //3."Login Portal" a tiklayin
        webUniversityPage.loginPortalLinki.click();
        //4.Diger window'a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");

        //5."username" ve  "password" kutularina rastgele deger yazdirin ve //6."login" butonuna basin
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(webUniversityPage.usernameKutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        ReusableMethods.bekle(1);
        String expectedText ="validation failed";
        String actualText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedText);
        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.bekle(1);
        //9.Ilk sayfaya geri donun
        String ilkSayfaTitle = "WebDriverUniversity.com";
        ReusableMethods.titleIleSayfaDegistir("WebDriverUniversity.com");
        ReusableMethods.bekle(1);
        //10.Ilk sayfaya donuldugunu test edin
        String actualTitle = Driver.getDriver().getTitle();
      Assert.assertEquals(actualTitle,ilkSayfaTitle);
      Driver.quitDriver();
    }
}
