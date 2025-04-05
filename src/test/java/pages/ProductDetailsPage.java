package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ProductDetailsPage extends ProjectSpecificationMethods{

	
    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productTitle;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']")
    private WebElement productDescription;

    @FindBy(css = "a.btn")
    private WebElement addToCartButton;
    
    @FindBy(xpath = "//a[contains(text(),'Home ')]")
	private WebElement homeMenu;

    
    
    
    
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void verifyProductDetailsDisplayed() {
        System.out.println("Verifying product details");
        Assert.assertTrue(productTitle.isDisplayed(), "Product title is not displayed");
        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed");
        Assert.assertTrue(productDescription.isDisplayed(), "Product description is not displayed");
        System.out.println("Product details verified successfully");
    }
    
    public void verifyProductDetailsContent(String expectedTitle, String expectedPrice, String expectedDescription) {
        System.out.println("Verifying product content values");
        String actualTitle = productTitle.getText().trim();
        String actualPrice = productPrice.getText().split(" ")[0].trim();
        String actualDescription = productDescription.getText().trim();

        System.out.println("Title: " + actualTitle);
        System.out.println("Price: " + actualPrice);
        System.out.println("Description: " + actualDescription);

        Assert.assertEquals(actualTitle, expectedTitle, "Product title mismatch");
        Assert.assertEquals(actualPrice, expectedPrice, "Product price mismatch");
        Assert.assertTrue(actualDescription.contains(expectedDescription), "Product description mismatch");
    }
    
    public void addProductToCart() {
        addToCartButton.click();

        try {
            Thread.sleep(2000); // For Alert
            String alertText = driver.switchTo().alert().getText();
            System.out.println(alertText);
            driver.switchTo().alert().accept();
            System.out.println("Product added to cart alert accepted.");
        } catch (Exception e) {
            System.out.println("Failed to handle alert after adding to cart: " + e.getMessage());
        }
    }
    
    public HomePage clickHomeMenu() {
    	homeMenu.click();
    	return new HomePage(driver);
    }
    
}



