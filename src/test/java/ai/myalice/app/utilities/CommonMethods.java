package ai.myalice.app.utilities;

import org.openqa.selenium.By;
import ai.myalice.app.driver.BaseDriver;

public class CommonMethods extends BaseDriver {

	public String getAttribute(By element, String attributeName) {
		return driver.findElement(element).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(By element) {
		return driver.findElement(element).isDisplayed();
	}

	public String getText(By element) {
		return driver.findElement(element).getText();
	}

	public void sendText(By element, String value) {

		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(value);

	}

	public void clickButton(By element) {

		driver.findElement(element).click();
	}

	// Assertion Error Message Check
	public String getMessage(By message) {
		String textMessage = driver.findElement(message).getText();
		System.out.println(message);
		return textMessage;
	}

	public void pause(int value) throws InterruptedException {

		Thread.sleep(value);
	}

}
