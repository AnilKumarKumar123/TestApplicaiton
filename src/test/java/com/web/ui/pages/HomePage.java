package com.web.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.web.automation.utilities.WebUtills;

import freemarker.template.utility.NullArgumentException;

public class HomePage {

	@FindBy(how = How.ID, using = "searchInput")
	WebElement txt_searchInput;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'There were no results matching the query')]")
	WebElement txt_ErrorMessage;

	@FindBy(how = How.XPATH, using = "//button[@class='pure-button pure-button-primary-progressive']")
	WebElement btn_Submit;
	
	@FindBy(how = How.XPATH, using = "//a")
	WebElement wiki_Result_Links;

	WebDriver driver = null;
	WebUtills webUtills = new WebUtills();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSerachBox(String wikiLink) throws Throwable {

		webUtills.sendTextToTextFiled(txt_searchInput, wikiLink, driver);
		Thread.sleep(1000);

	}

	public boolean verifyElementNotValid() throws Throwable {
		boolean validation = txt_ErrorMessage.isDisplayed();
		if (validation) {

			throw new NullArgumentException("invalid input");

		}

		return validation;

	}

	public void clickOnSubmitButton() throws Throwable {

		webUtills.clickonElement(btn_Submit, driver);
		// webUtills.mouseClick(btn_Submit, driver);
	}
	
	public List<String> getWikiLinks(int n) throws Throwable {
		int i=0;
		if(n<1 || n>20) {
			System.out.println("Invalid input please enter from 1 to 20");
			System.exit(0);
		}
		List<String> links_List=new ArrayList<String>();
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		for (WebElement webElement : links) {
			i++;
			links_List.add(webElement.getText().trim());
			System.out.println(webElement.getText().trim());
			if(i==n)
				break;
			
			
		}
		return links_List;

		
	}

}
