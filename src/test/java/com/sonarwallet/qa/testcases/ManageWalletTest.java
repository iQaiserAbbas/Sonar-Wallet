package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.ImportWallet;
import com.sonarwallet.qa.pages.ManageWallet;
import com.sonarwallet.qa.pages.SettingsPage;

public class ManageWalletTest extends TestBase {

	ImportWallet importWallet;
	SettingsPage settingsPage;
	ManageWallet managewallet;

	public ManageWalletTest() {
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
		managewallet = new ManageWallet();
		importWallet = new ImportWallet();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
		settingsPage = importWallet.ImportWalletToSetting(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
		Thread.sleep(1000);
		settingsPage.AllWalletdropdown();
		settingsPage.NetworkSwitchButton();
		managewallet = settingsPage.clickOnManageWallet();
	}

	@Test(priority = 1, description = ("Test Case Description: Verify the working of Manage Wallet in Setting"))

	public void TestCase28() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickonPencilIcon();
		Thread.sleep(1000);
		managewallet.ClearChangeField();
		Thread.sleep(1000);
		managewallet.ChangeWalletName("My Wallet");
		managewallet.ClickOnOkbutton();
		managewallet.ClickOnBackbutton();
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Update wallet name"))

	public void TestCase29() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickonPencilIcon();
		managewallet.ClearChangeField();
		managewallet.ChangeWalletName("Wallet Test Maxi");
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'Wallet Name too long')]")).getText();
		softassert.assertEquals("Wallet Name too long", error_msg);
		managewallet.ClearChangeField();
		String error_msg1 = driver.findElement(By.xpath("//div[ contains (text(),'invalid Wallet Name')]")).getText();
		softassert.assertEquals("invalid Wallet Name", error_msg1);
		managewallet.ChangeWalletName("My Wallet");
		managewallet.ClickOnOkbutton();
		managewallet.ClickOnBackbutton();
		String wallet = driver.findElement(By.id("ListItem-My Wallet")).getText();
		softassert.assertEquals("My Wallet", wallet);
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Reveal wallet secret phrase"))

	public void TestCase30() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickOnRevealSeedPhraseMainbutton();
		managewallet.ClickOnConfirmButton();
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'invalid password')]")).getText();
		softassert.assertEquals("invalid password", error_msg);
		managewallet.EnterPasswordSeedPhraseField("13213123");
		managewallet.ClickOnConfirmButton();
		String error_msg1 = driver.findElement(By.xpath("//div[ contains (text(),'invalid password')]")).getText();
		softassert.assertEquals("invalid password", error_msg1);
		managewallet.ClearPasswordSeedPhraseField();
		managewallet.EnterPasswordSeedPhraseField(prop.getProperty("Password"));
		managewallet.ClickOnConfirmButton();
		managewallet.ClickOnTapToRevealButton();
		softassert.assertTrue(managewallet.verifySeedPhraseCopyButton(), "Copy button is not visible");
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Accounts Details - Manage wallet"))

	public void TestCase31() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickonEVMAccountButton();
		managewallet.ClickonEditAccountNameButton();
		managewallet.ClearAccountNameField();
		managewallet.EditAccountNameField("EVM Account");
		managewallet.ClickOnOkbutton();
		managewallet.ClickonCopyAddressButton();
		boolean Copied = driver.findElement(By.xpath("//div[ contains (text(),'Copied')]")) != null;
		softassert.assertTrue(Copied);
		softassert.assertTrue(managewallet.verifyRevealPrivateKeyButton(), "Reveal PrivateKey button is not visible");
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Update account name in setting"))

	public void TestCase32() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickonEVMAccountButton();
		managewallet.ClickonEditAccountNameButton();
		managewallet.ClearAccountNameField();
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'invalid Account Name')]")).getText();
		softassert.assertEquals("invalid Account Name", error_msg);
		managewallet.EditAccountNameField("My EVM Account 1");
		String error_msg1 = driver.findElement(By.xpath("//div[ contains (text(),'Account Name too long')]")).getText();
		softassert.assertEquals("Account Name too long", error_msg1);
		managewallet.ClearAccountNameField();
		managewallet.EditAccountNameField("EVM Account");
		managewallet.ClickOnOkbutton();
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Reveal Accounts Private Key"))

	public void TestCase33() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickonEVMAccountButton();
		managewallet.ClickonRevealPrivateKeyButton();
		Thread.sleep(1000);
		managewallet.ClickOnConfirmButton();
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'invalid password')]")).getText();
		softassert.assertEquals("invalid password", error_msg);
		managewallet.RevealPrivateKeyPasswordField("WrongPassword");
		managewallet.ClickOnConfirmButton();
		String error_msg1 = driver.findElement(By.xpath("//div[ contains (text(),'invalid password')]")).getText();
		softassert.assertEquals("invalid password", error_msg1);
		managewallet.ClearPasswordForRevealPrivateKeyField();
		managewallet.RevealPrivateKeyPasswordField(prop.getProperty("Password"));
		managewallet.ClickOnConfirmButton();
		managewallet.ClickOnTapToRevealButton();
		String privateKey = driver.findElement(By.id("secretViewComponent-secretbox")).getText();
		softassert.assertEquals(prop.getProperty("EVM_PrivateKey"), privateKey);
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Verify the working of Import an Account in Setting"))

	public void TestCase34() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickOnImportAccountMainbutton();
		managewallet.ClickOnImportbutton();
		driver.findElement(By.xpath("//div[ contains (text(),'Please enter a key')]")).isDisplayed();
		Thread.sleep(5000);
		managewallet.EnterPrivateKeyinImportAccountField(prop.getProperty("PrivateKey"));
		managewallet.ClickOnImportbutton();
		managewallet.ClearAccountNameField();
		managewallet.EditAccountNameField("Acc_imp");
		managewallet.ClickOnOkbutton();
		driver.findElement(By.xpath("//*[ contains (text(),'Ok')]")).click();
		managewallet.GotoManageWallet();
		managewallet.ClickonWallet1();
		WebElement ele = driver.findElement(By.xpath("//div[ contains (text(),'Acc_imp')]"));
		Assert.assertTrue(ele.isDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Import Account in Setting"))

	public void TestCase35() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickOnImportAccountMainbutton();
		managewallet.ClickOnImportbutton();
		driver.findElement(By.xpath("//div[ contains (text(),'Please enter a key')]")).isDisplayed();
		Thread.sleep(5000);
		managewallet.EnterPrivateKeyinImportAccountField(prop.getProperty("PrivateKey"));
		managewallet.ClickOnImportbutton();
		managewallet.ClearAccountNameField();
		managewallet.EditAccountNameField("Acc_imp");
		managewallet.ClickOnOkbutton();
		driver.findElement(By.xpath("//*[ contains (text(),'Ok')]")).click();
		managewallet.GotoManageWallet();
		managewallet.ClickonWallet1();
		managewallet.ClickOnImportAccountMainbutton();
		managewallet.EnterPrivateKeyinImportAccountField(prop.getProperty("PrivateKey"));
		managewallet.ClickOnImportbutton();
		managewallet.ClickOnOkbutton();
		managewallet.ClickOnCancelButton();
		driver.findElement(By.xpath("//div[ contains (text(),'account already exits')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Create New Account Functionality"))

	public void TestCase36() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickonWallet1();
		managewallet.ClickOnCreateNewEVMAccountButton();
		managewallet.ClearCreateNewAccountNameField();
		managewallet.CreateNewAccountNameField("MY EVM");
		managewallet.ClickOnOkbutton();
		WebElement ele1 = driver.findElement(By.xpath("//div[ contains (text(),'MY EVM')]"));
		Assert.assertTrue(ele1.isDisplayed());
		managewallet.ClickOnCreateNewSolanaAccountButton();
		managewallet.ClickOnCreateDerivativePath0Button();
		managewallet.ClearCreateNewAccountNameField();
		managewallet.CreateNewAccountNameField("SolanaD0");
		managewallet.ClickOnOkbutton();
		WebElement ele2 = driver.findElement(By.xpath("//div[ contains (text(),'SolanaD0')]"));
		Assert.assertTrue(ele2.isDisplayed());
		managewallet.ClickOnCreateNewSolanaAccountButton();
		managewallet.ClickOnCreateDerivativePath1Button();
		managewallet.ClearCreateNewAccountNameField();
		managewallet.CreateNewAccountNameField("SolanaD1");
		managewallet.ClickOnOkbutton();
		WebElement ele3 = driver.findElement(By.xpath("//div[ contains (text(),'SolanaD1')]"));
		Assert.assertTrue(ele3.isDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Import Wallet in Setting"))

	public void TestCase37() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(managewallet.verifyWallet_1Button(), "Wallet1 button is not visible");
		managewallet.ClickOnBackbutton();
		managewallet.ClickOnImportWalletMainButton();
		managewallet.ClickOnFindMyWalletButton();
		String error_msg = driver
				.findElement(By.xpath("//div[ contains (text(),'This does not seem to be a valid seedphrase')]"))
				.getText();
		softassert.assertEquals("This does not seem to be a valid seedphrase", error_msg);
		managewallet.EnterImportWalledSeedPhraseField(
				"Wrong seed phrase word twelve word seed phrase please try again later");
		managewallet.ClickOnTryAgainButton();
		managewallet.ClearImportWalletSeedPhraseField();
		managewallet.EnterImportWalledSeedPhraseField(prop.getProperty("SeedphraseWallet2"));
		managewallet.ClickOnFindMyWalletButton();
		managewallet.ClickOnImportbutton();
		managewallet.ClickOnOkbutton();
		driver.findElement(By.xpath("//*[ contains (text(),'Ok')]")).click();
		managewallet.AllWalletdropdown();
		driver.findElement(By.xpath("//*[ contains (text(),'New Wallet')]")).isDisplayed();
		
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
