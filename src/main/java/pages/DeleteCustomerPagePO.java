package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DeleteCustomerPagePO extends AbstractPage {
	WebDriver driver;

	// contructor
	public DeleteCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
}
