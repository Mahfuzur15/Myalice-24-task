package ai.myalice.app.page;

import org.openqa.selenium.By;
import ai.myalice.app.utilities.CommonMethods;


public class MangaHomePage extends CommonMethods {

	By searchField = By.xpath("//input[@id='manga-search']");

	By searchBtn = By.xpath("//button[normalize-space()='Search']");
	By mangaCardName = By.xpath("//*[@id=\"manga-name\"]");

	By notFoundText = By.xpath("//p[@class='text-red-500']");

	By detailsBtn = By.xpath("//*[@id=\"root\"]/div/div[2]/div[4]/p[1]/span");

	By mangaImage = By.xpath("//div//div[3]//img[@alt='Attack on Titan']");
	By mangaName = By
			.xpath("//div[@class='bg-white p-6 rounded-lg shadow-lg w-96']//h3[@class='text-xl font-bold mb-2']");
	By mangaSummary = By.xpath("//p[@class='text-gray-600 mb-4']");

	By closeBtn = By.xpath("//button[normalize-space()='Close']");

	By modalElement = By.xpath("//*[@id=\"root\"]/div/div[3]/div");

	public void clickMangaSearchResultsWithValidkeyword(String searchWord) throws InterruptedException {

		sendText(searchField, searchWord);

		clickButton(searchBtn);
	}

	public boolean mangaCardNameMatch() {

		try {

			System.out.println(isElementDisplayed(mangaCardName));
			return isElementDisplayed(mangaCardName);
		}

		catch (Exception e) {
			System.out.println("this keyword can not found: " + getAttribute(searchField, "value"));
			return false;
		}

	}

	public void clickMangaSearchResultsWithInvalidkeyword(String searchWord) {

		sendText(searchField, searchWord);

		clickButton(searchBtn);

	}

	public String mangaNoDataFound() {

		return getText(notFoundText);

	}

	public void clickMangaCardDetails() {

		clickButton(detailsBtn);

	}

	public boolean mangaImageMatch() {

		try {

			// Verify the image alternate way
			System.out.println("Is Image Displayed: " + isElementDisplayed(mangaImage));
			// Verify the image source (URL)
//			getAttribute(mangaImage, "src");
//			System.out.println("Image URL: " + getAttribute(mangaImage, "src"));
			// Check if the modal is not displayed
//			isElementDisplayed(modalElement);
//			System.out.println(isElementDisplayed(modalElement));

			return isElementDisplayed(mangaImage);
		}

		catch (Exception e) {
			System.out.println("this image not found");
			return false;
		}

	}

	public String mangaNameMatch() {

		try {

			return getText(mangaName);
		}

		catch (Exception e) {

			return "Can not found any Card name";
		}

	}

	public String mangaSummaryMatch() {

		try {

			return getText(mangaSummary);
		}

		catch (Exception e) {

			return "Can not found any Card Summary";
		}

	}

	public void modalClose() {

		clickButton(closeBtn);

	}

	public boolean mangaModalVisibility() {

		try {

			return isElementDisplayed(modalElement);
		}

		catch (Exception e) {
			System.out.println("Modal is visible");
			return false;
		}

	}

}