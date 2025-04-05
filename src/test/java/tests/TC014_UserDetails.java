package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductDetailsPage;

public class TC014_UserDetails extends ProjectSpecificationMethods{

	@Test
    public void testUserDetailsDisplay() throws InterruptedException {
      
        HomePage obj = new HomePage(driver);
        ProductDetailsPage prod = new ProductDetailsPage(driver);
        PlaceOrderPage place = new PlaceOrderPage(driver);
        CartPage cart = new CartPage(driver);
        
        
        obj.clickThirdProduct();
        prod.addProductToCart();
        obj.clickCartMenu();
        cart.clickPlaceOrder();
        place.verifyUserDetailsSections();
        
       
	}
}
