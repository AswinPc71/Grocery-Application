package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-cog']") WebElement settings;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logOut;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement manageDeliveryBoy;
	@FindBy(css = "a.small-box-footer[href=\"https://groceryapp.uniqassosiates.com/admin/list-category\"]") WebElement category;
	
	public HomePage clickAdmin() {
		admin.click();
		return this; 
	}
	
	public void clickSettings() {
		settings.click();
	}
	
	public LoginPage clickLogOut() {
		logOut.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickAdminUsers() {
		adminUsers.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageDeliveryBoyPage clickManageDeliveryBoy() {
		manageDeliveryBoy.click();
		return new ManageDeliveryBoyPage(driver);
	}
	
	public CategoryPage clickCategory() {
		category.click();
		return new CategoryPage(driver);
	}

}
