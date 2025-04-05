package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC016_LogoutFunctionality extends ProjectSpecificationMethods{
	
	@Test
    public void testCompletePurchaseProcess() throws InterruptedException, IOException {
      
        String filepath = "C:\\Users\\mraj2\\eclipse-workspace\\DemoBlaze\\src\\test\\resources\\LoginData.xlsx";
		
		String username = getCellData(filepath,"LoginData",1,0);
		String password = getCellData(filepath,"LoginData",1,1);
		
		    
		HomePage home = new HomePage (driver);
		
		home.clickLogin()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.validateLogin();
		
		home.verifyLogoutButtonVisible();
		home.clickLogout();
		home.logoutRedirection();
        
	}

}
