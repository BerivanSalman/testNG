package tests.day14_testNG;

import org.testng.annotations.Test;

public class C01_Priority {
    //TestNG test methodlarını alfabetik siraya gore calıstırır
    //Ama testlerimizi istedigimiz sırada calıstırmak istersek priority ile sıralama yapabiliriz.
    // Kucuk olan once calısır
    // Aynı sayiyi verirsek natural ordera bakar (alfabetik sıralama)
    //herhangibir bir methoda priority atamazsak, priority degeri default olarak 0 olur

    @Test
    public void youtubeTesti(){
        System.out.println("Youtube testi Passed");
    }
    @Test(priority = 5)
    public void testOtomasyonuTesti(){
        System.out.println("Test otomasyonu testi Passed");

    }
    @Test(priority = -5)
    public void wiseQuarterTesti(){
        System.out.println("Wise Quarter testi Passed");

    }
}
