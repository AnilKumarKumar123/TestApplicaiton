package com.web.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {
	private static WebDriverWait wait;
	public static WebDriver driver;
	RemoteWebDriver driver2;
	
	public static PropertiesReader propertiesReader = null;;

	public static WebDriver lunchApplication() throws Exception {
		propertiesReader = new PropertiesReader();
		String browserName = propertiesReader.getProperty("browserName");
		String driverName = propertiesReader.getProperty("driverName");
		String url = propertiesReader.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "Drivers//" + driverName);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			/* options.addArguments("incognito"); */
			/* options.addArguments("headless"); */
			options.addArguments("disable-popup-blocking");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "Drivers//" + driverName);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);

		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "Drivers//" + driverName);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);

		}
		return driver;

	}
//		propertiesReader = new PropertiesReader();
//		String browserName = propertiesReader.getProperty("browserName");
//		String driverName = propertiesReader.getProperty("driverName");
//		System.out.println("browserName*** " + browserName);
//		String url = propertiesReader.getProperty("url");
//		System.out.println("The browser is :" + browserName + ", The driver is: " + driverName);
//		System.out.println(System.getProperty("user.dir") + "//Drivers//" + driverName);
//		if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//" + driverName);
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(url);
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		} else if (browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + "/src/main/resources/drivers/" + driverName);
//			driver = new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get(url);
//		}else if(browserName.equals("IE"))
//		{
//			
//		}
//		return driver;
//
//	}

}
