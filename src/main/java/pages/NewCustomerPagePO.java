package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public NewCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputCustomerName(String customerName) {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TXT, customerName);
	}

	public void checkGender() {
		waitForControlVisible(driver, NewCustomerPageUI.GENDER_TXT);
		checkCheckbox(driver, NewCustomerPageUI.GENDER_TXT);
	}

	public void inputDob(String dob) {
		waitForControlVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TXT, dob);
	}

	public void inputAdd(String add) {
		waitForControlVisible(driver, NewCustomerPageUI.ADD_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.ADD_TXT, add);
	}

	public void inputCity(String city) {
		waitForControlVisible(driver, NewCustomerPageUI.CTIY_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.CTIY_TXT, city);
	}

	public void inputState(String state) {
		waitForControlVisible(driver, NewCustomerPageUI.STATE_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.STATE_TXT, state);
	}

	public void inputPIN(String pin) {
		waitForControlVisible(driver, NewCustomerPageUI.PIN_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.PIN_TXT, pin);
	}

	public void inputMobile(String mobile) {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.MOBILE_TXT, mobile);
	}

	public void inputMail(String email) {
		waitForControlVisible(driver, NewCustomerPageUI.EMAIL_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.EMAIL_TXT, email);
	}

	public void inputPassword(String pass) {
		waitForControlVisible(driver, NewCustomerPageUI.PASSWORD_TXT);
		sendkeysToElement(driver, NewCustomerPageUI.PASSWORD_TXT, pass);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, NewCustomerPageUI.MOBILE_TXT);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BTN);
	}
	public String getCustomerID() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TXT);
	}

}
