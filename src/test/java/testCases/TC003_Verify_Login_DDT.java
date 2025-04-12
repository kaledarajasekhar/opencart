package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import tastBase.OrangeHrm;
import utilities.DataProviders;

public class TC003_Verify_Login_DDT extends OrangeHrm {

	@Test(dataProvider = "login", dataProviderClass = DataProviders.class,groups="datadriven")
	public void login(String email, String password, String exp) throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickMyAcc();
		home.clickLogin();

		LoginPage login = new LoginPage(driver);
		login.sendEmail(email);
		login.sendPassword(password);
		login.clickLogin();

		MyAccount myAcc = new MyAccount(driver);

		if (exp.equalsIgnoreCase("valid")) {
			if (myAcc.isMsgHeading()) {
				myAcc.logout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("invalid")) {
			if (myAcc.isMsgHeading()) {
				myAcc.logout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
	}
}
