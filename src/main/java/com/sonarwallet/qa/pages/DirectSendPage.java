package com.sonarwallet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class DirectSendPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//div[ contains (text(),'Select Token...')]")
	WebElement SelectTokenHeading;
	
	@FindBy(xpath = "//div[ contains (text(),'Info')]")
	WebElement Infobtn;
	
	@FindBy(xpath = "//div[ contains (text(),'Chart')]")
	WebElement Chartbtn;
	
	@FindBy(xpath = "//div[ contains (text(),'News')]")
	WebElement Newsbtn;
	
	
//Chain Elements
	@FindBy(id = "RenderChainsList-ChainAccordionSummary-0")
	WebElement BinanceSmartChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-1")
	WebElement EthereumChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-2")
	WebElement PolygonChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-3")
	WebElement AvalancheChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-4")
	WebElement CronosChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-5")
	WebElement FantomChain;

	// End

	// Select Native Token Element
	@FindBy(id = "TokenHoldingTile-0-0")
	WebElement selectBnbTokenInBNBChain;

	@FindBy(id = "TokenHoldingTile-1-0")
	WebElement selectEthTokenInETHChain;

	@FindBy(id = "TokenHoldingTile-2-0")
	WebElement selectMaticTokenInMATICChain;

	@FindBy(id = "TokenHoldingTile-3-0")
	WebElement selectAvaxTokenInAVALANCHEChain;

	@FindBy(id = "TokenHoldingTile-4-0")
	WebElement selectCroTokenInChronosChain;

	@FindBy(id = "TokenHoldingTile-5-0")
	WebElement selectFTMTokenInFANTOMChain;
	// End

	@FindBy(id = "FunctionalityNavigators-onSendClick")
	WebElement SendBtn;
	
	@FindBy(id="FunctionalityNavigators-onSwapClick")
	WebElement Swapbtn;
	
	@FindBy(id="FunctionalityNavigators-onReceiveClick")
	WebElement Recievebtn;

	@FindBy(id = "SelectAddress-input")
	WebElement EnterAddress;

	@FindBy(id = "SelectAddress-handleSend")
	WebElement SendTxBtn;

	@FindBy(id = "ConfirmSend-handleChange")
	WebElement EnterAmountFld;

	@FindBy(id = "RainbowHoldButton-onHoldComplete")
	WebElement HoldToConfirmBtn;

	@FindBy(id = "ExplorerSection-navigateEditlist")
	WebElement EditBtn;

	@FindBy(xpath = "//div[normalize-space()='Tokens']")
	WebElement Token;

	// Enable Non Native Token by toggle button Elements
	@FindBy(id = "Switch-handleSwitchChange0-1")
	WebElement BnbChainToken1Toggle;

	@FindBy(id = "Switch-handleSwitchChange1-1")
	WebElement EthChainToken1Toggle;

	@FindBy(id = "Switch-handleSwitchChange2-1")
	WebElement PolygonChainToken1Toggle;

	@FindBy(id = "Switch-handleSwitchChange3-1")
	WebElement AvalancheChainToken1Toggle;

	@FindBy(id = "Switch-handleSwitchChange4-1")
	WebElement CronosChainToken1Toggle;

	@FindBy(id = "Switch-handleSwitchChange5-1")
	WebElement FantomChainToken1Toggle;
	// End

	@FindBy(id = "TopLayoutComponent-goBack")
	WebElement BackBtn;

	// NoN native Token Element at dashboard
	@FindBy(id = "TokenHoldingTile-0-1")
	WebElement BnBToken1;

	@FindBy(id = "TokenHoldingTile-1-1")
	WebElement ethToken1;

	@FindBy(id = "TokenHoldingTile-2-1")
	WebElement PolygonToken1;

	@FindBy(id = "TokenHoldingTile-3-1")
	WebElement AvalancheToken1;

	@FindBy(id = "TokenHoldingTile-4-1")
	WebElement CronosToken1;

	@FindBy(id = "TokenHoldingTile-5-1")
	WebElement FantomToken1;
	// End
	
	@FindBy(xpath = "//div[ contains (text(),'Edit')]")
	WebElement Editbtn;

	@FindBy(id="TransactionFee-handlecustom")
	WebElement Rejectbtn;
	
	@FindBy(id="OptionBox-0")
	WebElement SlowGasFeebtn;
	
	@FindBy(id="OptionBox-1")
	WebElement MediumGasFeebtn;
	
	@FindBy(id="OptionBox-2")
	WebElement FastGasFeebtn;
	
	@FindBy(id="OptionBox-3")
	WebElement CustomGasFeebtn;
	
	@FindBy(xpath = "//*[ contains (text(),'Save')]")
	WebElement Savebtn;
	
	@FindBy(xpath = "//*[ contains (text(),'Reset')]")
	WebElement Resetbtn;
	
	@FindBy(id="CustomAmountComponent-handleChange")
	WebElement CustomGassFeeFld;
	
	@FindBy(id="SwitchTab-2")
	WebElement Activitybtn;
	
	
	
	// Initializing the Page Objects:
	public DirectSendPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean DashboardPage() {
		return Token.isDisplayed();
	}
	
	//Method for click and hold button for confirm transaction
	public void clickOnClickAndHoldButton() {
		Actions action = new Actions(driver);
		action.moveToElement(HoldToConfirmBtn).pause(Duration.ofSeconds(2)).clickAndHold().perform();

	}
	
	public void ClickOnActivityButton() {
		Activitybtn.click();
	}
	
	//Method for enable non_native token 1 at BNB chain
	public void BnbToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		BnbChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}
	
	//Method for enable non_native token 1 at Eth chain
	public void EthToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		EthChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}
	
	//Method for enable non_native token 1 at polygon chain
	public void PolygonToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		PolygonChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}
	
	//Method for enable non_native token 1 at Avalanche chain
	public void AvalancheToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		AvalancheChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}

	//Method for enable non_native token 1 at Cronos chain
	public void CronosToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		CronosChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}

	//Method for enable non_native token 1 at Fantom chain
	public void FantomToggleButtonForNonNative() throws InterruptedException {
		EditBtn.click();
		Thread.sleep(5000);
		FantomChainToken1Toggle.click();
		Thread.sleep(5000);
		BackBtn.click();
	}

	//Method for Send native token of BNB chain
	public void TransactionAtBNBNative() throws InterruptedException {
		BinanceSmartChain.click();
		Thread.sleep(5000);
		selectBnbTokenInBNBChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
	//	SendBtn.click();

	}

	//Method for Send native token of Polygon chain
	public void TransactionAtPolygonNative() throws InterruptedException {
		PolygonChain.click();
		Thread.sleep(5000);
		selectMaticTokenInMATICChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
		//SendBtn.click();

	}

	//Method for Send native token of Eth chain
	public void TransactionAtEthNative() throws InterruptedException {
		EthereumChain.click();
		Thread.sleep(5000);
		selectEthTokenInETHChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
		//SendBtn.click();
	}

	//Method for Send native token of Avalanche chain
	public void TransactionAtAvalancheNative() throws InterruptedException {
		AvalancheChain.click();
		Thread.sleep(5000);
		selectAvaxTokenInAVALANCHEChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
		//SendBtn.click();
	}

	//Method for Send native token of Cronos chain
	public void TransactionAtCronosNative() throws InterruptedException {
		CronosChain.click();
		Thread.sleep(5000);
		selectCroTokenInChronosChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
		//SendBtn.click();
	}

	//Method for Send native token of Fantom chain
	public void TransactionAtFantomNative() throws InterruptedException {
		FantomChain.click();
		Thread.sleep(5000);
		selectFTMTokenInFANTOMChain.click();
		if(driver.findElement(By.xpath("//*[ contains (text(),'Chart')]")) != null ){

			SendBtn.click();

			   }
		else {
			Thread.sleep(7000);
			SendBtn.click();
		}
		//SendBtn.click();
	}

	//Method for Send Non_native token 1 of BNB chain
	public void TransactionAtBNBNon_Native() throws InterruptedException {
		BinanceSmartChain.click();
		Thread.sleep(5000);
		BnBToken1.click();
		SendBtn.click();
	}

	//Method for Send Non_native token 1 of Polygon chain
	public void TransactionAtPolygonNon_Native() throws InterruptedException {
		PolygonChain.click();
		Thread.sleep(5000);
		PolygonToken1.click();
		SendBtn.click();
	}

	//Method for Send Non_native token 1 of Eth chain
	public void TransactionAtEthNonNative() throws InterruptedException {
		EthereumChain.click();
		Thread.sleep(5000);
		ethToken1.click();
		SendBtn.click();
	}

	//Method for Send Non_native token 1 of Avalanche chain
	public void TransactionAtAvalancheNon_Native() throws InterruptedException {
		AvalancheChain.click();
		Thread.sleep(5000);
		AvalancheToken1.click();
		SendBtn.click();
	}

	//Method for Send Non_native token 1 of Cronos chain
	public void TransactionAtCronosNon_Native() throws InterruptedException {
		CronosChain.click();
		Thread.sleep(5000);
		CronosToken1.click();
		SendBtn.click();
	}

	//Method for Send Non_native token 1 of Fantom chain
	public void TransactionAtFantomNon_Native() throws InterruptedException {
		FantomChain.click();
		Thread.sleep(5000);
		FantomToken1.click();
		SendBtn.click();
	}
	
	
	
	
	public void BinanceChainExpand() {
		BinanceSmartChain.click();
	}
	
	public void EthChainExpand() {
		EthereumChain.click();
	}
	
	public void PolygonChainExpand() {
		PolygonChain.click();
	}
	
	public void SelectBNBToken() {
		selectBnbTokenInBNBChain.click();
	}
	
	public void SelectEthToken() {
		selectEthTokenInETHChain.click();
	}
	
	public void SelectMaticToken() {
		selectMaticTokenInMATICChain.click();
	}
	
	public void SendButton() {
		SendBtn.click();
	}
	
	public void RecieveButton() {
		Recievebtn.click();
	}
	
	public void SwapButton() {
		Swapbtn.click();
	}
	
	public void BackButton() {
		BackBtn.click();
	}
	
	public void InfoButton() {
		Infobtn.click();
	}
	
	public void ChartButton() {
		Chartbtn.click();
	}
	
	public void NewsButton() {
		Newsbtn.click();
	}
	
	public boolean VerifyInfoButton() {
		return Infobtn.isDisplayed();
	}
	
	public boolean VerifyChartButton() {
		return Chartbtn.isDisplayed();
	}
	
	public boolean VerifyNewsButton() {
		return Newsbtn.isDisplayed();
	}
	
	
	
	

	public void EnterAddressField(String Address) {

		EnterAddress.sendKeys(Address);
	}

	public void SendTxButton() {
		SendTxBtn.click();

	}

	public boolean VerifyAmountField() {
		return EnterAmountFld.isEnabled();
	}
	
	public boolean VerifyEditButton() {
		return Editbtn.isDisplayed();
	}
	
	public void ClickOnEditButton() {
		Editbtn.click();

	}
	
	public void ClickOnSlowButton() {
		SlowGasFeebtn.click();
	}
	
	public void ClickOnMediumButton() {
		MediumGasFeebtn.click();
	}
	
	public void ClickOnFastButton() {
		FastGasFeebtn.click();
	}
	
	public void ClickOnCustomButton() {
		CustomGasFeebtn.click();
	}
	
	public void ClickOnSaveButton() {
		Savebtn.click();
	}
	
	public void ClickOnResetButton() {
		Resetbtn.click();
	}
	
	public void EnterGasFeeField(String Amount) {

		CustomGassFeeFld.sendKeys(Amount);
	}
	
	
	
	public void RejectButton() {
		Rejectbtn.click();

	}
	
	public void EnterAmountField(String Amount) {

		EnterAmountFld.sendKeys(Amount);
	}
	
	public void ClearEditField() {
		EnterAmountFld.clear();

	}
	
	public void ClearGasFeeField() {
		CustomGassFeeFld.clear();

	}
	
	

}
