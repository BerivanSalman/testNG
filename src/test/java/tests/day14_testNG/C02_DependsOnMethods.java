package tests.day14_testNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {
     /*
        dependsOnMethods oncelik sirasina karismaz

        Eger sirasi gelen bir test dependsOnMethods ile baska bir method'a bagli ise
        once bagli olunan testin calisip, pass olmasini kontrol eder

        bagli olunan test calismazsa veya calisir ama FAILED olursa
        bu durumda bagli olan test method'u calismaz, ignore olarak isaretlenir

        Normalde her bir test method'u bagimsiz olarak calistirilabilir
        Ancak dependsOnMethods ile bagli olan iki method'dan
        bagli olan run edilirse, oncelikle bagli olunan test method'unun calismasini saglar
        bagli olunan method calisip PASSED olursa, bagli olan kendisi de calisir

     */

    @Test(dependsOnMethods = "testOtomasyonuTesti") //youtube testinin calısması testOtomasyonuTestinin calısmasına baglıdır
    public void youtubeTesti(){
        System.out.println("Youtube testi Passed");
    }
    @Test
    public void testOtomasyonuTesti(){
        //Assert.assertTrue(false); bunu yazarsak bu test fail verir ve buna baglı olan youtube testi de calısmaz
        System.out.println("Test otomasyonu testi Passed");

    }
    @Test(dependsOnMethods = "youtubeTesti")
    public void wiseQuarterTesti(){
        System.out.println("Wise Quarter testi Passed");

    }
}
