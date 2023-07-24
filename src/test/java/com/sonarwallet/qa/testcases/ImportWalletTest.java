package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.ImportWallet;

public class ImportWalletTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;

	public ImportWalletTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		importWallet = new ImportWallet();
		// Handling Alert
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Import Wallet with Wrong seed phrase"))
	public void TestCase6() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(2000);
		importWallet.IWEnterPwd(prop.getProperty("Password"));
		importWallet.IWconfirmPwd(prop.getProperty("ConfirmPassword"));
		importWallet.IWOkletsGoButton();
		importWallet.IWImportWalletGoButton();
		importWallet.IWPasteSeedPhrase(prop.getProperty("wrongseedphrase"));
		softassert.assertFalse(importWallet.verifyImportSeedPhraseButton(), "Import wallet Button is enable");
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Import Wallet"))
	public void TestCase5() throws InterruptedException {

		dashboard = importWallet.ImportWalletToDashboard(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
