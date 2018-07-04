package stepDenfinitions;


import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManger;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.RegisterPagePO;


public class RegisterPageSteps {
	private RegisterPagePO registerPage;
	private AbstractTest abstractTest;
	String username, password, loginUrl = "http://demo.guru99.com/v4";
	WebDriver driver;

	public RegisterPageSteps() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManger.getRegisterPage(driver);
		abstractTest = new AbstractTest();
	}

	@When("^I input to email textbox$")
	public void i_input_to_email_textbox() {
		registerPage.inputToEmailIDTextbox("trangdk" + abstractTest.randomData() + "@gmail.com");
	}

	@When("^I click to submit button$")
	public void i_click_to_submit_button() {
		registerPage.clickToSubmitButton();
	}

	@When("^I get to username information$")
	public void i_get_to_username_information() {
		username = registerPage.getUserIdInfor();
	}

	@When("^I get to password information$")
	public void i_get_to_password_information() {
		password = registerPage.getPasswordInfo();
	}

	@When("^I open login page$")
	public void i_open_login_page() {
		registerPage.openLoginPage(loginUrl);
	}

}
