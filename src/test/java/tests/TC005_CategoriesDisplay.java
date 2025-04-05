package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC005_CategoriesDisplay extends ProjectSpecificationMethods{

	 @Test
	    public void testCategoriesDisplayed() {
	    	HomePage obj4 = new HomePage(driver);
	    	obj4.validateCategoriesDisplayed();
	    }
}