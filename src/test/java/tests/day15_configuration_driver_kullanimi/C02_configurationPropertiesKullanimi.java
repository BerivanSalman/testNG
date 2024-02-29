package tests.day15_configuration_driver_kullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFromPage;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_configurationPropertiesKullanimi {
    @Test
    public void aramaTesti(){
        // test otomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // configuration.properties'de belirlenmis olan aranacak urunu aratin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") +Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        int bulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanUrunSayisi>0);
        // ilk urune tiklayin
       // testOtomasyonuPage.phoneIlkUrun.click();
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        // acilan sayfada urun isminin case sensitive olmadan
        // configuration.properties'de belirlenmis olan aranacak kelimeyi icerdigini test edin
        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                .urunSayfasindakiUrunIsimElementi
                .getText().toLowerCase();
        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));


    }
}
