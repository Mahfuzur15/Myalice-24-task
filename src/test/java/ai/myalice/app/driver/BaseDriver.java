package ai.myalice.app.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {

	public static WebDriver driver;


	public static String loginPageUrl = "https://myalice-automation-test.netlify.app/";

	@BeforeSuite
	public WebDriver setup() throws Exception {

		String browser = "chrome";

		// Check if it is 'firefoxx'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox
			driver = new FirefoxDriver();

		}
		// Check if it is 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chrome

			driver = new ChromeDriver();

		}
		// Check if it is 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge
			driver = new EdgeDriver();

		} else {
			// If no browser is passed throw exception
			throw new Exception("Incorrect Browsere");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Starting Maximize Window
		driver.manage().window().maximize();
		driver.get(loginPageUrl);
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();

	}

}
