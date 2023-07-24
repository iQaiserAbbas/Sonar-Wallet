package com.sonarwallet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sonarwallet.qa.base.TestBase;

public class CreateWallet extends TestBase {

	// Page Factory - OR:

	// security disclaimer Element

	@FindBy(xpath = "//div[ contains (text(),'I’ve read and understand the risks')]")
	WebElement SecurityDisclaimer;

	// Password field element
	@FindBy(xpath = "/html/body/div/div/div/div/div/div[2]/div/div[3]/div")
	WebElement CWCreatePassword;

	// Confirm password field element
	@FindBy(id = "passwords-step3-input")
	WebElement CWConfirmPassword;

	// Ok lets go button element
	@FindBy(id = "step4-savePassword")
	WebElement CWokletsgo;

	// Create new wallet button element
	@FindBy(id = "ActionList-handleLogin")
	WebElement CWCreateNewWalletBtn;

	// Create new wallet button element
	@FindBy(id = "ActionList-onImportWallet")
	WebElement CWImportWalletBtn;

	// Go button element
	@FindBy(id = "ActionAlert-moveToSeedphrase")
	WebElement CWGoBtn;

	// reveal seed phrase button element
	@FindBy(id = "SeedPhraseView-revealSeedphrase")
	WebElement CWRevealSeedPhraseBtn;

	// seed phrase elements
	@FindBy(id = "SeedPhraseView-word-0")
	WebElement seedphrase1;

	@FindBy(id = "SeedPhraseView-word-1")
	WebElement seedphrase2;

	@FindBy(id = "SeedPhraseView-word-2")
	WebElement seedphrase3;

	@FindBy(id = "SeedPhraseView-word-3")
	WebElement seedphrase4;

	@FindBy(id = "SeedPhraseView-word-4")
	WebElement seedphrase5;

	@FindBy(id = "SeedPhraseView-word-5")
	WebElement seedphrase6;

	@FindBy(id = "SeedPhraseView-word-6")
	WebElement seedphrase7;

	@FindBy(id = "SeedPhraseView-word-7")
	WebElement seedphrase8;

	@FindBy(id = "SeedPhraseView-word-8")
	WebElement seedphrase9;

	@FindBy(id = "SeedPhraseView-word-9")
	WebElement seedphrase10;

	@FindBy(id = "SeedPhraseView-word-10")
	WebElement seedphrase11;

	@FindBy(id = "SeedPhraseView-word-11")
	WebElement seedphrase12;

	// Compelete seed

	// Got it button element
	@FindBy(id = "SeedPhraseView-setIsModalOpen")
	WebElement CWGotitBtn;

	// Let's go button element
	@FindBy(id = "SeedPhraseSaveAlert-handleOnSave")
	WebElement CWLetsGoBtn;

	// Next button Element
	@FindBy(id = "Gonext-handleNext")
	WebElement CWNextBtn;

	// Create Wallet Name ok button element
	@FindBy(xpath = "//*[contains(text(),'OK')]")
	WebElement CWCreateWalletNameOkBtn;

	// Toggle button element
	@FindBy(id = "Switch-handleSwitchChange")
	WebElement CWToggleBtn;

	// Open wallet button element
	@FindBy(id = "DefaultWallet-openWallet")
	WebElement CWOpenWalletBtn;

	// Initializing the Page Objects:
	public CreateWallet() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// method of getting seed phrase and pasting it in select seed phrase
	public void getseedphraselist() throws InterruptedException {
		String seed1 = seedphrase1.getText();
		String seed2 = seedphrase2.getText();
		String seed3 = seedphrase3.getText();
		String seed4 = seedphrase4.getText();
		String seed5 = seedphrase5.getText();
		String seed6 = seedphrase6.getText();
		String seed7 = seedphrase7.getText();
		String seed8 = seedphrase8.getText();
		String seed9 = seedphrase9.getText();
		String seed10 = seedphrase10.getText();
		String seed11 = seedphrase11.getText();
		String seed12 = seedphrase12.getText();
		//try explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(CWGotitBtn));
		CWGotitBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(CWLetsGoBtn));
		CWLetsGoBtn.click();
		
		
		//end
//		CWGotitBtn.click();
//		Thread.sleep(1000);
//		CWLetsGoBtn.click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed1 + "'" + ")]")).click();
		System.out.println("seed1 entered");
		driver.findElement(By.xpath("//*[ contains (text()," + "'" + seed2 + "'" + ")]")).click();
		System.out.println("seed2 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed3 + "'" + ")]")).click();
		System.out.println("seed3 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed4 + "'" + ")]")).click();
		System.out.println("seed4 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed5 + "'" + ")]")).click();
		System.out.println("seed5 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed6 + "'" + ")]")).click();
		System.out.println("seed6 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed7 + "'" + ")]")).click();
		System.out.println("seed7 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed8 + "'" + ")]")).click();
		System.out.println("seed8 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed9 + "'" + ")]")).click();
		System.out.println("seed9 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed10 + "'" + ")]")).click();
		System.out.println("seed10 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed11 + "'" + ")]")).click();
		System.out.println("seed11 entered");
		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed12 + "'" + ")]")).click();
		System.out.println("seed12 entered");

	}
	
	// method of getting Random/Wrong seed phrase and pasting it in select seed phrase
		public void getseedphraseWronglist() throws InterruptedException {
			String seed1 = seedphrase1.getText();
			String seed2 = seedphrase2.getText();
			String seed3 = seedphrase3.getText();
			String seed4 = seedphrase4.getText();
			String seed5 = seedphrase5.getText();
			String seed6 = seedphrase6.getText();
			String seed7 = seedphrase7.getText();
			String seed8 = seedphrase8.getText();
			String seed9 = seedphrase9.getText();
			String seed10 = seedphrase10.getText();
			String seed11 = seedphrase11.getText();
			String seed12 = seedphrase12.getText();
			//try explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(CWGotitBtn));
			CWGotitBtn.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(CWLetsGoBtn));
			CWLetsGoBtn.click();		
			//end

			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed1 + "'" + ")]")).click();
			System.out.println("seed1 entered");
			driver.findElement(By.xpath("//*[ contains (text()," + "'" + seed2 + "'" + ")]")).click();
			System.out.println("seed2 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed3 + "'" + ")]")).click();
			System.out.println("seed3 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed4 + "'" + ")]")).click();
			System.out.println("seed4 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed5 + "'" + ")]")).click();
			System.out.println("seed5 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed7 + "'" + ")]")).click();
			System.out.println("seed6 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed6 + "'" + ")]")).click();
			System.out.println("seed7 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed8 + "'" + ")]")).click();
			System.out.println("seed8 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed9 + "'" + ")]")).click();
			System.out.println("seed9 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed10 + "'" + ")]")).click();
			System.out.println("seed10 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed11 + "'" + ")]")).click();
			System.out.println("seed11 entered");
			driver.findElement(By.xpath("//div[contains(text()," + "'" + seed12 + "'" + ")]")).click();
			System.out.println("seed12 entered");

		}

	// Method of Security check
	public void SecurityDisclaimerCheck() {
		SecurityDisclaimer.click();

	}

	// Method of Enter password field
	public void CreatePwd(String Pwd) {
		CWCreatePassword.sendKeys(Pwd);
		CWCreatePassword.sendKeys(Keys.ENTER);
	}

	// Method of Confirm password field
	public void confirmPwd(String Cpwd) {
		CWConfirmPassword.sendKeys(Cpwd);
		CWConfirmPassword.sendKeys(Keys.ENTER);
	}

	public void OkletsGoButton() {
		CWokletsgo.click();
	}

	public boolean verifyCreateWalletButton() {
		return CWCreateNewWalletBtn.isDisplayed();
	}

	public boolean verifyImportWalletButton() {
		return CWImportWalletBtn.isDisplayed();
	}

	public void CreateNewWalletButton() {
		CWCreateNewWalletBtn.click();
	}

	public void GoButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(CWGoBtn));
		CWGoBtn.click();
	}

	public void RevealSeedPhraseButton() {
		CWRevealSeedPhraseBtn.click();
	}

	public void GotitButton() {
		CWGotitBtn.click();
	}

	public void LetsGoButton() {
		CWLetsGoBtn.click();
	}

	public void CreateWalletNameOkButton() {
		CWCreateWalletNameOkBtn.click();
	}
	
	public boolean verifyNextButton() {
		return CWNextBtn.isDisplayed();
	}

	public void NextButton() {
		CWNextBtn.click();
	}

	public void ToggleButton() {
		CWToggleBtn.click();
	}

	public void OpenWalletButton() {
		CWOpenWalletBtn.click();
	}

}
