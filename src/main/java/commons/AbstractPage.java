package commons;

import java.util.List;
//import java.util.Set;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.AbstractPageUI;
import pages.DeleteCustomerPagePO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewAccountPagePO;
import pages.NewCustomerPagePO;

public class AbstractPage {

	// WebBrower
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTile(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	// WebElement
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Click to dynamic element= " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeysToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void sendkeysToElement(WebDriver driver, String locator, String value, String value1) {
		locator = String.format(locator, value1);
		System.out.println("Sendkeys to dynamic element " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectByValue(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
		
	}
	public void selectByIndex(WebDriver driver, String locator, int index) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByIndex(index);

	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSize(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkCheckbox(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Check to dynamic element " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}
	public void unCheckCheckbox(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("UnCheck to dynamic element " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean controlDisplay(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean controlDisplay(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Control is displayed " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean controlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean controlEnable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendkeysToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		return value = alert.getText();
	}

//	public void alert(WebDriver driver, String type, String value) {
//		Alert alert = driver.switchTo().alert();
//		if (type == "accept") {
//			alert.accept();
//		}
//		if (type == "dismiss") {
//			alert.dismiss();
//		}
//		if (type == "sendkeys") {
//			alert.sendKeys(value);
//		}
//	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);

	}

	public void switchWindowsByID(WebDriver driver, String locator) {
		String parentID = driver.getWindowHandle();
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		switchToChildWindow(driver, parentID);
	}

	public void switchToChildWindow(WebDriver driver, String parent) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchWindowsByTitle(WebDriver driver, String locator, String title) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		switchToWindowByTitle(driver, title);
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver);
		builder.doubleClick(element).perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver).contextClick(element);
		builder.build().perform();
	}

	public void dragAndDrop(WebDriver driver, String locator) {
		WebElement dragFrom = driver.findElement(By.xpath(locator));
		WebElement target = driver.findElement(By.xpath(locator));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

	public void keyPress() {
		//
	}

	public void upload(WebDriver driver, String filePath, String locator) {
		driver.findElement(By.xpath(locator)).sendKeys(filePath);
		driver.findElement(By.xpath(locator)).click();
	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickWebElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public Object scrollToElement(WebDriver driver) {
		WebElement element = driver.findElement(By.id("id_of_element"));
		return ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Object removeAttributeInDOM(WebDriver driver, WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Wait for dynamic control visible " + locator);
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

//	public boolean checkAnyImageLoaded(WebDriver driver, WebElement image) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		return (boolean) jsExecutor.executeScript("return arguments[0].complete"
//				+ "&& typeof arguments[0].naturalWidth != 'undefined'" + "&& arguments[0].naturalWidth > 0;");
//	}

	// Open Dynamic
	public HomePagePO openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManger.getHomePage(driver);
	}

	public NewCustomerPagePO openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManger.getNewCustomerPage(driver);
	}

	public EditCustomerPagePO openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManger.getEditCustomerPage(driver);
	}

	public DeleteCustomerPagePO openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		return PageFactoryManger.getDeleteCustomerPage(driver);
	}

	public LoginPagePO openLogOutPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		acceptAlert(driver);
		waitForControlVisible(driver, AbstractPageUI.LOGIN_FORM_LINK);
		return PageFactoryManger.getLoginPage(driver);
	}
	public NewAccountPagePO openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		return PageFactoryManger.getNewAccountPage(driver);
	}

}
