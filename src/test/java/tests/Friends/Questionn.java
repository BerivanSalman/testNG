package tests.Friends;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationTestExcercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Questionn {
    @Test
    public void test(){
        //  2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autotestexerciseUrl"));
        //  3. Click on 'Products' button
        AutomationTestExcercise automationTestExcercise = new AutomationTestExcercise();
        automationTestExcercise.products.click();
        //  4. Verify that Brands are visible on left side bar
        ReusableMethods.istenenelemanascrollyapma(Driver.getDriver(),automationTestExcercise.brandsText);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(automationTestExcercise.brandsText.isDisplayed(),"Brands are not visible");
        //  5. Click on any brand name
        automationTestExcercise.madame.click();
        //  6. Verify that user is navigated to brand page and brand products are displayed
        String expectedUrl = "https://automationexercise.com/brand_products/Madame";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"It is not navigate to brand page");
        // 7. Verify that brand products are displayed
        String expectedText="BRAND - MADAME PRODUCTS";
        String actualText = automationTestExcercise.madameProducts.getText();
        softAssert.assertEquals(actualText,expectedText,"Brand products are not displayed");
        //  8. On left side bar, click on any other brand link
        ReusableMethods.istenenelemanascrollyapma(Driver.getDriver(), automationTestExcercise.brandsText);
        automationTestExcercise.babyHug.click();




    }
}
