package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.ImportWallet;
import com.sonarwallet.qa.pages.SettingPage;

public class SettingTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;
//	TestUtil testUtil;
	SettingPage settingPage;

	public SettingTest() {
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
		settingPage = new SettingPage();
		importWallet = new ImportWallet();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
		dashboard = importWallet.ImportWalletToDashboard(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
		Thread.sleep(1000);
//		dashboard.AllWalletdropdown();
//		dashboard.NetworkSwitchButton();
		settingPage = dashboard.clickOnSettingPage();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description:Verify the items on Setting Screen View"))

	public void TestCase27() {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(settingPage.verifyAccountAndWalletButton(), "Wallet and account button is not visible");
		softassert.assertTrue(settingPage.verifySecurityAndPrivacyButton(),
				"Security and privacy button is not visible");
		softassert.assertTrue(settingPage.verifyAddressBookButton(), "Address book button is not visible");
		softassert.assertTrue(settingPage.verifyHelpButton(), "Help button is not visible");
		softassert.assertTrue(settingPage.verifyBaseCurrencyButton(), "Base currency button is not visible");
		softassert.assertTrue(settingPage.verifyLanguageButton(), "Language button is not visible");
		softassert.assertTrue(settingPage.verifyThemeButton(), "Theme button is not visible");
		softassert.assertTrue(settingPage.verifyHideQuickAddTokenInMainListToggleButton(),
				"Hide Quick Add Token In MainList Toggle button is not visible");
		softassert.assertTrue(settingPage.verifyUseSonarAsDefaultWalletToggleButton(),
				"Use Sonar As Default Wallet Toggle button is not visible");
		softassert.assertTrue(settingPage.verifySwitchDappAccountButton(), "Switch Dapp Account button is not visible");
		softassert.assertTrue(settingPage.verifySwitchDappNetworkButton(), "Switch Dapp Network button is not visible");
		softassert.assertTrue(settingPage.verifyDisconnectWalletButton(), "Disconnect Wallet button is not visible");
		softassert.assertAll();
	}

//	@Test(priority=1)
//	public void ImportWalletTest(){
//		settingPage.ImportWalletFunctionHF();
//		
//	}
//	
//	@Test(priority=1)
//	public void RevealSeedPhraseTest(){
//		settingPage.ManageWalletRevealSecretPhraseHF("12345678");
//		
//	}
//	
//	@Test(priority=1)
//	public void CreateanAccountinWallet(){
//		settingPage.ManageWalletCreatenewAccountHF();
//		
//	}
//	
//	@Test(priority=1)
//	public void CreateNewWalletinWallet() throws InterruptedException{
//		settingPage.ManageWalletCreateWalletBeforeSeedphraseHF();
//		settingPage.getseedphraselist();
//		settingPage.ManageWalletCreateWalletAfterSeedPhraseHF();
//		settingPage.ClickOnAllWalletDropdown();
//		WebElement ele = driver.findElement(By.xpath("//div[ contains (text(),'New Wallet')]"));
//		Assert.assertTrue(ele.isDisplayed());
//	}
//	
//	@Test(priority=1)
//	public void ImportAccountHF() throws InterruptedException{
//		settingPage.ManageWalletImportAccount(prop.getProperty("PrivateKey"));
//	}
//	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
