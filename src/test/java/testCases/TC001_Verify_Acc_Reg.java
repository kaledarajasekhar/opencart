package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import tastBase.OrangeHrm;

public class TC001_Verify_Acc_Reg extends OrangeHrm {

	@Test(groups={"sanity","master"})
	public void verifyAccountReg() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAcc();
		homePage.clickReg();

		RegisterPage reg = new RegisterPage(driver);
		reg.firstName("raj");
		reg.lastName("sekhar");
		reg.email(randomString() + "@gamil.com");
		reg.phone(randomNumber());
		String pass = randomNumber().substring(5) + randomString().substring(0, 6);
		reg.pass(pass);
		reg.confPass(pass);
		reg.agree();
		reg.contine();
		Assert.assertEquals(reg.conformMessage(), "Your Account Has Been Created!");

	}

	public String randomString() {
		return RandomStringUtils.randomAlphabetic(10);
	}

	public String randomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

}
