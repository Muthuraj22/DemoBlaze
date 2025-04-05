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

public class PlaceOrderPage extends ProjectSpecificationMethods {

	private WebDriverWait wait;
	
    @FindBy(id = "orderModal")  
    private WebElement placeOrderModal;

    @FindBy(id = "name")  
    private WebElement nameField;

    @FindBy(id = "country")  
    private WebElement countryField;

    @FindBy(id = "city")  
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(css = ".sweet-alert.showSweetAlert.visible")
    private WebElement confirmationModal;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;


    
    public PlaceOrderPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyPlaceOrderWindow() throws InterruptedException {
    	Assert.assertTrue(placeOrderModal.isDisplayed(), "Place Order window is not displayed.");
    }

    public void verifyUserDetailsSections() {
        Assert.assertTrue(nameField.isDisplayed(), "Name field is not displayed.");
        Assert.assertTrue(countryField.isDisplayed(), "Country field is not displayed.");
        Assert.assertTrue(cityField.isDisplayed(), "City field is not displayed.");
    }
    
    public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickPurchase() {
        purchaseButton.click();
    }

    public void verifyOrderSuccessPayment() {
        wait.until(ExpectedConditions.visibilityOf(confirmationModal));
        String confirmationText = confirmationModal.getText();
        Assert.assertTrue(confirmationText.contains("Thank you for your purchase"), "Order confirmation message not found");
    }

    public void clickOK() {
        okButton.click();
    }
    
}
