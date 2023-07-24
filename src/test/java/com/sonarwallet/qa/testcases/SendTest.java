package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.ImportWallet;
import com.sonarwallet.qa.pages.SendPage;

public class SendTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;
//	TestUtil testUtil;
	SendPage sendPage;

	public SendTest() {
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
		sendPage = new SendPage();
		importWallet = new ImportWallet();
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
		Thread.sleep(15000);
		sendPage = dashboard.clickOnSendButton();
	}

	@Test(priority = 1, description = ("Test Case Description: Select token screen functionality for send"))
	public void TestCase18() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals("Search...", sendPage.VerifyPlaceHolder());
		sendPage.Expandgoerli();
		sendPage.EnterInSearchField("ethereum");
		Thread.sleep(2000);
		sendPage.Expandgoerli();
		Thread.sleep(2000);
		String eth_ele = driver.findElement(By.xpath("//div[ contains (text(),'ETH')]")).getText();
		softassert.assertEquals("ETH", eth_ele);
		sendPage.BackButton();
		softassert.assertNotEquals("0", sendPage.TotalDollarAsset());
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Select recipient/addres functionality for send"))
	public void TestCase19() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		sendPage.EnterInSearchField("ethereum");
		sendPage.ClickOnEthToken();
		softassert.assertEquals("Select Recipient...", sendPage.VerifyRecepientHeading());
		softassert.assertTrue(sendPage.Verifytransferbetweenaccountsbutton(), "search field is not visible");
		// invalidAddress
		sendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8ii");
		String error_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
		softassert.assertEquals("Invalid Account address", error_msg);
		sendPage.ClearAddressField();
		Thread.sleep(2000);
		sendPage.EnterAddressField("0x0000000000000000000000000000000000000000");
		softassert.assertEquals("Invalid Account address", error_msg);
		Thread.sleep(2000);
		sendPage.ClearAddressField();
		Thread.sleep(2000);
		sendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		sendPage.ClickOnAddressBookToggleButton();
		sendPage.ClickOnSendButton();
		sendPage.ClickOnSaveButton();
		String error_msg2 = driver.findElement(By.xpath("//div[ contains (text(),'The name cannot be empty!')]"))
				.getText();
		softassert.assertEquals("The name cannot be empty!", error_msg2);
		sendPage.EnterNameField("My wallet");
		sendPage.ClickOnSaveButton();
		Thread.sleep(2000);
		sendPage.BackButton();
		Thread.sleep(2000);
		sendPage.BackButton();
		Thread.sleep(2000);
		sendPage.ClickOnSendMainButton();
		Thread.sleep(2000);
		sendPage.ClickOnEthToken();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[ contains (text(),'My wallet')]")).isDisplayed();
//		String MyWallet = driver.findElement(By.id("SelectAddress-addressBook-0")).getText();
//		softassert.assertEquals("My wallet (0x...52A88)", MyWallet);
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Address book in Setting"))
	public void TestCase39() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		sendPage.EnterInSearchField("ethereum");
		Thread.sleep(2000);
		sendPage.ClickOnEthToken();
		sendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		sendPage.ClickOnAddressBookToggleButton();
		sendPage.ClickOnSendButton();
		sendPage.ClickOnSaveButton();
		sendPage.EnterNameField("My wallet");
		sendPage.ClickOnSaveButton();
		sendPage.BackButton();
		sendPage.BackButton();
		sendPage.ClickOnSettingButton();
		sendPage.ClickOnAddressBookButton();
		driver.findElement(By.xpath("//*[ contains (text(),'My wallet')]")).isDisplayed();
		sendPage.ClickOnAddressBookPencilIcon();
		sendPage.ClickOnCancelbutton();
		sendPage.ClickOnAddressBookDeleteIcon();
		driver.findElement(By.xpath("//*[ contains (text(),'Your address book is empty...')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, description = ("Test Case Description: Edit contact modal"))
	public void TestCase40() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		sendPage.EnterInSearchField("ethereum");
		sendPage.ClickOnEthToken();
		sendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		sendPage.ClickOnAddressBookToggleButton();
		sendPage.ClickOnSendButton();
		sendPage.ClickOnSaveButton();
		sendPage.EnterNameField("My wallet");
		sendPage.ClickOnSaveButton();
		sendPage.BackButton();
		sendPage.BackButton();
		sendPage.ClickOnSettingButton();
		sendPage.ClickOnAddressBookButton();
		driver.findElement(By.xpath("//*[ contains (text(),'My wallet')]")).isDisplayed();
		sendPage.ClickOnAddressBookPencilIcon();
		sendPage.ClearEditAddressField();
		sendPage.EditAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
		sendPage.ClickOnSaveEditButton();
		driver.findElement(By.xpath("//*[ contains (text(),'Invalid Address!')]")).isDisplayed();
		sendPage.ClearEditAddressField();
		sendPage.EditAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		sendPage.ClearNameField();
		sendPage.EnterNameField("My regular use of Wallet");
		sendPage.ClickOnSaveEditButton();
		driver.findElement(By.xpath("//*[ contains (text(),'Name too long!')]")).isDisplayed();
		sendPage.ClearNameField();
		sendPage.ClickOnSaveEditButton();
		driver.findElement(By.xpath("//*[ contains (text(),'The name cannot be empty!')]")).isDisplayed();
		sendPage.EnterNameField("Frequently Wallet");
		sendPage.EditNoteField("This wallet is use frequently by me");
		sendPage.ClickOnSaveEditButton();
		sendPage.ClickOnAddressBookPencilIcon();
		sendPage.ClearNoteField();
		sendPage.ClickOnSaveEditButton();
		driver.findElement(By.xpath("//*[ contains (text(),'Frequently Wallet')]")).isDisplayed();
		softassert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
