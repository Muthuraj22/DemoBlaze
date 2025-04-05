package tests;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC006_LogoDisplay extends ProjectSpecificationMethods{
	
	@Test
    public void testApplicationLogoDisplayed() {
    	HomePage obj5 = new HomePage(driver);
    	obj5.validateApplicationLogo();
    }
}