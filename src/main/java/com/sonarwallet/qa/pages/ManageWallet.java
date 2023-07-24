package com.sonarwallet.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class ManageWallet extends TestBase{

	//Change Wallet Name 
	@FindBy(id = "ListItem-Wallet 1")
	WebElement Wallet_1btn;
	
	@FindBy(id = "wallet-edit-pencil")
	WebElement PencilIcon;
	
	@FindBy(xpath = "/html/body/div[2]/button/div[2]/div[2]/div/input")
	WebElement ChangeWalletNamefld;
	
	@FindBy(id = "TopLayoutComponent-goBack")
	WebElement Backbtn;
	
	@FindBy(id = "TopLayoutComponent-goBack")
	WebElement CopybtnOfSeedPhrase;
	//End
	
	
	//Reaveal seedPhrase elements
	
	@FindBy(id = "ListItem-Reveal Secret Phrase")
	WebElement RevealSeedPhraseListBtn;
	
	@FindBy(xpath = "//div[ contains (text(),'Tap to reveal')]")
	WebElement TapToRevealbtn;
	
	@FindBy(id  = "secretViewComponent-input")
	WebElement PasswordFieldForSeedPhrase;
	
	@FindBy(id = "secretViewComponent-onConfirmPassword")
	WebElement confirmbtnForRevealSeedPhrase;
	//end
	
	
	//Import Account elements
	@FindBy(id = "ListItem-Import an Account")
	WebElement ImportAccountListBtn;

	@FindBy(id = "import-account-input")
	WebElement ImportAccountField;

	@FindBy(id = "Button-box-handleClick")
	WebElement Import_btn;
	//End
	
	
	//Create New EVM account elements
	@FindBy(id = "ListItem-Create new EVM Account")
	WebElement CreateNewEVMAccountListBtn;
	
	@FindBy(id = "CreateNewWalletOrAccountModal-input")
	WebElement CreateNewEVMAccountNamefld;

	@FindBy(xpath = "//*[ contains (text(),'OK')]")
	WebElement OkBtn;
	//Create New Solana Account
	@FindBy(id = "ListItem-Create new Solana Account")
	WebElement CreateNewSolanaAccountListBtn;
	
	@FindBy(id = "derivationpath-0")
	WebElement DerivativePath0Btn;
	
	@FindBy(id = "derivationpath-1")
	WebElement DerivativePath1Btn;
	
	
	
	
	//End
	
	
	@FindBy(xpath = "//div[ contains (text(),'All Wallets')]")
	WebElement AllWalletDropdown;
	
	//Change Account name elements
	@FindBy(id = "secretViewComponent-input")
	WebElement RevealPrivateKeyPasswordFld;
	
	//go to setting element
	@FindBy(id = "Dashboard-goToSetting")
	WebElement Hamburgerbtn;

	// Wallet and account button in settings
	@FindBy(id = "ListItem-Wallets & Accounts")
	WebElement WalletAndAccountbtn;
	// Manage wallet button in wallet and account in setting
	@FindBy(id = "ListItem-Manage Wallets")
	WebElement ManageWalletbtn;
	
	
			
	public void GotoManageWallet(){	
			Hamburgerbtn.click();
			WalletAndAccountbtn.click();
			ManageWalletbtn.click();
	}
	//Create New EVM account elements
		
		
		
		
		
	
	
	
	

	
	
	//Reveal Private keys elements
	@FindBy(id = "arrow-0xA2D1D7066365FC01f0Cf232d88f2Df4a7aaBA0a3")
	WebElement EVMAccount;
	
	@FindBy(id = "account-edit-pencil")
	WebElement AccountEditPencil;
	
	
	@FindBy(id = "EditSingleEntityModal-input")
	WebElement EditAccountNamefld;
	
	@FindBy(id = "AccountInfo-handleCopyBtn")
	WebElement CopyAddressbtn;
	
	@FindBy(id = "ListItem-Reveal Private Key")
	WebElement RevealPrivateKeybtn;
	//End
	
	//Import Wallet Elements
	@FindBy(id = "ListItem-Import a Wallet")
	WebElement ImportWalletMainBtn;
	
	@FindBy(id = "import-wallet-input")
	WebElement ImportWalletSeedPhraseFld;
	
	@FindBy(xpath = "//div[ contains (text(),'Find my wallet')]")
	WebElement FindMyWalletBtn;
	
	@FindBy(xpath = "//div[ contains (text(),'Try again')]")
	WebElement TryAgainBtn;
	
	@FindBy(id = "SelectAccountModal-onCancel")
	WebElement CancelBtn;
	
	
	
	
	// Initializing the Page Objects:
				public ManageWallet() {
					PageFactory.initElements(driver, this);
				}
	
	//To do 
	
	
	
		
		public void EnterPasswordSeedPhraseField(String password){
			PasswordFieldForSeedPhrase.sendKeys(password);
		}
		
		public void ClearPasswordSeedPhraseField(){
			PasswordFieldForSeedPhrase.sendKeys(Keys.CONTROL + "a");
			PasswordFieldForSeedPhrase.sendKeys(Keys.DELETE);
		}
		
		//Account Settings
		public void ClickonEVMAccountButton(){
			EVMAccount.click();
		}
		
		public void ClickonEditAccountNameButton(){
			AccountEditPencil.click();
		}
		
		public void ClearAccountNameField(){
			EditAccountNamefld.sendKeys(Keys.CONTROL + "a");
			EditAccountNamefld.sendKeys(Keys.DELETE);
		}
		
		public void EditAccountNameField(String Name){
			EditAccountNamefld.sendKeys(Name);
		}
		
		public void ClickonCopyAddressButton(){
			CopyAddressbtn.click();
		}
		
		public boolean verifyRevealPrivateKeyButton(){
			return RevealPrivateKeybtn.isDisplayed();
		}
		
		public void ClickonRevealPrivateKeyButton(){
			RevealPrivateKeybtn.click();
		}
		
		public void RevealPrivateKeyPasswordField(String password){
			RevealPrivateKeyPasswordFld.sendKeys(password);
		}
		
		public void ClearPasswordForRevealPrivateKeyField(){
			RevealPrivateKeyPasswordFld.sendKeys(Keys.CONTROL + "a");
			RevealPrivateKeyPasswordFld.sendKeys(Keys.DELETE);
		}
		
		
		//Import Account
		
		
		
		
		
		
		
		
		
		
		//Start Import Wallet test Functions
		
		public void ClickOnImportWalletMainButton(){
			ImportWalletMainBtn.click();
		}
		
		public void ClickOnFindMyWalletButton(){
			FindMyWalletBtn.click();
		}
		
		public void ClearImportWalletSeedPhraseField(){
			ImportWalletSeedPhraseFld.sendKeys(Keys.CONTROL + "a");
			ImportWalletSeedPhraseFld.sendKeys(Keys.DELETE);
		}
		
		public void EnterImportWalledSeedPhraseField(String SeedPhrase){
			ImportWalletSeedPhraseFld.sendKeys(SeedPhrase);
		}
		
		public void ClickOnTryAgainButton(){
			TryAgainBtn.click();
		}
		
		public void ClickOnCancelButton(){
			CancelBtn.click();
		}
		
		
		
		
		
		
		
		public void AllWalletdropdown(){
			AllWalletDropdown.click();
		}
		
		public boolean verifySeedPhraseCopyButton(){
			return CopybtnOfSeedPhrase.isDisplayed();
		}
		
		public boolean verifyWallet_1Button(){
			return Wallet_1btn.isDisplayed();
		}
		
		public void ClickonWallet1(){
			Wallet_1btn.click();
		}
		
		public void ClickonPencilIcon(){
			PencilIcon.click();
		}
		
		public void ClearChangeField(){
			ChangeWalletNamefld.sendKeys(Keys.CONTROL + "a");
			ChangeWalletNamefld.sendKeys(Keys.DELETE);
		}
		
		public void ChangeWalletName(String Name){
			ChangeWalletNamefld.sendKeys(Name);
		}
		
		public void ClickOnBackbutton(){
			Backbtn.click();
		}
		
		public void ClickOnRevealSeedPhraseMainbutton(){
			RevealSeedPhraseListBtn.click();
		}
		
		public void ClickOnTapToRevealButton(){
			TapToRevealbtn.click();
		}
		
		public void EnetrPasswordFiedForRevealSeedPhrase(String Password){
			PasswordFieldForSeedPhrase.clear();
			PasswordFieldForSeedPhrase.sendKeys(Password);
		}
		
		public void ClickOnConfirmButton(){
			confirmbtnForRevealSeedPhrase.click();
		}
		
		public void ClickOnImportAccountMainbutton(){
			ImportAccountListBtn.click();
		}
		
		public void EnterPrivateKeyinImportAccountField(String PrivateKey_pk){
			ImportAccountField.sendKeys(PrivateKey_pk);
		}
		
		public void ClickOnImportbutton(){
			Import_btn.click();
		}
		//Create new EVM Account
		public void ClickOnCreateNewEVMAccountButton(){
			CreateNewEVMAccountListBtn.click();
		}
		
		public void ClearCreateNewAccountNameField(){
			CreateNewEVMAccountNamefld.sendKeys(Keys.CONTROL + "a");
			CreateNewEVMAccountNamefld.sendKeys(Keys.DELETE);
		}
		
		public void CreateNewAccountNameField(String Name){
			
			CreateNewEVMAccountNamefld.sendKeys(Name);
		}
		
		
		public void ClickOnOkbutton(){
			OkBtn.click();
		}
		
		public void ClickOnCreateNewSolanaAccountButton(){
			CreateNewSolanaAccountListBtn.click();
		}
		
		public void ClickOnCreateDerivativePath0Button(){
			DerivativePath0Btn.click();
		}
		
		public void ClickOnCreateDerivativePath1Button(){
			DerivativePath1Btn.click();
		}
		
		
		
}
