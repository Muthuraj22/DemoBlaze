package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class CartPage extends ProjectSpecificationMethods {
	
	    private WebDriver driver;

	    @FindBy(id = "cartur")
	    private WebElement cartLink;

	    @FindBy(xpath = "//tbody[@id='tbodyid']/tr[1]/td[2]")
	    private WebElement firstCartProductName;
	    
	    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
	    private List<WebElement> productPrices;

	    @FindBy(id = "totalp")
	    private WebElement totalPriceElement;
	    
	    @FindBy(xpath = "//tbody[@id='tbodyid']/tr[1]/td[4]/a")
	    private WebElement deleteButton;
	    
	    @FindBy(xpath = "//tbody[@id='tbodyid']/tr")
	    private java.util.List<WebElement> cartItems;

	    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[4]/a")  
	    private java.util.List<WebElement> deleteButtons;

	    @FindBy(xpath = "//button[text()='Place Order']")
	    private WebElement placeOrderButton;

	    @FindBy(id = "orderModal")  
	    private WebElement placeOrderModal;

	    
	    
	    
	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void validateProductInCart(String expectedProductName) {
	        cartLink.click();

	        try {
	            Thread.sleep(3000); // wait for cart items to load
	        } catch (InterruptedException e) {
	            System.out.println("InterruptedException while waiting: " + e.getMessage());
	        }

	        String actualProductName = firstCartProductName.getText();
	        System.out.println("Product found in cart: " + actualProductName);

	        Assert.assertEquals(actualProductName.trim(), expectedProductName.trim(), "Product name mismatch in cart");
	    }
	    
	    public void deleteProductFromCart() {
	        cartLink.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

	        deleteButton.click();

	        try {
	            Thread.sleep(3000); // Wait for the cart to refresh
	        } catch (InterruptedException e) {
	            System.out.println("InterruptedException while waiting: " + e.getMessage());
	        }

	        boolean isCartEmpty = driver.findElements(By.xpath("//tbody[@id='tbodyid']/tr")).isEmpty();
	        Assert.assertTrue(isCartEmpty, "Cart is not empty after deleting the product");
	    }
	    
	    public void navigateToCart() {
	        cartLink.click();
	    }
	    
	    public void validateTotalPrice() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(totalPriceElement));
	        
	        System.out.println("Reached");
	        
	        
	        int calculatedTotal = 0;
	        for (WebElement priceElement : productPrices) {
	            int itemPrice = Integer.parseInt(priceElement.getText().trim());
	            calculatedTotal += itemPrice;
	        }

	        int displayedTotal = Integer.parseInt(totalPriceElement.getText().trim());
	        System.out.println("Calculated Total: " + calculatedTotal);
	        System.out.println("Displayed Total: " + displayedTotal);

	        Assert.assertEquals(displayedTotal, calculatedTotal, "Total price calculation is incorrect");
	    }
	    
	    public void clearCart() {
	        while (!cartItems.isEmpty()) {
	            deleteButtons.get(0).click();
           System.out.println("Product Deleted");
	            try {
	                Thread.sleep(200); // Wait for UI to update
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void verifyCartIsEmpty() {
	        Assert.assertTrue(cartItems.isEmpty(), "Cart is not empty after deletion.");
	    }
	    
	    public void clickPlaceOrder() throws InterruptedException {
	        placeOrderButton.click();
	        System.out.println("Button Clicked");
	        Thread.sleep(3000);
	    }

	    public void verifyPlaceOrderWindow() {
	    	Assert.assertTrue(placeOrderModal.isDisplayed(), "Place Order window is not displayed.");
	    }
	}