package com.sonarwallet.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.CreateWallet;
import com.sonarwallet.qa.pages.Dashboard;

public class CreateWalletTest extends TestBase {

	CreateWallet createWallet;
	Dashboard dashboard;

	public CreateWalletTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		createWallet = new CreateWallet();
		// Handling Alert at deployed environment
//		Alert alert = driver.switchTo().alert();
//		alert.sendKeys("$underDEVELOPMENT#56**");
//		alert.accept();
		// done
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Signup/onboarding for New User"))
	public void TestCase1() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("Sonar@123");
		createWallet.confirmPwd("Sonar@123");
		createWallet.OkletsGoButton();
		softassert.assertTrue(createWallet.verifyCreateWalletButton(), "Create Wallet button is not visible");
		softassert.assertTrue(createWallet.verifyImportWalletButton(), "Import Wallet button is not visible");
		softassert.assertAll();

	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Signup/onboarding for New User With Invalid Password"))
	public void TestCase2_1() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("1234567");
		String eror_msg = driver.findElement(By.id("Step2-error-password")).getText();
		System.out.println("------> This is error: "+ eror_msg);
		if(eror_msg.equals("")) {
			System.out.println("------> Password Strength checker is not in place");
		}else {
			softassert.assertEquals(
					"Password must be at least 8 characters long, should contain upper & lower case letters, at least 1 number & 1 special character",
					eror_msg);
		}
		
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Signup/onboarding for New User With Null Password"))
	public void TestCase2_2() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("");
		String eror_msg = driver.findElement(By.id("Step2-error-password")).getText();
		System.out.println("------> This is error: "+ eror_msg);
		if(eror_msg.equals("")) {
			System.out.println("------> Password Strength checker is not in place");
		}else {
			softassert.assertEquals(
					"Password must be at least 8 characters long, should contain upper & lower case letters, at least 1 number & 1 special character",
					eror_msg);
		}
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Signup/onboarding for New User With Invalid Confirm Password"))
	public void TestCase2_3() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("Sonar@123");
		createWallet.confirmPwd("87654321");
		String eror_msg = driver.findElement(By.xpath("//*[ contains (text(),'Something looks wrong')]")).getText();
		softassert.assertEquals("Something looks wrong", eror_msg);
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Create New Wallet"))
	public void TestCase3() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("Sonar@123");
		createWallet.confirmPwd("Sonar@123");
		createWallet.OkletsGoButton();
		createWallet.CreateNewWalletButton();
		createWallet.GoButton();
		createWallet.RevealSeedPhraseButton();
		createWallet.getseedphraselist();
		createWallet.NextButton();
		createWallet.CreateWalletNameOkButton();
		createWallet.OpenWalletButton();
		WebElement ele = driver.findElement(By.id("Dashboard-goToSetting"));
		softassert.assertTrue(ele.isDisplayed());
		driver.findElement(By.xpath("//*[@id='Dashboard-toggleGraph' and //div[contains(text(),'0')]] ")).getText();
		softassert.assertAll();
	}

	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Create New Wallet with wrong seed phrase"))
	public void TestCase4() throws InterruptedException {
		createWallet.SecurityDisclaimerCheck();
		createWallet.CreatePwd("Sonar@123");
		createWallet.confirmPwd("Sonar@123");
		createWallet.OkletsGoButton();
		createWallet.CreateNewWalletButton();
		createWallet.GoButton();
		createWallet.RevealSeedPhraseButton();
		createWallet.getseedphraseWronglist();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
