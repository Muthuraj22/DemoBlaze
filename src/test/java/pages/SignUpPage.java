package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods{
	
	@FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signUpConfirmButton;
    
    public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	public SignUpPage enterUsername(String username){
		usernameField.sendKeys(username);
		return this;
	}
	
	public SignUpPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	
	public boolean isSignUpButtonClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(signUpConfirmButton)) != null;
    }
	public SignUpPage clickSignUpConfirmButton() {
		signUpConfirmButton.click();
		return this;
	}
	
}
