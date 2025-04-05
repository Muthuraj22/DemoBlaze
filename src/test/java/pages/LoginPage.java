package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods {
	
	@FindBy (id = "loginusername")
	private WebElement usernameField;
	
	@FindBy (id = "loginpassword")
	private WebElement passwordField;
	
	@FindBy (xpath ="//button[text()='Log in']")
	private WebElement LoginButton;
	
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUsername(String username) {
		usernameField.sendKeys(username);
		return this;
	}
	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	public HomePage clickLogin() {
		LoginButton.click();
		return new HomePage(driver);
	}
	public boolean isLoginButtonClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(LoginButton)) != null;
    }
	

	
}
	

