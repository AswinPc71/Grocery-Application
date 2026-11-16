package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{
	
	HomePage hp;
	CategoryPage cp;
	
	@Test(description = "User is trying to add new category")
	public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();

		cp = hp.clickCategory();
		
		cp.clickNewCategoryRegistration().enterCategoryName().clickGroupGoodness().clickGlutenFree().clickGroupVegan().clickGroupOrganic().uploadPicture().clickSaveButton();
		
		boolean categoryCreatedSuccessfully = cp.verifyNewCategoryWasCreatedSuccefully();
		Assert.assertTrue(categoryCreatedSuccessfully,Constant.CATEGORYCREATIONERROR);
			
	}
	
	@Test(description = "User is trying to search recently added category")
	public void verifyWhetherUserisAbleToSearchRecentlyCreatedCategory() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();
		
		cp = hp.clickCategory();
		
		cp.clickCategorySearchBlue().enterCategoryToSearch().clickCategorySearchRed();
		
		boolean searchedCategoryFound = cp.verifySearchedCategoryWasFound();
		Assert.assertTrue(searchedCategoryFound,Constant.CATEGORYSEARCHERROR);
	}

}
