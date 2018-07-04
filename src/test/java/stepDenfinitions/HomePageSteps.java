package stepDenfinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManger;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pages.HomePagePO;

public class HomePageSteps {
	private HomePagePO homePage;
	private AbstractTest abstractTest;
	WebDriver driver;

	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManger.getHomePage(driver);
		abstractTest = new AbstractTest();
	}

	@Then("^I verify homepage welcome message displayed$")
	public void i_verify_homepage_welcome_message_displayed() {
		abstractTest.verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
}
