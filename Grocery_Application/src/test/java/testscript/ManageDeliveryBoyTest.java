package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;


public class ManageDeliveryBoyTest extends Base{
	
	HomePage hp;
	ManageDeliveryBoyPage mdbp;

	@Test(description = "User is trying to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException, AWTException {
		
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginData");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginData");
		lp.enterUserName(userNameValue).enterPassword(passwordValue);
		hp = lp.clickSignIn();
		
	
		mdbp = hp.clickManageDeliveryBoy();
		
		RandomDataUtility rdu = new RandomDataUtility();
		String newDeliveryBoyNameValue = rdu.generateRandomFullName();
		String newDeliveryBoyEmailValue = rdu.generateRandomEmailId();
		String newDeliveryBoyPhoneNumberValue = rdu.generateRandomPhoneNumber();
		String newDeliveryBoyAddressValue = rdu.generateRandomAddress();
		String newDeliveryBoyUserNameValue = rdu.generateRandomUserName();
		String newDeliveryBoyPasswordValue = rdu.generateRandomPassword();
		
	
		mdbp.clickNewDeliveryBoyRegistration().enterName(newDeliveryBoyNameValue).enterEmail(newDeliveryBoyEmailValue).enterPhoneNumber(newDeliveryBoyPhoneNumberValue).enterAddress(newDeliveryBoyAddressValue).enterUserName(newDeliveryBoyUserNameValue).enterPassword(newDeliveryBoyPasswordValue).clickSaveButton();
		
		boolean detailsCreatedSuccessfully = mdbp.verifyNewDeliveryBoyDetailsCreatedAlert();
		Assert.assertTrue(detailsCreatedSuccessfully,Constant.DELIVERYBOYCREATIONERROR);
		
	}


}
