package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;


public class TC012_EmptyCart extends ProjectSpecificationMethods {
 
	@Test
    public void testEmptyCart() throws InterruptedException {
      
        HomePage obj = new HomePage(driver);
        ProductDetailsPage prod = new ProductDetailsPage(driver);
        CartPage cart = new CartPage(driver);
        
        obj.clickSecondProduct();
        prod.addProductToCart();
        driver.navigate().back();
        driver.navigate().back();
        
        
        obj.clickThirdProduct();
        prod.addProductToCart();
        driver.navigate().back();
        driver.navigate().back();
        
        obj.clickCartMenu()
        .clearCart();
        cart.verifyCartIsEmpty();
     
	}
}
