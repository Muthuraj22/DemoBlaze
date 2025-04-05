package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductDetailsPage;

public class TC015_CompletePurchase extends ProjectSpecificationMethods {

	@Test
    public void testCompletePurchaseProcess() throws InterruptedException {
      
        HomePage obj = new HomePage(driver);
        ProductDetailsPage prod = new ProductDetailsPage(driver);
        PlaceOrderPage place = new PlaceOrderPage(driver);
        CartPage cart = new CartPage(driver);
        
        
        obj.clickThirdProduct();
        prod.addProductToCart();
        obj.clickCartMenu();
        cart.clickPlaceOrder();
        place.verifyUserDetailsSections();
        place.fillOrderDetails("Muthu", "India", "Chennai", "123412341234", "04", "2025");
        place.clickPurchase();
        place.verifyOrderSuccessPayment();
        place.clickOK();
	}
        
}
