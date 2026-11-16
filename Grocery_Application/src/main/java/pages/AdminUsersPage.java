package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pu = new PageUtility();
	
	public  AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newRegistration;
	@FindBy(xpath ="//input[@id='username']") WebElement userName;
	@FindBy(xpath ="//input[@id='password']") WebElement password;
	@FindBy(xpath ="//select[@name='user_type']") WebElement userType;
	@FindBy(xpath ="//button[@name='Create']") WebElement save;
	@FindBy(xpath ="//a[text()='Reset']") WebElement newReset;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement userCreatedAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchBlue;
	@FindBy(xpath="//input[@id='un']") WebElement searchUserName;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchUserType;
	@FindBy(xpath = "//button[@value='sr']")WebElement searchRed;
	@FindBy(xpath = "//span[text()='Active']") WebElement active;
	
	public AdminUsersPage clickNewRegistration() {
		newRegistration.click();
		return this;
	}
	
	public AdminUsersPage enterUserName(String newRegisterUserNameValue) {
		userName.sendKeys(newRegisterUserNameValue);
		return this;
	}
	
	public AdminUsersPage enterPassword(String newRegisterPasswordValue) {
		password.sendKeys(newRegisterPasswordValue);
		return this;
	}
	
	public AdminUsersPage selectUserType() {
		pu.selectDropdownWithValue(userType, "admin");
		return this;
	}
	
	public AdminUsersPage clickSave() {
		save.click();
		return this;
	}
	
	public boolean verifyAdminUserInformationIsDisplayed() {
		return userCreatedAlert.isDisplayed();
	}
	
	public AdminUsersPage clickSearchBlue() {
		searchBlue.click();
		return this;
	}
	
	public AdminUsersPage enterInSerachUserName(String newSearchUserNameValue) {
		searchUserName.sendKeys(newSearchUserNameValue);
		return this;
	}
	
	public AdminUsersPage selectSearchUserType() {
		pu.selectDropdownWithValue(searchUserType, "admin");
		return this;
	}
	
	public AdminUsersPage clickSearchRed() {
		searchRed.click();
		return this;
	}
	
	public boolean verifySearchedUserInformationFound() {
		return active.isDisplayed();
	}
	

}
