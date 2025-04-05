package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;


public class TC013_PlaceOrder extends ProjectSpecificationMethods {

	@Test
    public void testPlaceOrder() throws InterruptedException {
      
        HomePage obj = new HomePage(driver);
        ProductDetailsPage prod = new ProductDetailsPage(driver);
        CartPage cart = new CartPage(driver);
        
        
        obj.clickThirdProduct();
        prod.addProductToCart();
        obj.clickCartMenu();
        cart.clickPlaceOrder();
        cart.verifyPlaceOrderWindow();
        
	}
        
        
}
