package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement msgHeading;

	@FindBy(xpath = "(//div[@class='list-group']//a)[13]")
	WebElement logout;

	public boolean isMsgHeading() {
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void logout() {
		logout.click();
	}
}
