package com.sonarwallet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class SendPage extends TestBase {

	// Page Factory - OR:
	
	@FindBy(id = "FunctionalityNavigators-onSendClick")
	WebElement SendMainButton;
	
	@FindBy(id = "dashboard-totalsum")
	WebElement TotalAsset;
	
	@FindBy(xpath = "//div[ contains (text(),'Select Token to send')]")
	WebElement SelectTokenHeading;

	@FindBy(id = "TopLayoutComponent-goBack")
	WebElement BackBtn;

	@FindBy(id = "select-token-search")
	WebElement SelectTokenSearch;

	@FindBy(id = "SelectAddress-input")
	WebElement EnterAddressFld;

	@FindBy(id = "SelectAddress-handleSend")
	WebElement sendTxBtn;
	
	@FindBy(id = "add-address-input-0")
	WebElement EditAddressFld;
	
	@FindBy(id = "add-address-input-2")
	WebElement EnterNameFld;
	
	@FindBy(id = "AddressInsertionComponent-handleSave")
	WebElement Savebtn;

	@FindBy(id = "ConfirmSend-handleChange")
	WebElement EnterAmountFld;

	@FindBy(id = "RainbowHoldButton-onHoldComplete")
	WebElement HoldToConfirmBtn;
	
	@FindBy(xpath = "//div[ contains (text(),'Ethereum Görli Chain')]")
	WebElement expandgoerliChain;
	
	@FindBy(id = "TokenHoldingTile-1-0")
	WebElement SelectEthToken;
	
	@FindBy(xpath = "//div[ contains (text(),'Select Recipient...')]")
	WebElement selectRecepientHeading;
	
	@FindBy(id = "SelectAddress-setShowModalTransferBetweenAccounts")
	WebElement TransferBetweenAccountsBtn;
	
	@FindBy(id = "Switch-handleSwitchChange")
	WebElement SaveAddressBookToggleBtn;
	//Address book modal
	@FindBy(id = "Dashboard-goToSetting")
	WebElement Hamburgerbtn;
	
	@FindBy(id = "ListItem-Address Book")
	WebElement AddressBookbtn;
	
	@FindBy(id = "edit-0x287cf34b46797570c74BD367dC081B57d2A52A88")
	WebElement ABPenilIcon;
	
	@FindBy(id = "add-address-input-0")
	WebElement ABAddressfld;
	
	@FindBy(id = "add-address-input-3")
	WebElement ABNotefld;
	
	@FindBy(id = "AddressInsertionComponent-handleSave")
	WebElement ABSaveEditbtn;
	
	@FindBy(id = "AddressInsertionComponent-handleClose")
	WebElement Cancelbtn;
	
	@FindBy(id = "remove-0x287cf34b46797570c74BD367dC081B57d2A52A88")
	WebElement ABDeleteIcon;
	//End

	// Initializing the Page Objects:
	public SendPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean validateSendPage() {
		return SelectTokenHeading.isDisplayed();
	}

	public void clickOnClickAndHoldButton() {
		Actions action = new Actions(driver);
		action.moveToElement(HoldToConfirmBtn).pause(Duration.ofSeconds(2)).clickAndHold().perform();

	}

	public void SendTransactionCRO(String Address, String Amount) throws InterruptedException {
		Thread.sleep(2000);
		SelectTokenSearch.sendKeys("CRO");
		Thread.sleep(3000);
		driver.findElement(By.id("TokenHoldingTile-4-0")).click();
		EnterAddressFld.sendKeys(Address);
		sendTxBtn.click();
		EnterAmountFld.sendKeys(Amount);
	}
//		
//		public void IWOkletsGoButton() {
//			IWokletsgo.click();
//		}
	
	public void ClickOnSendButton() {
		sendTxBtn.click();
	}
	
	public void ClearNameField() {
		EnterNameFld.sendKeys(Keys.CONTROL + "a");
		EnterNameFld.sendKeys(Keys.DELETE);
		//EnterAddressFld.clear();
	}
	
	public void EnterNameField(String Name) {
		EnterNameFld.sendKeys(Name);
	}
	
	public void ClickOnSendMainButton() {
		SendMainButton.click();
	}
	
	public void ClickOnSaveButton() {
		Savebtn.click();
	}
	
	public void ClickOnEthToken() {
		SelectEthToken.click();
	}
	
	public void VerifyTokenHeading() {
		SelectTokenHeading.getText();
	}
	
	public String VerifyRecepientHeading() {
		String text = selectRecepientHeading.getText();
		return text;
	}
	
	public boolean VerifyTokenSearch() {
		return SelectTokenSearch.isEnabled();
	}
	
	public void EnterInSearchField(String Input) {
		SelectTokenSearch.sendKeys(Input);
	}
	
	
	public String VerifyPlaceHolder() {
		String text = SelectTokenSearch.getAttribute("Placeholder");
		return text;
	}
	
	public void Expandgoerli() {
		expandgoerliChain.click();
	}
	
	public void ClickOnAddressBookToggleButton() {
		SaveAddressBookToggleBtn.click();
	}
	
	public void BackButton() {
		BackBtn.click();
	}
	
	public boolean Verifytransferbetweenaccountsbutton() {
		return TransferBetweenAccountsBtn.isDisplayed();
	}
	
	public void EnterAddressField(String Address) {
		EnterAddressFld.sendKeys(Address);
	}
	
	public void ClearAddressField() {
		EnterAddressFld.sendKeys(Keys.CONTROL + "a");
		EnterAddressFld.sendKeys(Keys.DELETE);
		//EnterAddressFld.clear();
	}
	
	public String TotalDollarAsset(){
		return TotalAsset.getText();
	}
	
	public void ClickOnSettingButton() {
		Hamburgerbtn.click();
	}
	
	public void ClickOnAddressBookButton() {
		AddressBookbtn.click();
	}
	
	public void ClickOnAddressBookPencilIcon() {
		ABPenilIcon.click();
	}
	
	public void ClearEditAddressField() {
		ABAddressfld.sendKeys(Keys.CONTROL + "a");
		ABAddressfld.sendKeys(Keys.DELETE);
		
	}
	
	public void EditAddressField(String Address) {
		ABAddressfld.sendKeys(Address);
	}
	
	public void ClearNoteField() {
		ABNotefld.sendKeys(Keys.CONTROL + "a");
		ABNotefld.sendKeys(Keys.DELETE);
		
	}
	
	public void EditNoteField(String Note) {
		ABNotefld.sendKeys(Note);
	}
	
	
	
	
	
	
	public void ClickOnSaveEditButton() {
		ABSaveEditbtn.click();
	}
	
	public void ClickOnCancelbutton() {
		Cancelbtn.click();
	}
	
	public void ClickOnAddressBookDeleteIcon() {
		ABDeleteIcon.click();
	}
	
	
	

}
