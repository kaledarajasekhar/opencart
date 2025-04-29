package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement phone;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement conformPassword;

	@FindBy(name = "agree")
	WebElement agree;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement continu;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement messageConfiomation;

	public void firstName(String name) {
		firstName.sendKeys(name);
	}

	public void lastName(String name) {
		lastName.sendKeys(name);
	}

	public void email(String emai) {
		email.sendKeys(emai);
	}

	public void phone(String phon) {
		phone.sendKeys(phon);
	}

	public void pass(String pass) {
		password.sendKeys(pass);
	}

	public void confPass(String pass) {
		conformPassword.sendKeys(pass);
	}

	public void agree() {
		agree.click();
	}

	public void contine() {
		continu.click();
	}

	public String conformMessage() {
		try {
			return messageConfiomation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
