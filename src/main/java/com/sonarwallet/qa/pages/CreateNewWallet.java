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

public class CreateNewWallet extends TestBase {

	@FindBy(id = "ListItem-Create new Wallet")
	WebElement CreateNewWalletbtn;

	@FindBy(id = "SeedPhraseView-revealSeedphrase")
	WebElement TapToRevealbtn;

	// seedpharse get elements
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
	// End

	// Got it button element
	@FindBy(id = "SeedPhraseView-setIsModalOpen")
	WebElement GotitBtn;

	// Let's go button element
	@FindBy(id = "SeedPhraseSaveAlert-handleOnSave")
	WebElement LetsGoBtn;

	// Next button Element
	@FindBy(id = "Gonext-handleNext")
	WebElement NextBtn;
	
	//Name Filed
	@FindBy(id = "EditSingleEntityModal-input")
	WebElement NameFld;

	// Create Wallet Name ok button element
	@FindBy(xpath = "//*[contains(text(),'OK')]")
	WebElement OkBtn;

	// All wallet dropdown element
	@FindBy(xpath = "//div[ contains (text(),'All Wallets')]")
	WebElement AllWalletDropdown;

	// Initializing the Page Objects:
	public CreateNewWallet() {
		PageFactory.initElements(driver, this);
	}

	// Action

	// Click on Create new wallet
	public void ClickOnCreateNewWalletButton() {
		CreateNewWalletbtn.click();
	}
	
	public void ClickOnTapToRevealButton(){
		TapToRevealbtn.click();
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
		GotitBtn.click();
		Thread.sleep(1000);
		LetsGoBtn.click();
		Thread.sleep(2000);
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

	public void ClickOnNextButton() {
		NextBtn.click();
	}
	
	public void ClearNameField(){
		NameFld.sendKeys(Keys.CONTROL + "a");
		NameFld.sendKeys(Keys.DELETE);
	}
	
	public void EnterNameField(String Name){
		
		NameFld.sendKeys(Name);
	}

	public void ClickOnOkButton() {
		OkBtn.click();
	}

	public void ClickOnAllWalletDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(AllWalletDropdown));
		AllWalletDropdown.click();
	}

}
