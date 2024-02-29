package tests.Friends;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationTestExcercise;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class Question {
    @Test
    public void test() {
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        // 4. Add products to cart
        AutomationTestExcercise automationTestExcercise = new AutomationTestExcercise();
        ReusableMethods.istenenelemanascrollyapma(Driver.getDriver(), automationTestExcercise.FirstProduct);
        automationTestExcercise.FirstProduct.click();
        automationTestExcercise.continueShopping.click();
        automationTestExcercise.SecondProduct.click();
        ReusableMethods.bekle(2);
        // 5. Click 'Cart' button
        automationTestExcercise.viewCart.click();
        // 7. Click 'X' button corresponding to particular product
        automationTestExcercise.removeX.click();
        // 8. Verify that product is removed from the cart
    }
   /* public void notInCart(String productLocate){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By productLocate));

    */
    }

