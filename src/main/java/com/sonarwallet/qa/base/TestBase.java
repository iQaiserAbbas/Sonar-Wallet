package com.sonarwallet.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v106.headlessexperimental.HeadlessExperimental;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sonarwallet.qa.utils.TestUtils;
import com.sonarwallet.qa.utils.WebEventListener;

import bsh.This;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		// this function is to read properties from config file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\XORD\\TestingApps\\01-SonarWallet\\SonarWallet-Automation\\sonar-wallet-automation\\src\\main\\java\\com\\sonarwallet\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();

//	        options.setExperimentalOption("debuggerAddress", "127.0.0.1:<customPort>");

//	        WebDriver driver = new ChromeDriver(options);
//	        This line is for Headless mode 
//			options.addArguments("--headless=chrome");

// origial	        https://sonar-wallet.web.app/index.html

			// added the below line because was facing error: Unable to establish websocket connection
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("FF")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}

		e_driver = new EventFiringWebDriver(driver);
//		object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));

		// getting the Application under test URL from the property file
		driver.get(prop.getProperty("url"));

		// handle basic auth - only password field alert
		driver.switchTo().alert().sendKeys(prop.getProperty("auth_password"));
		driver.switchTo().alert().accept();

	}
}
