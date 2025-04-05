package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC003_ProductCategoryDisplay extends ProjectSpecificationMethods{

	
	
	
	 @Test(priority = 1)
	    public void testSignUpButtonVisibility() {
		 HomePage obj1 = new HomePage(driver);   
		 Assert.assertTrue(obj1.isSignUpButtonDisplayed(), "Sign Up button is not displayed");
	    }

	    @Test(priority = 2)
	    public void testLoginButtonVisibility() {
	    	HomePage obj2 = new HomePage(driver);
	    	Assert.assertTrue(obj2.isLoginButtonDisplayed(), "Login button is not displayed");
	    }

	    @Test(priority = 3)
	    public void testMenuItemsDisplayed() {
	    	HomePage obj3 = new HomePage(driver);
	    	obj3.validateMenuItemsDisplayed();
	    }

	    @Test(priority = 4)
	    public void testCategoriesDisplayed() {
	    	HomePage obj4 = new HomePage(driver);
	    	obj4.validateCategoriesDisplayed();
	    }

	    @Test(priority = 5)
	    public void testApplicationLogoDisplayed() {
	    	HomePage obj5 = new HomePage(driver);
	    	obj5.validateApplicationLogo();
	    }

	  
}
