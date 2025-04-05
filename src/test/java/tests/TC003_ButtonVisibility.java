package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC003_ButtonVisibility extends ProjectSpecificationMethods{

	
	
	
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
}