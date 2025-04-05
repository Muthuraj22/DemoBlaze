package tests;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC002_LoginFunctionality extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setup() throws IOException{
		//flat file
		readFromFile("C:\\Users\\mraj2\\eclipse-workspace\\DemoBlaze\\src\\test\\resources\\SignUpData.properties");
		
	}
	
	@Test
	public void LoginTest() throws IOException, InterruptedException {
		//Sheets
		String filepath = "C:\\Users\\mraj2\\eclipse-workspace\\DemoBlaze\\src\\test\\resources\\LoginData.xlsx";
		
		String username = getCellData(filepath,"LoginData",1,0);
		String password = getCellData(filepath,"LoginData",1,1);
		
		    
		HomePage home = new HomePage (driver);
		
		home.clickLogin()
		.enterUsername(username)
		.enterPassword(password);
		home.clickLoginButton();
		home.validateLogin();

	}

}
