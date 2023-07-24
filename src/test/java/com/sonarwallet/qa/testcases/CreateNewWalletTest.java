package com.sonarwallet.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.CreateNewWallet;
import com.sonarwallet.qa.pages.ImportWallet;
import com.sonarwallet.qa.pages.SettingsPage;

public class CreateNewWalletTest extends TestBase {

	ImportWallet importWallet;
	SettingsPage settingsPage;
	CreateNewWallet createNewWallet;

	public CreateNewWalletTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		// testUtils = new TestUtils();
		createNewWallet = new CreateNewWallet();
		importWallet = new ImportWallet();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
		settingsPage = importWallet.ImportWalletToSetting(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
		Thread.sleep(5000);
		settingsPage.AllWalletdropdown();
		settingsPage.NetworkSwitchButton();
		createNewWallet = settingsPage.ClickOnCreateNewWallet();
	}

	@Test(priority = 1)
	public void CreateNewWalletHappyFlow() throws InterruptedException {

		createNewWallet.ClickOnTapToRevealButton();
		createNewWallet.getseedphraselist();
		createNewWallet.ClickOnNextButton();
		createNewWallet.ClickOnOkButton();
		createNewWallet.ClickOnAllWalletDropdown();
		WebElement ele = driver.findElement(By.xpath("//div[ contains (text(),'New Wallet')]"));
		Assert.assertTrue(ele.isDisplayed());
	}

	@Test(priority = 1, description = ("Test Case Description: Create new Wallet in Setting"))

	public void TestCase38() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createNewWallet.ClickOnTapToRevealButton();
		createNewWallet.getseedphraselist();
		createNewWallet.ClickOnNextButton();
		createNewWallet.ClearNameField();
		createNewWallet.EnterNameField("My Wallet");
		createNewWallet.ClickOnOkButton();
		createNewWallet.ClickOnAllWalletDropdown();
		WebElement ele = driver.findElement(By.xpath("//div[ contains (text(),'My Wallet')]"));
		Assert.assertTrue(ele.isDisplayed());
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
