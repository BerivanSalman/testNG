package tests.day14_testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_AramaTesti {
    // priority yerine depends on kullanmak daha mantıklı cunku priority kullanırsak ilk test fail olmasına ragmen
    // diger testlere de bakmaya calısır ve bu da zaman kaybıdır
    WebDriver driver;

    @Test
    public void anasayfaTesti() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1- testotomasyonu anasayfaya gidip
        //    dogru adrese gittigimizi test edin
        driver.get("https://www.testotomasyonu.com");
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void aramaTesti() {
        // 2- phone icin arama yapip
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //    arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonuc = driver.findElement(By.className("product-count-text"));
        String aramaSonucStr = aramaSonuc.getText().replaceAll("\\D", "");
        int aramaSonucInt = Integer.parseInt(aramaSonucStr);
        Assert.assertTrue(aramaSonucInt > 0);
    }

    @Test(dependsOnMethods = "aramaTesti")
    public void urunIsmiTesti() {
        // 3- ilk urune tiklayip
        driver.findElement(By.xpath("(//*[@class='lazy'])[1]")).click();
        //    acilan urun sayfasinda, urun isminin case sensitive olmadan phone icerdigini test edin
        WebElement phoneIcerik = driver.findElement(By.xpath(" (//*[@class=' heading-sm mb-4'])[1]"));
        String expectedIsımIcerik = "phone";
        String actualIsımIcerik = phoneIcerik.getText().toLowerCase();
        Assert.assertTrue(actualIsımIcerik.contains(expectedIsımIcerik));
        driver.close();

    }
}
