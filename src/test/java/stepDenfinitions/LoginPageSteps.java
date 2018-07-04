package stepDenfinitions;

import org.openqa.selenium.WebDriver;

import commons.PageFactoryManger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.LoginPagePO;

public class LoginPageSteps {
	WebDriver driver;
	String username ="mngr139374", password="ypynYvu", loginUrl;

	private LoginPagePO loginPage;

	public LoginPageSteps() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManger.getLoginPage(driver);
	}

	@Given("^I get login url$")
	public void i_get_login_url() {
		loginUrl = loginPage.getLoginUrl();
	}

	@When("^I click to here link$")
	public void i_click_to_here_link() {
		loginPage.clickToHereLink();
	}

	@When("^I input to username textbox$")
	public void i_input_to_username_textbox() {
		loginPage.inputToUserIDTextbox(username);
	}

	@When("^I input to password textbox$")
	public void i_input_to_password_textbox() {
		loginPage.inputToPasswordTextbox(password);
	}

	@When("^I submit button$")
	public void i_submit_button() {
		loginPage.clickToLoginButton();
	}

//	@Then("^I close browser$")
//	public void i_close_browser() {
//		driver.close();
//	}

}
