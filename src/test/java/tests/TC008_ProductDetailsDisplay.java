package tests;


import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.ProductDetailsPage;

public class TC008_ProductDetailsDisplay extends ProjectSpecificationMethods{
	
	HomePage obj1 = new HomePage(driver);
	
	@Test(priority=1)
    public void testProductDetailsDisplayed() {
		
		HomePage obj1 = new HomePage(driver);
		
		obj1.clickFirstProduct()
		.verifyProductDetailsDisplayed();
		
		ProductDetailsPage prod = new ProductDetailsPage(driver);

	    String expectedTitle = "Samsung galaxy s6";
	    String expectedPrice = "$360";
	    String expectedDescription = "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor"; // Partial match

	    prod.verifyProductDetailsContent(expectedTitle, expectedPrice, expectedDescription);
	    System.out.println("Product detail accuracy test passed.");
		}
	
	
}