package com.sonarwallet.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class ImportWallet extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath = "//div[ contains (text(),'I’ve read and understand the risks')]")
	WebElement SecurityDisclaimer;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div/div[2]/div/div[3]/div")
	WebElement IWPassword;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div/div[3]/div/div[2]/div")
	WebElement IWConfirmPassword;
	
	@FindBy(xpath ="/html/body/div/div/div/div/div/div[4]/div/div[6]")
	WebElement IWokletsgo;
	
	@FindBy(id = "ActionList-onImportWallet")
	WebElement IWImportWalletBtn;
	
	@FindBy(id ="ImportWallet-textarea")
	WebElement IWPasteSeedPhrase;
	
	@FindBy(id ="ImportWallet-onImport")
	WebElement IWImportSeedPhraseBtn;
	
	@FindBy(id ="Switch-handleSwitchChange")
	WebElement IWToggleBtn;
	
	@FindBy(id ="DefaultWallet-openWallet")
	WebElement IWOpenWalletBtn;
	
	
	
	//Initializing the Page Objects:
	public ImportWallet(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
		
	public void IWEnterPwd(String Pwd){
		SecurityDisclaimer.click();
		IWPassword.sendKeys(Pwd);
		IWPassword.sendKeys(Keys.ENTER);
	}
	
	public void IWconfirmPwd(String Cpwd){
		IWConfirmPassword.sendKeys(Cpwd);
		IWConfirmPassword.sendKeys(Keys.ENTER);
	}
	
	public void IWOkletsGoButton() {
		IWokletsgo.click();
	}
	
	public void IWImportWalletGoButton() {
		IWImportWalletBtn.click();
	}
	
	public void IWPasteSeedPhrase(String SeedPhrase) {
		IWPasteSeedPhrase.clear();
		IWPasteSeedPhrase.sendKeys(SeedPhrase);
		IWImportSeedPhraseBtn.click();
	}
	
	public boolean verifyImportSeedPhraseButton() {
		return IWImportSeedPhraseBtn.isEnabled();
	}
	
	
	public void IWToggleButton() {
		IWToggleBtn.click();
	}
	
	public void IWOpenWalletButton() {
		IWOpenWalletBtn.click();
		
	}
		
	
	public Dashboard ImportWalletToDashboard (String un, String pwd) throws InterruptedException{
		SecurityDisclaimer.click();
		IWPassword.sendKeys(un);
		IWPassword.sendKeys(Keys.ENTER);
		IWConfirmPassword.sendKeys(pwd);
		IWConfirmPassword.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		IWokletsgo.click();
		IWImportWalletBtn.click();
		IWPasteSeedPhrase.clear();
		IWPasteSeedPhrase.sendKeys(prop.getProperty("seedphrase"));
		IWImportSeedPhraseBtn.click();
		IWOpenWalletBtn.click();
		
		return new Dashboard();
	}
	
	public SettingsPage ImportWalletToSetting (String un, String pwd) throws InterruptedException{
		SecurityDisclaimer.click();
		IWPassword.sendKeys(un);
		IWPassword.sendKeys(Keys.ENTER);
		IWConfirmPassword.sendKeys(pwd);
		IWConfirmPassword.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		IWokletsgo.click();
		IWImportWalletBtn.click();
		IWPasteSeedPhrase.clear();
		IWPasteSeedPhrase.sendKeys(prop.getProperty("seedphrase"));
		IWImportSeedPhraseBtn.click();
		IWOpenWalletBtn.click();
		
		return new SettingsPage();
	}

}
