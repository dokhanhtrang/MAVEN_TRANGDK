package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewAccountPageUI;
import interfaces.NewCustomerPageUI;

public class NewAccountPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public NewAccountPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputCustomerId(String cusId) {
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TXT);
		sendkeysToElement(driver, NewAccountPageUI.CUSTOMER_ID_TXT, cusId);
	}

	public void selectAccountType() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_TXT);
		selectByIndex(driver, NewAccountPageUI.ACCOUNT_TYPE_TXT, 0);
	}

	public void inputInitDeposit(String accType) {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_TXT);
		sendkeysToElement(driver, NewAccountPageUI.ACCOUNT_TYPE_TXT, accType);
	}

	public String getAccountId() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
		clickToElement(driver, NewAccountPageUI.ACCOUNT_ID_TXT);
	}
}
