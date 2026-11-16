package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	HomePage hp;
	AdminUsersPage aup;
	
	@Test(description = "User is trying to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUsers() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();
		
		aup = hp.clickAdminUsers();
		
		RandomDataUtility rdu = new RandomDataUtility();
		String newRegisterUserNameValue = rdu.generateRandomUserName();
		String newRegisterPasswordValue = rdu.generateRandomPassword();
		//String newRegisterUserNameValue = ExcelUtility.readStringData(0, 0, "AdminUserRegisterData");
		//String newRegisterPasswordValue = ExcelUtility.readStringData(0, 1, "AdminUserRegisterData");
		aup.clickNewRegistration().enterUserName(newRegisterUserNameValue).enterPassword(newRegisterPasswordValue).selectUserType().clickSave();
		boolean createdSuccessfully = aup.verifyAdminUserInformationIsDisplayed();
		Assert.assertTrue(createdSuccessfully,Constant.ADMINUSERCREATIONERROR);
		
		
		
				
	}
	
	@Test(description = "User is trying to search newly added admin user")
	public void verifyWhetherUserIsAbleToSearchTheRecentlyAddedAdminUser() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
        lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();
		
		aup = hp.clickAdminUsers();
		
		String newSearchUserNameValue = ExcelUtility.readStringData(0, 0, "AdminUserRegisterData");
		aup.clickSearchBlue().enterInSerachUserName(newSearchUserNameValue).selectSearchUserType().clickSearchRed();
		boolean resultFound = aup.verifySearchedUserInformationFound();
		Assert.assertTrue(resultFound,Constant.ADMINUSESEARCHERROR);
		
	}
	

}
