package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassKullanimi {
    @Test
    public void test01() throws InterruptedException {
         /*
            POM hazirlayanlar PAGE OBJECT MODEL
            WebDriver objesini Testbase'den almak yerine, extends keyword'une ihtiyac duymadan
            kullanabilecegimiz, static bir method'da olusturmayi tercih etmistir. Bu model sayesinde
            -tum ekiple sorunsuz calısılabilir
            -test dataları kolayca yonetilebilir
            -kod tekrarlarından kurtuluruz
         */
        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        Thread.sleep(2000);
        //arama kutusuna phone yazip aratalim
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        //arama sonuclarını yazdiralım
        WebElement aramaSonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(aramaSonucElementi.getText());
    }
}
