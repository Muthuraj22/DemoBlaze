package tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC001_SignUpFunctionality extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setup() throws IOException {
	filepath = "C:\\Users\\mraj2\\eclipse-workspace\\DemoBlaze\\src\\test\\resources\\SignUpData.properties";
	readFromFile(filepath);
	}
	
	@Test (priority=1)
	public void SignUpTest() {
		
		HomePage obj = new HomePage(driver);
		
		obj.clickSignUp()
		.enterUsername(prop.getProperty("usernameField"))
		.enterPassword(prop.getProperty("passwordField"))
		.clickSignUpConfirmButton();
		

	}
	
}
