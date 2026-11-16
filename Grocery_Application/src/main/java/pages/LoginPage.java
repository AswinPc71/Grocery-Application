package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
		WebDriver driver;
		WaitUtility wu = new WaitUtility();
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath ="//input[@name='username']") WebElement userName;
		@FindBy(xpath ="//input[@name='password']") WebElement password;
		@FindBy(xpath ="//button[@type='submit']") WebElement signIn;
		@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashBoard;
		@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement loginPageText;
		
		public LoginPage enterUserName(String userNameValue) {
			userName.sendKeys(userNameValue);
			return this;
		}
		
		public LoginPage enterPassword(String passwordValue) {
			password.sendKeys(passwordValue);
			return this;
		}
		
		public HomePage clickSignIn() {
			wu.waitUntilElementToBeClickable(driver, signIn);
			signIn.click();
			return new HomePage(driver);
		}
		
		public boolean verifyWeatherDashBoardIsDisplayed() {
			return dashBoard.isDisplayed();
		}
		
		public String verifyLoginTextIsDisplayed() {
			return loginPageText.getText();
		}

}
