package com.web.ui.testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.automation.utilities.BrowserFactory;
import com.web.ui.pages.HomePage;

public class HomePageTest {
	WebDriver driver = null;
	HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void initBrowser() throws Exception {
		driver = BrowserFactory.lunchApplication();
		homePage = new HomePage(driver);

	}

	@Test(priority = 1, enabled = false)
	public void verifySerachFunctionality() throws Throwable {
		homePage.enterSerachBox("google");
		homePage.clickOnSubmitButton();

	}

	@Test(priority = 2, enabled = false)
	public void verifyErrorMessage() throws Throwable {
		homePage.enterSerachBox("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		homePage.clickOnSubmitButton();
		assertEquals(false, homePage.verifyElementNotValid());

	}

	@Test(priority = 3, enabled = true)
	public void getAllWikiLinks() throws Throwable {
		homePage.enterSerachBox("google");
		homePage.clickOnSubmitButton();
		homePage.getWikiLinks(40);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
