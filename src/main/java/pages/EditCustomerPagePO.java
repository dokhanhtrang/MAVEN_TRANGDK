package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.EditCustomerPageUI;

public class EditCustomerPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public EditCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputCustomerid(String customerId) {
		waitForControlVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TXT, customerId);
	}

	public void clickToSubmitAcc() {
		waitForControlVisible(driver, EditCustomerPageUI.SUBMIT_ACC_BTN);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_ACC_BTN);
	}

	public void inputCustomerName(String customerName) {
		waitForControlVisible(driver, EditCustomerPageUI.CUSTOMER_NAME_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.CUSTOMER_NAME_TXT, customerName);
	}

	public void checkGender() {
		waitForControlVisible(driver, EditCustomerPageUI.GENDER_TXT);
		checkCheckbox(driver, EditCustomerPageUI.GENDER_TXT);
	}

	public void inputDob(String dob) {
		waitForControlVisible(driver, EditCustomerPageUI.DATE_OF_BIRTH_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.DATE_OF_BIRTH_TXT, dob);
	}

	public void inputAdd(String add) {
		waitForControlVisible(driver, EditCustomerPageUI.ADD_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.ADD_TXT, add);
	}

	public void inputCity(String city) {
		waitForControlVisible(driver, EditCustomerPageUI.CTIY_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.CTIY_TXT, city);
	}

	public void inputState(String state) {
		waitForControlVisible(driver, EditCustomerPageUI.STATE_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.STATE_TXT, state);
	}

	public void inputPIN(String pin) {
		waitForControlVisible(driver, EditCustomerPageUI.PIN_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.PIN_TXT, pin);
	}

	public void inputMobile(String mobile) {
		waitForControlVisible(driver, EditCustomerPageUI.MOBILE_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.MOBILE_TXT, mobile);
	}

	public void inputMail(String email) {
		waitForControlVisible(driver, EditCustomerPageUI.EMAIL_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.EMAIL_TXT, email);
	}

	public void inputPassword(String pass) {
		waitForControlVisible(driver, EditCustomerPageUI.PASSWORD_TXT);
		sendkeysToElement(driver, EditCustomerPageUI.PASSWORD_TXT, pass);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, EditCustomerPageUI.MOBILE_TXT);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BTN);
	}
	public void clickToAlert() {
		waitForControlVisible(driver, EditCustomerPageUI.EDIT_FRM);
		acceptAlert(driver);
	}
}
