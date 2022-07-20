package com.web.automation.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtills {

	protected void WaitUntilElementVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean sendTextToTextFiled(WebElement element, String input, WebDriver driver) throws Throwable {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			ScrollToElementVisible(element, driver);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();

			element.sendKeys(input);
			status = true;

		} catch (Exception e) {
			status = false;

		}
		return status;
	}

	public void mouseClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);

		action.moveToElement(element).click().build().perform();
	}

	/***
	 * 
	 * @param element
	 * @return
	 */
	public void ScrollToElementVisible(WebElement element, WebDriver driver) {

		JavascriptExecutor je = (JavascriptExecutor) driver;

		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void ScrollToElementMiddle(WebElement element, WebDriver driver) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,100)", "");

	}

	public void ScrollToBottom(WebDriver driver) {

		JavascriptExecutor je = (JavascriptExecutor) driver;

		je.executeScript("window.scrollBy(0,250)", "");
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByVisibleText(By locator, String value, String locatorName, WebDriver driver)
			throws Throwable {
		boolean flag = false;
		try {

			WebElement dropDownListBox = driver.findElement(locator);
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText(value);
			flag = true;
		} catch (Exception e) {

			flag = false;
		} finally {
			if (flag == false) {

			} else if (flag == true) {

			}
		}
		return flag;
	}

	/**
	 * 
	 * @param by
	 * @param waitTime
	 */
	public void WaitForElementInVisible(WebElement element, int waitTime, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			// extentLogs.pass("Element InVisible", "Element Invisibile at '" +
			// driver.getTitle() + "' page.");
		} catch (TimeoutException e) {

		}
	}

	/**
	 * 
	 * @param by
	 * @param waitTime
	 */
	public void waitForElementVisible(WebElement element, int waitTime, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			// extentLogs.pass("Element InVisible", "Element Invisibile at '" +
			// driver.getTitle() + "' page.");
		} catch (TimeoutException e) {

		}
	}

	/**
	 * 
	 * @param element
	 * @param driver
	 */

	public static void clickonElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	/***
	 * 
	 * @param pathElements
	 * @param driver
	 */

	public void mutipleCheckbox(String pathElements, WebDriver driver) {

		List<WebElement> allCheckboxes = driver.findElements(By.xpath(pathElements));

		int size = allCheckboxes.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {

			allCheckboxes.get(i).click();

		}
	}

	/**
	 * 
	 * @param driver
	 */

	public void verifyPageload(WebDriver driver) {

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	/**
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */

	public String getText(WebElement element, WebDriver driver) {
		waitForElementVisible(element, 30, driver);
		String text = element.getText();

		return text;
	}

	public boolean getFromList(String productname, By locator, WebDriver driver) {
		List<WebElement> items = driver.findElements(locator);
		for (WebElement webElement : items) {
			String fetchedtext = webElement.getText();
			if (fetchedtext.contains(productname)) {
				return true;
			}
		}
		return false;
	}

	public List<String> getFromList(List<WebElement> elements, WebDriver driver) {
		List<String> resultList = new ArrayList();
		for (WebElement webElement : elements) {
			resultList.add(webElement.getText().trim());

		}

		return resultList;
	}

}
