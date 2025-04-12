package pageObjects;

import org.checkerframework.checker.initialization.qual.FBCBottom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement login;

	public void sendEmail(String email) {
		this.email.sendKeys(email);
	}

	public void sendPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLogin() {
		login.submit();
	}
}
