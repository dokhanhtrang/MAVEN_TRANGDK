package pages;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import commons.PageFactoryManger;
import interfaces.RegisterPageUI;

public class RegisterPagePO extends AbstractPage {
	WebDriver driver;
	// contructor
	public RegisterPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	public void inputToEmailIDTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAILID_TXT);
		sendkeysToElement(driver, RegisterPageUI.EMAILID_TXT, email);
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
	}

	public String getUserIdInfor() {
		waitForControlVisible(driver, RegisterPageUI.USERID_TEXT);
		return getTextElement(driver, RegisterPageUI.USERID_TEXT);

	}

	public String getPasswordInfo() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}
	public String getEmailID() {
		waitForControlVisible(driver, RegisterPageUI.EMAILID_TXT);
		return getTextElement(driver, RegisterPageUI.EMAILID_TXT);
	}

	public LoginPagePO openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		return PageFactoryManger.getLoginPage(driver);
	}
}
