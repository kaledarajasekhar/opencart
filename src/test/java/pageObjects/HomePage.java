package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myaccount;

	@FindBy(xpath = "(//a[text()='Register'])[1]")
	WebElement register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement login;

	public void clickMyAcc() {
		myaccount.click();
	}

	public void clickReg() {
		register.click();
	}

	public void clickLogin() {
		login.click();
	}
}
