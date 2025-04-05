package base;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utils.Utility;

public class ProjectSpecificationMethods extends Utility{
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void launchingBrowserAndLoadingURL(String url, String browser) {
		System.out.println("URL received: " + url);
	    System.out.println("Browser received: " + browser);
		browser(url, browser);
	}
	
	@AfterMethod
	public void closeBrowser() {
		if (driver != null) {  // Ensure driver is not null
	        try {
	            driver.quit();
	            driver = null; // Reset driver to prevent reuse of a closed session
	        } catch (WebDriverException e) {
	            System.out.println("WebDriver already closed or invalid session.");
	        }
	    } 
	}
	
	
}
