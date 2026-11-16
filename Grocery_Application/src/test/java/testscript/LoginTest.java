package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void enterValidUsernameAndPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		home = lp.clickSignIn();
		// Assertion
		boolean dashBoardValue = lp.verifyWeatherDashBoardIsDisplayed();
		Assert.assertTrue(dashBoardValue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void enterValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginData");

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userNameValue).enterPassword(passwordValue).clickSignIn();

		// Assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDANDINVALIDERROR);
	}

	@Test(priority = 3, description = "User is trying to login with invalid username and valid password")
	public void enterInvalidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginData");

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userNameValue).enterPassword(passwordValue).clickSignIn();

		// Assertion
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDANDVALIDERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid credentials", groups = {
			"smoke" }, dataProvider = "LoginData")
	public void enterInvalidUsernameAndPassword(String userNameValue, String passwordValue) throws IOException {
		// String userNameValue = ExcelUtility.readStringData(3, 0, "LoginData");
		// String passwordValue = ExcelUtility.readStringData(3, 1, "LoginData");

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userNameValue).enterPassword(passwordValue).clickSignIn();

		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "Admin", "Admin22" }, new Object[] { "User", "User22" }, };
	}
}
