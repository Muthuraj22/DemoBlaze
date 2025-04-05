package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC004_MenuItemsDisplay extends ProjectSpecificationMethods{

	

	    @Test
	    public void testMenuItemsDisplayed() {
	    	HomePage obj3 = new HomePage(driver);
	    	obj3.validateMenuItemsDisplayed();
	    }
}