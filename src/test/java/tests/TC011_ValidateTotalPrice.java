package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.ProductDetailsPage;


public class TC011_ValidateTotalPrice extends ProjectSpecificationMethods {
 
	@Test
    public void testDeleteCartProduct() throws InterruptedException {
      
        HomePage obj = new HomePage(driver);
        ProductDetailsPage prod = new ProductDetailsPage(driver);
        
        obj.click1Product();
        prod.addProductToCart();
        driver.navigate().back();
        driver.navigate().back();
        
        
        obj.clickSecondProduct();
        prod.addProductToCart();
        driver.navigate().back();
        driver.navigate().back();
        
        
        obj.clickThirdProduct();
        prod.addProductToCart();
        driver.navigate().back();
        driver.navigate().back();
        
        obj.clickCartMenu()
        .validateTotalPrice();
      
        
	}

}
