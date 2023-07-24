package com.sonarwallet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class SettingPage extends TestBase {
	
	@FindBy(id = "ListItem-Wallets & Accounts")
	WebElement WalletAndAccountbtn;
	
	@FindBy(id="ListItem-Security & Privacy")
	WebElement securityAndPrivacybtn;
	
	@FindBy(id="ListItem-Address Book")
	WebElement AddressBookbtn;
	
	@FindBy(id="ListItem-Help")
	WebElement Helpbtn;
	
	@FindBy(id="ListItem-Base Currency")
	WebElement BaseCurrencybtn;
	
	@FindBy(id="ListItem-Language")
	WebElement Languagebtn;
	
	@FindBy(id="ListItem-Theme")
	WebElement Themebtn;
	
	@FindBy(id="ListItem-Hide Quick Add Token in Main List")
	WebElement HideQuickAddTokenInMainListTogglebtn;
	
	@FindBy(id="ListItem-Use Sonar Wallet as your default wallet")
	WebElement UseSonarAsDefaultWalletTogglebtn;
	
	@FindBy(id="ListItem-Switch Dapp Account")
	WebElement SwitchDappAccountbtn;
	
	@FindBy(id="ListItem-Switch Dapp Network")
	WebElement SwitchDappNetworkbtn;
	
	@FindBy(id="ListItem-Disconnect Wallet")
	WebElement DisconnetWalletbtn;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@FindBy(xpath = "//div[ contains (text(),'All Wallets')]")
//	WebElement AllWalletDropdown;
//
////	@FindBy(xpath = "//div[ contains (text(),'Wallets & Accounts')]")
////	WebElement WalletAndAccountbtn;
//	// Manage wallet
//	@FindBy(id = "ListItem-Manage Wallets")
//	WebElement ManageWalletbtn;
//
//	@FindBy(id = "ListItem-Wallet 1")
//	WebElement Wallet_1btn;
//
//	@FindBy(id = "ListItem-Reveal Secret Phrase")
//	WebElement RevealSeedPhraseListBtn;
//
//	@FindBy(xpath = "//*[ contains (text(),'Confirm')]")
//	WebElement confirmbtnForRevealSeedPhrase;
//
//	@FindBy(xpath = "/html/body/div[2]/button/div/div[1]/div[3]/div[2]/div/input")
//	WebElement EnterPasswordFieldForSeedPhrase;
//
//	@FindBy(id = "ListItem-Import an Account")
//	WebElement ImportAccountListBtn;
//
//	@FindBy(id = "import-account-input")
//	WebElement ImportAccountField;
//
//	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/div/div/div[5]/div")
//	WebElement Import_btn;
//
//	@FindBy(id = "ListItem-Create new Account")
//	WebElement CreateAccountListBtn;
//
//	@FindBy(xpath = "//*[ contains (text(),'OK')]")
//	WebElement OkBtnForCreateNewAccount;
//
//	// Import Wallet
//	@FindBy(id = "ListItem-Import a Wallet")
//	WebElement ImportAWalletbtn;
//
//	// create new wallet from setting
//	@FindBy(xpath = "//div[ contains (text(),'Create new Wallet')]")
//	WebElement CreateNewWalletbtn;
//
//	@FindBy(xpath = "//div[ contains (text(),'Tap to reveal')]")
//	WebElement TapToRevealbtn;
//
//	@FindBy(id = "SeedPhraseView-word-0")
//	WebElement seedphrase1;
//
//	@FindBy(id = "SeedPhraseView-word-1")
//	WebElement seedphrase2;
//
//	@FindBy(id = "SeedPhraseView-word-2")
//	WebElement seedphrase3;
//
//	@FindBy(id = "SeedPhraseView-word-3")
//	WebElement seedphrase4;
//
//	@FindBy(id = "SeedPhraseView-word-4")
//	WebElement seedphrase5;
//
//	@FindBy(id = "SeedPhraseView-word-5")
//	WebElement seedphrase6;
//
//	@FindBy(id = "SeedPhraseView-word-6")
//	WebElement seedphrase7;
//
//	@FindBy(id = "SeedPhraseView-word-7")
//	WebElement seedphrase8;
//
//	@FindBy(id = "SeedPhraseView-word-8")
//	WebElement seedphrase9;
//
//	@FindBy(id = "SeedPhraseView-word-9")
//	WebElement seedphrase10;
//
//	@FindBy(id = "SeedPhraseView-word-10")
//	WebElement seedphrase11;
//
//	@FindBy(id = "SeedPhraseView-word-11")
//	WebElement seedphrase12;
//
//	// Got it button element
//	@FindBy(id = "SeedPhraseView-setIsModalOpen")
//	WebElement GotitBtn;
//
//	// Let's go button element
//	@FindBy(id = "SeedPhraseSaveAlert-handleOnSave")
//	WebElement LetsGoBtn;
//
//	// Next button Element
//	@FindBy(id = "Gonext-handleNext")
//	WebElement NextBtn;
//
//	// Create Wallet Name ok button element
//	@FindBy(xpath = "//*[contains(text(),'OK')]")
//	WebElement CreateWalletNameOkBtn;
//
//	@FindBy(id = "Dashboard-toggleGraph")
//	WebElement Hamburgerbtn;
//
//	@FindBy(xpath = "//div[ contains (text(),'Reveal Secret Phrase')]")
//	WebElement RevealSecretPhrasebtn;
//
//	@FindBy(xpath = "//input[@name='Enter Password']")
//	WebElement InputPasswordfield;
//
//	@FindBy(xpath = "//div[ contains (text(),'Confirm')]")
//	WebElement Confirmbtn;
//
//	@FindBy(xpath = "//input[@type='text']")
//	WebElement EnterPrivateKeyField;
//
//	// will add later
//	@FindBy(xpath = "")
//	WebElement Importbtn;

	// Initializing the Page Objects:
	public SettingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAccountAndWalletButton(){
		return WalletAndAccountbtn.isDisplayed();
	}
	
	public boolean verifySecurityAndPrivacyButton(){
		return securityAndPrivacybtn.isDisplayed();
	}
	
	public boolean verifyAddressBookButton(){
		return AddressBookbtn.isDisplayed();
	}
	
	public boolean verifyHelpButton(){
		return Helpbtn.isDisplayed();
	}
	
	public boolean verifyBaseCurrencyButton(){
		return BaseCurrencybtn.isDisplayed();
	}
	
	public boolean verifyLanguageButton(){
		return Languagebtn.isDisplayed();
	}
	
	public boolean verifyThemeButton(){
		return Themebtn.isDisplayed();
	}
	
	public boolean verifyHideQuickAddTokenInMainListToggleButton(){
		return HideQuickAddTokenInMainListTogglebtn.isDisplayed();
	}
	
	public boolean verifyUseSonarAsDefaultWalletToggleButton(){
		return UseSonarAsDefaultWalletTogglebtn.isDisplayed();
	}
	
	public boolean verifySwitchDappAccountButton(){
		return SwitchDappAccountbtn.isDisplayed();
	}
	
	public boolean verifySwitchDappNetworkButton(){
		return SwitchDappNetworkbtn.isDisplayed();
	}
	
	public boolean verifyDisconnectWalletButton(){
		return DisconnetWalletbtn.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public void WalletAndAccountButton() {
//		WalletAndAccountbtn.click();
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	public void ManageWalletRevealSecretPhraseHF(String password) {
//		WalletAndAccountbtn.click();
//		ManageWalletbtn.click();
//		Wallet_1btn.click();
//		RevealSeedPhraseListBtn.click();
//		EnterPasswordFieldForSeedPhrase.sendKeys(password);
//		confirmbtnForRevealSeedPhrase.click();
//		TapToRevealbtn.click();
//	}
//
//	public void ManageWalletCreatenewAccountHF() {
//		WalletAndAccountbtn.click();
//		ManageWalletbtn.click();
//		Wallet_1btn.click();
//		CreateAccountListBtn.click();
//		OkBtnForCreateNewAccount.click();
//	}
//
//	public void ImportWalletFunctionHF() {
//		WalletAndAccountbtn.click();
//		ImportAWalletbtn.click();
//
//	}
//
//	public void ManageWalletCreateWalletBeforeSeedphraseHF() {
//		WalletAndAccountbtn.click();
//		CreateNewWalletbtn.click();
//		TapToRevealbtn.click();
//	}
//
//	// method of getting seed phrase and pasting it in select seed phrase
//	public void getseedphraselist() throws InterruptedException {
//		String seed1 = seedphrase1.getText();
//		String seed2 = seedphrase2.getText();
//		String seed3 = seedphrase3.getText();
//		String seed4 = seedphrase4.getText();
//		String seed5 = seedphrase5.getText();
//		String seed6 = seedphrase6.getText();
//		String seed7 = seedphrase7.getText();
//		String seed8 = seedphrase8.getText();
//		String seed9 = seedphrase9.getText();
//		String seed10 = seedphrase10.getText();
//		String seed11 = seedphrase11.getText();
//		String seed12 = seedphrase12.getText();
//
//		GotitBtn.click();
//		Thread.sleep(1000);
//		LetsGoBtn.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed1 + "'" + ")]")).click();
//		System.out.println("seed1 entered");
//		driver.findElement(By.xpath("//*[ contains (text()," + "'" + seed2 + "'" + ")]")).click();
//		System.out.println("seed2 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed3 + "'" + ")]")).click();
//		System.out.println("seed3 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed4 + "'" + ")]")).click();
//		System.out.println("seed4 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed5 + "'" + ")]")).click();
//		System.out.println("seed5 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed6 + "'" + ")]")).click();
//		System.out.println("seed6 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed7 + "'" + ")]")).click();
//		System.out.println("seed7 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed8 + "'" + ")]")).click();
//		System.out.println("seed8 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed9 + "'" + ")]")).click();
//		System.out.println("seed9 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed10 + "'" + ")]")).click();
//		System.out.println("seed10 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed11 + "'" + ")]")).click();
//		System.out.println("seed11 entered");
//		driver.findElement(By.xpath("//div[contains(text()," + "'" + seed12 + "'" + ")]")).click();
//		System.out.println("seed12 entered");
//
//	}
//
//	public void ManageWalletCreateWalletAfterSeedPhraseHF() {
//		NextBtn.click();
//		CreateWalletNameOkBtn.click();
//	}
//
//	public void ClickOnAllWalletDropdown() {
//		AllWalletDropdown.click();
//	}
//
//	public void ManageWalletImportAccount(String Privatekey) {
//		WalletAndAccountbtn.click();
//		ManageWalletbtn.click();
//		Wallet_1btn.click();
//		ImportAccountListBtn.click();
//		ImportAccountField.sendKeys(Privatekey);
//		Import_btn.click();
//
//	}
//
//	public void Wallet1Button() {
//		Wallet_1btn.click();
//	}
//
//	public void RevealSecretPhrase(String Password) {
//		RevealSecretPhrasebtn.click();
//		InputPasswordfield.sendKeys(Password);
//		Confirmbtn.click();
//	}
//
//	public void RevealButton() {
//		TapToRevealbtn.click();
//	}
//
//	public void EnterPrivateKey(String Key) {
//		EnterPrivateKeyField.sendKeys(Key);
//		Importbtn.click();
//	}

}
