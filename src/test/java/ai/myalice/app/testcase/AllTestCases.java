package ai.myalice.app.testcase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ai.myalice.app.driver.BaseDriver;
import ai.myalice.app.page.MangaHomePage;
import ai.myalice.app.page.SignInPage;

public class AllTestCases extends BaseDriver {

	MangaHomePage homepage = new MangaHomePage();
	SignInPage signInpage = new SignInPage();

	// Every Test case are Independent

	@Test
	public void loginFunctionality() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(signInpage.loginPageExist());

		signInpage.clickLoginWithValidCredentials("testuser", "password");

		softAssert.assertTrue(signInpage.searchPageExist());

		softAssert.assertAll();
	}

	@Test
	public void mangaSearchAndDisplay() throws InterruptedException {

		// Got to Sign Page
		signInpage.clickLoginWithValidCredentials("testuser", "password");

		SoftAssert softAssert = new SoftAssert();

		// Got to Home Page
		homepage.clickMangaSearchResultsWithValidkeyword("Naruto");
		softAssert.assertTrue(homepage.mangaCardNameMatch());

		homepage.clickMangaSearchResultsWithValidkeyword("One Piece");
		softAssert.assertTrue(homepage.mangaCardNameMatch());

		homepage.clickMangaSearchResultsWithValidkeyword("Seven Deadly Sins");
		softAssert.assertTrue(homepage.mangaCardNameMatch());

		homepage.clickMangaSearchResultsWithInvalidkeyword("Afttacsd");
		softAssert.assertEquals(homepage.mangaNoDataFound(), "No manga found");

		softAssert.assertAll();
	}

	@Test
	public void mangaDetailsModal() throws InterruptedException {

		signInpage.clickLoginWithValidCredentials("testuser", "password");

		homepage.clickMangaCardDetails();

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(homepage.mangaImageMatch());

		softAssert.assertEquals(homepage.mangaNameMatch(), "Attack on Titan");

		softAssert.assertEquals(homepage.mangaSummaryMatch(),
				"Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.");

		homepage.modalClose();

		softAssert.assertFalse(homepage.mangaModalVisibility());

		softAssert.assertAll();
	}

}
