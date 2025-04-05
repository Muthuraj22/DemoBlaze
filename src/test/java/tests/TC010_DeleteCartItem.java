package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;


public class TC010_DeleteCartItem extends ProjectSpecificationMethods {
	
	@Test
    public void testDeleteCartProduct() {
      
        HomePage obj = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        
        obj.clickFirstProduct()
        .addProductToCart();
        cart.deleteProductFromCart();
	}
    
}
