package stepDenfinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractTest;
import commons.PageFactoryManger;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pages.NewCustomerPagePO;

public class NewCustomerPageSteps {
	WebDriver driver;
	private AbstractTest abstractTest;
	private NewCustomerPagePO newCustomerPage;
	
	public NewCustomerPageSteps() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManger.getNewCustomerPage(driver);
	}

	@And("^I click to New Customer Page$")
	public void i_click_to_new_customer_page() {
		driver.findElement(By.xpath("//a[(text()='New Customer')]")).click();
	}

	@And("^I input all information in this page$")
	public void i_input_all_information_in_this_page(DataTable table) {
		WebElement customerName = driver.findElement(By.xpath("//input[@name='name']"));
		WebElement gender = driver.findElement(By.xpath("//input[@value='f']"));
		WebElement DOB = driver.findElement(By.xpath("//input[@name='dob']"));
		WebElement add = driver.findElement(By.xpath("//textarea[@name='addr']"));
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		WebElement pin = driver.findElement(By.xpath("//input[@name='pinno']"));
		WebElement phoneNo = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		WebElement mail = driver.findElement(By.xpath("//input[@name='emailid']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		customerName.sendKeys(customer.get(0).get("Customer"));
		gender.click();
		DOB.sendKeys(customer.get(0).get("DateOfBirth"));
		add.sendKeys(customer.get(0).get("Address"));
		city.sendKeys(customer.get(0).get("City"));
		state.sendKeys(customer.get(0).get("State"));
		pin.sendKeys(customer.get(0).get("PIN"));
		phoneNo.sendKeys(customer.get(0).get("Phone"));
		mail.sendKeys(customer.get(0).get("Email") + abstractTest.randomData() + "@gmail.com");
		password.sendKeys(customer.get(0).get("Password"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("^I verify all information$")
	public void i_verify_all_information(DataTable table) {
		WebElement customerName = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td"));
		WebElement gender = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
		WebElement DOB = driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td"));
		WebElement add = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
		WebElement city = driver.findElement(By.xpath("//td[text()='City']/following-sibling::td"));
		WebElement state = driver.findElement(By.xpath("//td[text()='State']/following-sibling::td"));
		WebElement pin = driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td"));
		WebElement phoneNo = driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td"));
		WebElement mail = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td"));
		
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);

		Assert.assertEquals(customerName.getText(), customer.get(0).get("Customer"));
		Assert.assertEquals(gender.getText(), customer.get(0).get("Gender"));
		Assert.assertEquals(DOB.getText(), customer.get(0).get("DateOfBirth"));
		Assert.assertEquals(add.getText(), customer.get(0).get("Address"));
		Assert.assertEquals(city.getText(), customer.get(0).get("City"));
		Assert.assertEquals(state.getText(), customer.get(0).get("State"));
		Assert.assertEquals(pin.getText(), customer.get(0).get("PIN"));
		Assert.assertEquals(phoneNo.getText(), customer.get(0).get("Phone"));
		Assert.assertEquals(mail.getText(), customer.get(0).get("Email"));
	}

	@Then("^I click sub button$")
	public void i_click_sub_button() {
		driver.findElement(By.xpath("//input[@name='sub']"));
	}
}
