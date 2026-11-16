package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	
	WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newDeliveryBoyRegistration;
	@FindBy(xpath = "//input[@id='name']") WebElement name;
	@FindBy(xpath = "//input[@id='email']") WebElement email;
	@FindBy(xpath = "//input[@id='phone']") WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@id='address']") WebElement address;
	@FindBy(xpath = "//input[@id='username']") WebElement userName;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newDeliveryBoyDetailsCreatedAlert;
	
	public ManageDeliveryBoyPage clickNewDeliveryBoyRegistration() {
		newDeliveryBoyRegistration.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterName(String newDeliveryBoyNameValue) {
		name.sendKeys(newDeliveryBoyNameValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterEmail(String newDeliveryBoyEmailValue) {
		email.sendKeys(newDeliveryBoyEmailValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterPhoneNumber(String newdDeliveryBoyPhoneNumberValue) {
		phoneNumber.sendKeys(newdDeliveryBoyPhoneNumberValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterAddress(String newDeliveryBoyAddressValue) {
		address.sendKeys(newDeliveryBoyAddressValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterUserName(String newDeliveryBoyUserNameValue) {
		userName.sendKeys(newDeliveryBoyUserNameValue);
		return this;
	}
	
	public ManageDeliveryBoyPage enterPassword(String newdeliveryBoyPasswordValue) {
		password.sendKeys(newdeliveryBoyPasswordValue);
		return this;
	}
	
	public ManageDeliveryBoyPage clickSaveButton() {
		Actions action = new Actions(driver);
		action.click(saveButton).perform();
		return this;
	}
	
	public boolean verifyNewDeliveryBoyDetailsCreatedAlert() {
		return newDeliveryBoyDetailsCreatedAlert.isDisplayed();
	}
	


}
