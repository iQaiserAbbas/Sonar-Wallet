package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.DirectSendPage;
import com.sonarwallet.qa.pages.ImportWallet;

public class DirectSendTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;
//	TestUtil testUtil;
	DirectSendPage directsendPage;

	public DirectSendTest() {
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
		directsendPage = new DirectSendPage();
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
		directsendPage = dashboard.clickOnDirectSendPage();
	}

	// For address driver.findElement(By.xpath(" //*[ contains (text(),'Invalid
	// Account address')]"));
	// For Null value driver.findElement(By.xpath(" //*[ contains (text(),'Please
	// enter amount')]"));
	// For Insuficiant ammount driver.findElement(By.xpath(" //*[ contains
	// (text(),'Insufficient funds available')]"));

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Token Detail View"))
	public void TestCase11() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.BinanceChainExpand();
		directsendPage.SelectBNBToken();
		softassert.assertTrue(directsendPage.VerifyInfoButton(), "Info Button is not vissible");
		softassert.assertTrue(directsendPage.VerifyNewsButton(), "News Button is not vissible");
		softassert.assertTrue(directsendPage.VerifyChartButton(), "Chart Button is not vissible");
		directsendPage.SwapButton();
		directsendPage.SendButton();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(BNB Native Token)"))
//	@Description("Test Case Description: Send Transaction Of BNB Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_1() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(40000);
		directsendPage.TransactionAtBNBNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(5000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtBNBNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(5000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(BNB Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of BNB non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_2() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(40000);
		directsendPage.BnbToggleButtonForNonNative();
		directsendPage.TransactionAtBNBNon_Native();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("1");
		Thread.sleep(9000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtBNBNon_Native();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(9000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(ETH Native Token)"))
//	@Description("Test Case Description: Send Transaction Of ETH Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_3() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(40000);
		directsendPage.TransactionAtEthNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("1000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(8000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtEthNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(8000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(ETH Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of ETH non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_4() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.EthToggleButtonForNonNative();
		Thread.sleep(10000);
		directsendPage.TransactionAtEthNonNative();
		Thread.sleep(10000);
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		Thread.sleep(10000);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		Thread.sleep(10000);
		directsendPage.SendTxButton();
		Thread.sleep(10000);
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		System.out.println("----->"+error_msg1);
		Assert.assertEquals("  Please enter amount", error_msg1);
		Thread.sleep(10000);
		directsendPage.EnterAmountField("99999999999999999");
		Thread.sleep(10000);
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		System.out.println("----->"+error_msg2);
		directsendPage.ClearEditField();
		Thread.sleep(10000);
		directsendPage.EnterAmountField("1");
		Thread.sleep(8000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		Thread.sleep(10000);
		directsendPage.TransactionAtEthNonNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(8000);
		directsendPage.clickOnClickAndHoldButton();
		Thread.sleep(8000);
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Polygon Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Polygon Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_5() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.TransactionAtPolygonNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		Thread.sleep(10000);
		directsendPage.EnterAmountField("1000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
//		Thread.sleep(10000);
//		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		Thread.sleep(2000);
		directsendPage.RejectButton();
		directsendPage.BackButton();
		Thread.sleep(10000);
		directsendPage.TransactionAtPolygonNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(8000);
		directsendPage.ClickOnEditButton();
		Thread.sleep(2000);
		directsendPage.ClickOnFastButton();
		Thread.sleep(2000);
		directsendPage.ClickOnSaveButton();
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Polygon Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Polygon non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_6() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.PolygonToggleButtonForNonNative();
		directsendPage.TransactionAtPolygonNon_Native();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("1");
		Thread.sleep(9000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtPolygonNon_Native();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(8000);
		directsendPage.ClickOnEditButton();
		Thread.sleep(2000);
		directsendPage.ClickOnFastButton();
		Thread.sleep(2000);
		directsendPage.ClickOnSaveButton();
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		Thread.sleep(3000);
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Avalanche Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Avalanche Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_7() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.TransactionAtAvalancheNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("1000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtAvalancheNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Avalanche Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Avalanche non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_8() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.AvalancheToggleButtonForNonNative();
		directsendPage.TransactionAtAvalancheNon_Native();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtAvalancheNon_Native();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Cronos Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Cronos Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_9() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.TransactionAtCronosNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("1000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtCronosNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Cronos Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Cronos non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_10() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.CronosToggleButtonForNonNative();
		directsendPage.TransactionAtCronosNon_Native();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtCronosNon_Native();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Fantom Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Fantom Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_11() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.TransactionAtFantomNative();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("1000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtFantomNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.00001");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Confirm transaction functionality for send(Fantom Non Native Token)"))
//	@Description("Test Case Description: Send Transaction Of Fantom non Native Token")
//	@Story("Story Name: Confirm transaction functionality for send")
	public void TestCase20_12() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.FantomToggleButtonForNonNative();
		directsendPage.TransactionAtFantomNon_Native();
		String sendEle = driver.findElement(By.xpath("//div[ contains (text(),'Select Recipient...')]")).getText();
		softassert.assertEquals("Select Recipient...", sendEle);
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		softassert.assertTrue(directsendPage.VerifyAmountField(), "InputField is not enable");
		String error_msg1 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		Assert.assertEquals("  Please enter amount", error_msg1);
		directsendPage.EnterAmountField("100000");
		String error_msg2 = driver.findElement(By.id("ConfirmSend-error-text")).getText();
		softassert.assertEquals("  Insufficient funds available", error_msg2);
		directsendPage.ClearEditField();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.RejectButton();
		directsendPage.BackButton();
		directsendPage.TransactionAtFantomNon_Native();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("1");
		Thread.sleep(2000);
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Edit / Custom gas fee functionality"))
//	@Description("Test Case Description:Test Edit functionality of Transaction")
//	@Story("Story Name: Verifying the Functionality of custom gas fee")
	public void TestCase21() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		Thread.sleep(20000);
		directsendPage.TransactionAtBNBNative();
		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
		directsendPage.SendTxButton();
		directsendPage.EnterAmountField("0.000001");
		Thread.sleep(2000);
		softassert.assertTrue(directsendPage.VerifyEditButton(), "Edit button is not visible");
		directsendPage.ClickOnEditButton();
		String GasFeeEle = driver.findElement(By.xpath("//div[ contains (text(),'Gas Fees')]")).getText();
		softassert.assertEquals("Gas Fees", GasFeeEle);
		directsendPage.ClickOnSlowButton();
		directsendPage.ClickOnFastButton();
		directsendPage.ClickOnMediumButton();
		directsendPage.ClickOnCustomButton();
		directsendPage.ClearGasFeeField();
		directsendPage.EnterGasFeeField("1");
		Thread.sleep(2000);
		directsendPage.ClickOnSaveButton();
		String error_msg = driver.findElement(By.xpath("//div[ contains (text(),'Gas fee too low')]")).getText();
		softassert.assertEquals("Gas fee too low", error_msg);
		directsendPage.ClearGasFeeField();
		directsendPage.EnterGasFeeField("50");
		Thread.sleep(2000);
		directsendPage.ClickOnSaveButton();
		String error_msg1 = driver.findElement(By.xpath("//div[ contains (text(),'too much gas provided')]")).getText();
		softassert.assertEquals("too much gas provided", error_msg1);
		directsendPage.ClearGasFeeField();
		directsendPage.EnterGasFeeField("20");
		Thread.sleep(2000);
		directsendPage.ClickOnSaveButton();
		directsendPage.ClickOnFastButton();
		directsendPage.ClickOnResetButton();
		directsendPage.clickOnClickAndHoldButton();
		directsendPage.ClickOnActivityButton();
		driver.findElement(By.xpath("//div[ contains(text(),'0x28…2A88')]")).isDisplayed();
		softassert.assertAll();
	}

//	@Test(priority = 1)
//	public void SendTransactionOfBNB_Native() throws InterruptedException {
//		directsendPage.TransactionAtBNBNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfBNB_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtBNBNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfBNB_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtBNBNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_BNB_Non_Native() throws InterruptedException {
//		directsendPage.BnbToggleButtonForNonNative();
//		directsendPage.TransactionAtBNBNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_BNB_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.BnbToggleButtonForNonNative();
//		directsendPage.TransactionAtBNBNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_BNB_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.BnbToggleButtonForNonNative();
//		directsendPage.TransactionAtBNBNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}

//	@Test(priority = 1)
//	public void SendTransactionOfEth_Native() throws InterruptedException {
//		directsendPage.TransactionAtEthNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfEth_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtEthNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfEth_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtEthNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Eth_Non_Native() throws InterruptedException {
//		directsendPage.EthToggleButtonForNonNative();
//		directsendPage.TransactionAtEthNonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Eth_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.EthToggleButtonForNonNative();
//		directsendPage.TransactionAtEthNonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Eth_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.EthToggleButtonForNonNative();
//		directsendPage.TransactionAtEthNonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}

//	@Test(priority = 1)
//	public void SendTransactionOfPlygon_Native() throws InterruptedException {
//		directsendPage.TransactionAtPolygonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfPolygon_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtPolygonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfPolygon_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtPolygonNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Polygon_Non_Native() throws InterruptedException {
//		directsendPage.PolygonToggleButtonForNonNative();
//		directsendPage.TransactionAtPolygonNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Polygon_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.PolygonToggleButtonForNonNative();
//		directsendPage.TransactionAtPolygonNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Polygon_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.PolygonToggleButtonForNonNative();
//		directsendPage.TransactionAtPolygonNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}

//	@Test(priority = 1)
//	public void SendTransactionOfAvalanche_Native() throws InterruptedException {
//		directsendPage.TransactionAtAvalancheNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfAvalanche_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtAvalancheNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfAvalanche_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtAvalancheNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Avalanche_Non_Native() throws InterruptedException {
//		directsendPage.AvalancheToggleButtonForNonNative();
//		directsendPage.TransactionAtAvalancheNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Avalache_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.AvalancheToggleButtonForNonNative();
//		directsendPage.TransactionAtAvalancheNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Avalanche_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.AvalancheToggleButtonForNonNative();
//		directsendPage.TransactionAtAvalancheNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}

//	@Test(priority = 1)
//	public void SendTransactionOfCronos_Native() throws InterruptedException {
//		directsendPage.TransactionAtCronosNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfCronos_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtCronosNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfCronos_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtCronosNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Cronos_Non_Native() throws InterruptedException {
//		directsendPage.CronosToggleButtonForNonNative();
//		directsendPage.TransactionAtCronosNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Cronos_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.CronosToggleButtonForNonNative();
//		directsendPage.TransactionAtCronosNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Cronos_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.CronosToggleButtonForNonNative();
//		directsendPage.TransactionAtCronosNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfFantom_Native() throws InterruptedException {
//		directsendPage.TransactionAtFantomNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("0.00001");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfFantom_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.TransactionAtFantomNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOfFantom_NativeWithInvalidValue() throws InterruptedException {
//		directsendPage.TransactionAtFantomNative();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Fantom_Non_Native() throws InterruptedException {
//		directsendPage.FantomToggleButtonForNonNative();
//		directsendPage.TransactionAtFantomNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("1");
//		directsendPage.clickOnClickAndHoldButton();
//		Thread.sleep(5000);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Fantom_Non_NativeWithInvalidAddress() throws InterruptedException {
//		directsendPage.FantomToggleButtonForNonNative();
//		directsendPage.TransactionAtFantomNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A8");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("SelectAddress-invalid-error")).getText();
//		Assert.assertEquals("Invalid Account address", eror_msg);
//	}
//
//	@Test(priority = 1)
//	public void SendTransactionOf_Fantom_Non_NativeWithInvalidAmount() throws InterruptedException {
//		directsendPage.FantomToggleButtonForNonNative();
//		directsendPage.TransactionAtFantomNon_Native();
//		directsendPage.EnterAddressField("0x287cf34b46797570c74BD367dC081B57d2A52A88");
//		directsendPage.SendTxButton();
//		directsendPage.EnterAmountField("100000");
//		Thread.sleep(1000);
//		String eror_msg = driver.findElement(By.id("ConfirmSend-error-text")).getText();
//		Assert.assertEquals("  Insufficient funds available", eror_msg);
//
//	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
