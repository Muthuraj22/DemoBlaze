package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC007_WelcomeUserDisplay extends ProjectSpecificationMethods{
	
	@Test
    public void testWelcomeUserDisplayed() throws IOException {
		
String filepath = "C:\\Users\\mraj2\\eclipse-workspace\\DemoBlaze\\src\\test\\resources\\LoginData.xlsx";
		
		String username = getCellData(filepath,"LoginData",1,0);
		String password = getCellData(filepath,"LoginData",1,1);
		
		    
		HomePage home = new HomePage (driver);
		
		home.clickLogin()
		.enterUsername(username)
		.enterPassword(password);
		home.clickLoginButton();
    	
    	home.validateWelcomeUserText(username);
    }
}
