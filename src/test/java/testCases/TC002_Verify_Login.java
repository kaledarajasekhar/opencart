package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import tastBase.OrangeHrm;

public class TC002_Verify_Login extends OrangeHrm {

	@Test(groups = { "regression", "master" })
	public void loginTest() {

		HomePage home = new HomePage(driver);
		home.clickMyAcc();
		home.clickLogin();

		LoginPage login = new LoginPage(driver);
		login.sendEmail(p.getProperty("email"));
		login.sendPassword(p.getProperty("password"));
		login.clickLogin();

		MyAccount myAccount = new MyAccount(driver);
		boolean heading = myAccount.isMsgHeading();
		Assert.assertEquals(heading, true);
	}
}
