package ai.myalice.app.page;

import org.openqa.selenium.By;

import ai.myalice.app.utilities.CommonMethods;

public class SignInPage extends CommonMethods {

	// Locator for username field
	By uName = By.xpath("//input[@id='username']");

	// Locator for password field
	By pswd = By.xpath("//input[@id='password']");

	By loginBtn = By.xpath("//button[@id='login-btn']");

	By loginDisplayed = By.xpath("//*[@id=\"root\"]/div/div");

	By searchField = By.xpath("//input[@id='manga-search']");

	// Method valid Login
	public void clickLoginWithValidCredentials(String email, String password) throws InterruptedException {

		sendText(uName, email);

		sendText(pswd, password);
		clickButton(loginBtn);

	}

//	public void clickLoginWithValidUserInvalidPassword(String email, String password) {
//
//		sendText(uName, email);
//		sendText(pswd, password);
//		clickButton(loginBtn);
//
//	}

	public boolean loginPageExist() {

		System.out.println(isElementDisplayed(loginDisplayed));
		return isElementDisplayed(loginDisplayed);

	}

	public boolean searchPageExist() {

		System.out.println(isElementDisplayed(searchField));
		return isElementDisplayed(searchField);

	}

}