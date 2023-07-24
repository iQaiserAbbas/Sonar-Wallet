package com.sonarwallet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class SettingsPage extends TestBase {

	// All wallet dropdown element
	@FindBy(id = "Dashboard-triggerWalletFilter")
	WebElement AllWalletDropdown;

	// Network switch button element
	@FindBy(id = "WalletsFilterModal-handleSwitchNetwork")
	WebElement NetworkSwitchbtn;

	@FindBy(id = "Dashboard-goToSetting")
	WebElement Hamburgerbtn;

	// Wallet and account button in settings
	@FindBy(id = "ListItem-Wallets & Accounts")
	WebElement WalletAndAccountbtn;
	// Manage wallet button in wallet and account in setting
	@FindBy(id = "ListItem-Manage Wallets")
	WebElement ManageWalletbtn;

	@FindBy(id = "ListItem-Create new Wallet")
	WebElement CreateNewWalletbtn;

	// Security and privacy button in setting
	@FindBy(id = "ListItem-Security & Privacy")
	WebElement SecurityAndPrivacybtn;

	@FindBy(id = "ListItem-Address Book")
	WebElement AddressBookbtn;

	@FindBy(xpath = "//*[contains(text(), 'Reset Local Node')]")
	WebElement ResetLocalNodeBtn;

	@FindBy(id = "TopLayoutComponent-goBack")
	WebElement SettingsBackBtn;

	// Initializing the Page Objects:
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public ManageWallet clickOnManageWallet() {
		Hamburgerbtn.click();
		WalletAndAccountbtn.click();
		ManageWalletbtn.click();
		return new ManageWallet();
	}

	public CreateNewWallet ClickOnCreateNewWallet() {
		Hamburgerbtn.click();
		WalletAndAccountbtn.click();
		CreateNewWalletbtn.click();
		return new CreateNewWallet();
	}

	public void WalletAndAccountButton() {
		WalletAndAccountbtn.click();
	}

	public void AllWalletdropdown() {
		AllWalletDropdown.click();
	}

	public void NetworkSwitchButton() {
		NetworkSwitchbtn.click();
	}

	public void ClickResetLocalNodeButton() throws InterruptedException {
		Hamburgerbtn.click();
		ResetLocalNodeBtn.click();
		Thread.sleep(2000);
		SettingsBackBtn.click();
	}

}
