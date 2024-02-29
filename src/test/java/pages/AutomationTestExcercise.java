package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationTestExcercise {
    public AutomationTestExcercise() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@href=\"/products\"]")
    public WebElement products;
    @FindBy(xpath = "(//*[text()='Add to cart'])[1]")
    public WebElement FirstProduct;
    @FindBy(xpath = "(//*[text()='Add to cart'])[3]")
    public WebElement SecondProduct;
    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCart;
    @FindBy(xpath = "//*[@class='cart_quantity_delete']")
    public WebElement removeX;
    @FindBy(xpath = "//*[text()='Continue Shopping']")
    public WebElement continueShopping;
@FindBy(xpath = "//*[@class='brands-name']")
    public List<WebElement> brandsList;
@FindBy(xpath = "//*[text()='Brands']")
    public WebElement brandsText;
@FindBy(xpath = "//*[text()='Madame']")
    public WebElement madame;
@FindBy(xpath = "//*[@class='title text-center']")
    public WebElement madameProducts;
@FindBy(xpath = "//*[@href='/brand_products/Babyhug']")
    public WebElement babyHug;
}
