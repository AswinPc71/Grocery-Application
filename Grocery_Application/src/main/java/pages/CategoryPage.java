package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Cat;

public class CategoryPage {
	WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newCategoryRegistration;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']") WebElement categorySearchBlue;
	@FindBy(xpath ="//input[@id='category']") WebElement categoryName;
	@FindBy(xpath ="//li[@id='1-selectable']") WebElement groupGoodness;
	@FindBy(xpath ="//li[@id='2-selectable']") WebElement groupVegan;
	@FindBy(xpath ="//li[@id='3-selectable']") WebElement groupGlutenFree;
	@FindBy(xpath ="//li[@id='4-selectable']") WebElement groupOrganic;
	@FindBy(xpath ="//li[@id='5-selectable']") WebElement groupEmployees;
	@FindBy(xpath ="//li[@id='10-selectable']") WebElement groupFastFoods;
	@FindBy(xpath ="//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath ="//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath ="//input[@placeholder='Category']") WebElement searchCategory;
	@FindBy(xpath ="//button[text()='Search']") WebElement categorySearchRed;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement newCategoryCreatedAlert;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=319&page_ad=1']") WebElement searchedCategoryFoundAlert;
	
	public CategoryPage clickNewCategoryRegistration() {
		newCategoryRegistration.click();
		return this;
	}
	
    public CategoryPage clickCategorySearchBlue() {
		categorySearchBlue.click();
		return this;
	}

    public CategoryPage enterCategoryName() {
		categoryName.sendKeys("Honey");
		return this;
	}
    
    public CategoryPage clickGroupGoodness() {
		groupGoodness.click();
		return this;
	}
    
    public CategoryPage clickGroupVegan() {
		groupVegan.click();
		return this;
	}
    
    public CategoryPage clickGlutenFree() {
		groupGlutenFree.click();
		return this;
	}
    
    public CategoryPage clickGroupOrganic() {
		groupOrganic.click();
		return this;
	}
    
    public CategoryPage clickGroupEmployees() {
		groupEmployees.click();
		return this;
	}
    
    public CategoryPage clickGroupFastFoods() {
		groupFastFoods.click();
		return this;
	}
    
    public CategoryPage uploadPicture() {
		chooseFile.sendKeys("C:\\Users\\aswin\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-11-05 232824.png");
		return this;
   	}
    
    public CategoryPage clickSaveButton() {
    	Actions action = new Actions(driver);
		action.click(saveButton).perform();
		return this;
   	}
    
    public CategoryPage enterCategoryToSearch() {
		searchCategory.sendKeys("Honey");
		return this;
   	}
    
    public CategoryPage clickCategorySearchRed() {
		categorySearchRed.click();
		return this;
   	}
    
    public Boolean verifyNewCategoryWasCreatedSuccefully() {
    	return newCategoryCreatedAlert.isDisplayed();
    }
    
    public Boolean verifySearchedCategoryWasFound() {
    	return searchedCategoryFoundAlert.isDisplayed();
    }
    

}
