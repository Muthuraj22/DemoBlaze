package tests;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.CartPage;
import pages.HomePage;

public class TC009_AddToCart extends ProjectSpecificationMethods {

    @Test
    public void testAddProductToCart() {
      
        HomePage obj = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        obj.clickFirstProduct()
        .addProductToCart();
        
        // Validate product exists in cart
        cart.validateProductInCart("Samsung galaxy s6");
        System.out.println("[SUCCESS] Product successfully verified in cart!");
    }
}
