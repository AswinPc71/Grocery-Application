package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage hp;
	
	@Test(description = "User is trying to logout")
	public void verifyWetherUserisAbleToSucessfullyLogOut() throws IOException, AWTException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();
		
		hp.clickAdmin();
		lp = hp.clickLogOut();
		
		//Assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.LOGOUTERROR);
		
	}

}
