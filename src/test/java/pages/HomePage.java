package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods{
	
	private WebDriverWait Wait;
	
	@FindBy(id = "signin2")
	private WebElement SignUpButton;
	
	@FindBy(id = "login2")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement Login;
	
	@FindBy(id = "nameofuser")
	private WebElement validLoginText;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeMenu;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	private WebElement contactMenu;

	@FindBy(xpath = "//a[contains(text(),'About us')]")
	private WebElement aboutUsMenu;

	@FindBy(xpath = "//a[text()='Cart']")
	private WebElement cartMenu;

	@FindBy(xpath = "//a[text()='Phones']")
    private WebElement phonesCategory;

	@FindBy(xpath = "//a[text()='Laptops']")
	private WebElement laptopsCategory;

	@FindBy(xpath = "//a[text()='Monitors']")
	private WebElement monitorsCategory;

	@FindBy(id = "nava")
	private WebElement applicationLogo;
	
	@FindBy(partialLinkText = "Welcome")
	private WebElement WelcomeUser;
	
	@FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
	private WebElement firstProduct;
	
	@FindBy(xpath = "//a[contains(text(),'Nokia lumia 1520')]")
	private WebElement secondProduct;
	
	@FindBy(xpath = "//a[contains(text(),'Nexus 6')]")
	private WebElement thirdProduct;
	
	@FindBy(id = "logout2")
	private WebElement logoutButton;
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	 public boolean isSignUpButtonDisplayed() {
	        return SignUpButton.isDisplayed();
	    }
	
	public SignUpPage clickSignUp() {
		SignUpButton.click();
		return new SignUpPage(driver);	//constructor chaining
	}
	
	public boolean isLoginButtonDisplayed() {
        return LoginButton.isDisplayed();
    }
	
	public LoginPage clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickLoginButton() {
		Login.click();
		return new LoginPage(driver);
	}
	public void validateLogin() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(validLoginText));
	        Assert.assertTrue(element.isDisplayed(), "User login validation failed: Welcome message not displayed.");
		
		
	}
	
	
	public void validateMenuItemsDisplayed() {
        Assert.assertTrue(homeMenu.isDisplayed(), "Home menu is not displayed");
        Assert.assertTrue(contactMenu.isDisplayed(), "Contact menu is not displayed");
        Assert.assertTrue(aboutUsMenu.isDisplayed(), "About Us menu is not displayed");
        Assert.assertTrue(cartMenu.isDisplayed(), "Cart menu not displayed");
	}

    public void validateCategoriesDisplayed() {
    	Assert.assertTrue(phonesCategory.isDisplayed(), "Phones category not displayed");
        Assert.assertTrue(laptopsCategory.isDisplayed(), "Laptops category not displayed");
        Assert.assertTrue(monitorsCategory.isDisplayed(), "Monitors category not displayed");
    }

    public void validateApplicationLogo() {
        Assert.assertTrue(applicationLogo.isDisplayed(), "Application logo is not displayed");
    }
    
    public void validateWelcomeUserText(String username) {
    	String actualText = WelcomeUser.getText();
    	String expectedText = ("Welcome "+username);
    	
    	Assert.assertEquals(actualText, expectedText);
    }
    
    public ProductDetailsPage clickFirstProduct() {
		firstProduct.click();
		return new ProductDetailsPage(driver);	
	}
    
    public HomePage click1Product() {
		firstProduct.click();
		return this;	
	}
    
    public HomePage clickSecondProduct() {	
    	secondProduct.click();
		return this;	
	}
    
    public HomePage clickThirdProduct() {
		thirdProduct.click();
		return this;	
	}
    
    public CartPage clickCartMenu() throws InterruptedException {
		cartMenu.click();
		return new CartPage(driver);	
	}

	public void getTitle() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
	}
	
	public void verifyLogoutButtonVisible() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(logoutButton));
	    Assert.assertTrue(logoutButton.isDisplayed(), "Log out button is not visible on the dashboard.");
	}
	
	public void clickLogout() {
	    logoutButton.click();
	}
	
	public void logoutRedirection() {
		 Wait.until(ExpectedConditions.visibilityOf(LoginButton));
		 Assert.assertTrue(LoginButton.isDisplayed(), "User is not redirected to the Home Page after logout.");
	}
	
}
