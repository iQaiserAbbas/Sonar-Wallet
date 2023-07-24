package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.EditTokenPage;
import com.sonarwallet.qa.pages.ImportWallet;

public class EditTokenTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;
//	TestUtil testUtil;
	EditTokenPage edittokenPage;

	public EditTokenTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		initialization();
		// testUtils = new TestUtils();
		edittokenPage = new EditTokenPage();
		importWallet = new ImportWallet();
		dashboard = new Dashboard();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
		dashboard = importWallet.ImportWalletToDashboard(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
		Thread.sleep(5000);
		dashboard.AllWalletdropdown();
		dashboard.NetworkSwitchButton();
		Thread.sleep(5000);
		edittokenPage = dashboard.clickOnEditTokenButton();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Edit Token List"))
	public void TestCase16() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(15000);
		edittokenPage.VerifyAllTokens();
		Thread.sleep(10000);
		softassert.assertTrue(edittokenPage.VerifySearchField(), "search field is not visible");
		edittokenPage.EnableAllNonNativeTokens();
		String Inactive_msg = driver.findElement(By.xpath("//div[ contains (text(),'no inactive token')]")).getText();
		softassert.assertEquals("no inactive token", Inactive_msg);
		Thread.sleep(10000);
		edittokenPage.EnterValueinSearchField("dummy");
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'Nothing found')]")).getText();
		softassert.assertEquals("Nothing found", error_msg);
		Thread.sleep(10000);
		edittokenPage.ClickonCrossButton();
		Thread.sleep(10000);
		edittokenPage.EnterValueinSearchField("usdc");
		String Tokensearch = driver.findElement(By.xpath("//div[ contains (text(),'USD Coin')]")).getText();
		softassert.assertEquals("USD Coin", Tokensearch);
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Add Custom ETH Token"))
	public void TestCase17_with_eth() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(15000);
		softassert.assertTrue(edittokenPage.VerifyAddCustomButton(), "Add token button is not visible");
		edittokenPage.ClickonAddCustomButton();
		edittokenPage.SelectEthChainToAddToken();
		softassert.assertTrue(edittokenPage.VerifyTokenAddresField(), "Add token address field is not visible");
		edittokenPage.EnterTokenAddressField("27498237497923");
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'invalid address')]")).getText();
		softassert.assertEquals("invalid address", error_msg);
		edittokenPage.ClickonCrossForAddressButton();
		edittokenPage.EnterTokenAddressField("0xA108830A23A9a054FfF4470a8e6292da0886A4D4");
		edittokenPage.ClickOnAddToListButton();
		Thread.sleep(15000);
		edittokenPage.ClickonAddCustomButton();
		edittokenPage.SelectEthChainToAddToken();
		edittokenPage.EnterTokenAddressField("0xA108830A23A9a054FfF4470a8e6292da0886A4D4");
		String error_msg2 = driver.findElement(By.xpath("//div[ contains (text(),'Token already exists')]")).getText();
		softassert.assertEquals("Token already exists", error_msg2);
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Add Custom BnB Token"))
	public void TestCase17_with_BnB() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(15000);
		softassert.assertTrue(edittokenPage.VerifyAddCustomButton(), "Add token button is not visible");
		edittokenPage.ClickonAddCustomButton();
		edittokenPage.SelectBNBChainToAddToken();
		softassert.assertTrue(edittokenPage.VerifyTokenAddresField(), "Add token address field is not visible");
		edittokenPage.EnterTokenAddressField("27498237497923");
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'invalid address')]")).getText();
		softassert.assertEquals("invalid address", error_msg);
		edittokenPage.ClickonCrossForAddressButton();
		edittokenPage.EnterTokenAddressField("0x52459834ca561cb55411699e9c2143683bcf865f");
		edittokenPage.ClickOnAddToListButton();
		Thread.sleep(15000);
		edittokenPage.ClickonAddCustomButton();
		edittokenPage.SelectBNBChainToAddToken();
		edittokenPage.EnterTokenAddressField("0x52459834ca561cb55411699e9c2143683bcf865f");
		String error_msg2 = driver.findElement(By.xpath("//div[ contains (text(),'Token already exists')]")).getText();
		softassert.assertEquals("Token already exists", error_msg2);
		softassert.assertAll();
	}

	// rest network is pending to do
	// Cronos Chain
	// Fantom
	// Avalanche
	// Polygon
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
