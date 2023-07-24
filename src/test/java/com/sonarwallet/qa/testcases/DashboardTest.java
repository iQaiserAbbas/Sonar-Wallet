package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.ImportWallet;

public class DashboardTest extends TestBase {
	ImportWallet importWallet;
	Dashboard dashboard;
//	TestUtil testUtil;

	public DashboardTest() {
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
		importWallet = new ImportWallet();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
		dashboard = importWallet.ImportWalletToDashboard(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
//		dashboard.AllWalletdropdown();
//		dashboard.NetworkSwitchButton();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Dashboard Header items"))
	public void TestCase09() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(dashboard.verifySettigButton(), "Setting icon is not visible");
		softassert.assertTrue(dashboard.verifyWalletFilter(), "Wallet Fileter dropdown is not visible");
		softassert.assertTrue(dashboard.verifyWalletFilter(), "Wallet Fileter dropdown is not visible");
		softassert.assertTrue(dashboard.verifyAsset(), "Assets are not visible");
		softassert.assertEquals(dashboard.TotalDollarAsset(), "0 USD");

		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Dashboard View"))
	public void TestCase10() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(dashboard.verifySendButton(), "Send button is not visible");
		softassert.assertTrue(dashboard.verifyReceiveButton(), "Recieve button is not visible");
		softassert.assertTrue(dashboard.verifySwapButton(), "Swap button is not visible");
		softassert.assertTrue(dashboard.verifyTokenTab(), "Token Tab is not visible");
		softassert.assertTrue(dashboard.verifyNFTsTab(), "NFTs Tab is not visible");
		softassert.assertTrue(dashboard.verifyActivityTab(), "Activity is not visible");
		softassert.assertTrue(dashboard.verifyEditTokenButton(), "Edit Token button is not visible");
		dashboard.BinanceChainExpand();
		dashboard.EtheriumChainExpand();
		dashboard.PolygonChainExpand();
		dashboard.NearChainExpand();
		dashboard.ArouraChainExpand();
		dashboard.AvalancheChainExpand();
		dashboard.CronosChainExpand();
		dashboard.FantomChainExpand();
		dashboard.SolanaChainExpand();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Send Transaction Of BNB non Native Token"))

	public void TestCase26() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(dashboard.verifyWalletFilter(), "Wallet Fileter dropdown is not visible");
		dashboard.AllWalletdropdown();
		softassert.assertEquals("Switch to TestNets", dashboard.VerifyNetworkButton());
		dashboard.NetworkSwitchButton();
		dashboard.AllWalletdropdown();
		WebElement AllWallet = driver.findElement(By.xpath("//div[ contains (text(),'All Wallets')]"));
		softassert.assertTrue(AllWallet.isDisplayed(), "All Wallet Heading is not visible");
		WebElement Wallet1 = driver.findElement(By.xpath("//div[ contains (text(),'Wallet 1')]"));
		softassert.assertTrue(Wallet1.isDisplayed(), "Wallet Heading is not visible");
		softassert.assertEquals("Back to MainNet", dashboard.VerifyNetworkButton());
		softassert.assertFalse(dashboard.verifyResetButton(), "Reset button is enable");
		dashboard.UncheckedWalletone();
		softassert.assertTrue(dashboard.verifyResetButton(), "Reset button is disable");
		dashboard.ClickOnResetButton();
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
