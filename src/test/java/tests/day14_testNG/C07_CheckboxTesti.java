package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFromPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_CheckboxTesti {
    @Test
    public void checkBoxTesti() {
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        TestOtomasyonuFromPage testOtomasyonuFromPage = new TestOtomasyonuFromPage();
        ReusableMethods.istenenelemanascrollyapma(Driver.getDriver(), testOtomasyonuFromPage.carpintiCheckboxKutusu);
        ReusableMethods.bekle(2);
        testOtomasyonuFromPage.carpintiCheckboxKutusu.click();
        testOtomasyonuFromPage.sirtagrisiCheckboxKutusu.click();
        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    }
}
