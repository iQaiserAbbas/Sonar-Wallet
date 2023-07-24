package com.sonarwallet.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sonarwallet.qa.base.TestBase;

public class SwapPage extends TestBase {

	@FindBy(id = "FunctionalityNavigators-onSwapClick")
	WebElement Swapbtn;

	@FindBy(id = "swap-tokenA-navigateTokenASelection")
	WebElement SpendTokenDropdown;

	@FindBy(id = "swap-tokenB-navigateTokenASelection")
	WebElement RecieveTokenDropdown;

	@FindBy(id = "select-token-search")
	WebElement TokenSerachFld;

	@FindBy(id = "TokenHoldingTile-0-0")
	WebElement SelectBscTokenFromSearch;

	@FindBy(id = "TokenHoldingTile-1-0")
	WebElement SelectEthereumTokenFromSearch;

	@FindBy(id = "TokenHoldingTile-2-0")
	WebElement SelectPolygonTokenFromSearch;

	@FindBy(id = "swap-tokenA-input")
	WebElement SpendValueInputFld;

	@FindBy(id = "swap-tokenB-input")
	WebElement RecieveValueInputFld;

	@FindBy(id = "MAX")
	WebElement SelectMax;

	@FindBy(id = "50%")
	WebElement Select50;

	@FindBy(id = "25%")
	WebElement Select25;

	@FindBy(xpath = "//div[ contains (text(),'Edit')]")
	WebElement Editbtn;

	@FindBy(xpath = "//div[ contains (text(),'Slow')]")
	WebElement SlowGasFeebtn;

	@FindBy(xpath = "//div[ contains (text(),'Fast')]")
	WebElement FastGasFeebtn;

	@FindBy(xpath = "//div[ contains (text(),'Custom')]")
	WebElement CustomGasFeebtn;

	@FindBy(id = "CustomAmountComponent-handleChange")
	WebElement CustomGassFeeFld;

	@FindBy(id = "SaveAndResetButon-onSave")
	WebElement Savebtn;

	@FindBy(id = "SaveAndResetButon-onReset")
	WebElement Resetbtn;

	@FindBy(id = "TransactionFee-handlecustom")
	WebElement Rejectbtn;

	@FindBy(xpath = "//div[ contains (text(),'1%')]")
	WebElement OnePercentSlipagebtn;

	@FindBy(xpath = "//div[ contains (text(),'5%')]")
	WebElement FivePercentSlipagebtn;

	@FindBy(id = "RainbowHoldButton-onHoldComplete")
	WebElement HoldToConfirmBtn;

	@FindBy(id = "SwitchTab-2")
	WebElement ActivityBtn;

	@FindBy(xpath = "//div[ contains (text(),'Swapping')]")
	WebElement SwappingText;

	// Initializing the Page Objects:
	public SwapPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean validateSendPage() {
		return false;

	}

	// Method for click and hold button for confirm transaction
	public void clickOnClickAndHoldButton() {
		Actions action = new Actions(driver);
		action.moveToElement(HoldToConfirmBtn).pause(Duration.ofSeconds(3)).clickAndHold().perform();
	}

	public void ClickOnSelectSpendTokenDropdown() {
		SpendTokenDropdown.click();
	}

	public void TokenSearchField(String TokenA) {
		TokenSerachFld.sendKeys(TokenA);
	}

	public void ClickOnBscToken() {
		SelectBscTokenFromSearch.click();
	}

	public void ClickOnEtherumToken() {
		SelectEthereumTokenFromSearch.click();
	}

	public void ClickOnPolygonToken() {
		SelectPolygonTokenFromSearch.click();
	}

	public void ClickOnSelectRecieveTokenDropdown() {
		RecieveTokenDropdown.click();
	}

	public void EnterValuefield(String value) {
		SpendValueInputFld.sendKeys(value);
	}

	public void ClearValuefield() {
		SpendValueInputFld.clear();
	}

	public boolean VerifyMaxButton() {
		return SelectMax.isDisplayed();
	}

	public void ClickOnMax() {
		SelectMax.click();
	}

	public boolean Verify50percentButton() {
		return Select50.isDisplayed();
	}

	public void ClickOn50percent() {
		Select50.click();
	}

	public boolean Verify25percentButton() {
		return Select25.isDisplayed();
	}

	public void ClickOn25percent() {
		Select25.click();
	}

	public boolean VerifyEditModal() {
		return HoldToConfirmBtn.isDisplayed();
	}

	public void ClickOnRejectButton() {
		Rejectbtn.click();
	}

	public void ClickOnEditButton() {
		Editbtn.click();
	}

	public void ClickOnResetButton() {
		Resetbtn.click();
	}

	public void ClickOnSwapButton() {
		Swapbtn.click();
	}

	public void ClickOnActivityButton() {
		ActivityBtn.click();
	}

	public boolean VerifySwappingModal() {
		return SwappingText.isDisplayed();
	}

	public void EthereumSwap(String tokenA, String tokenB) throws InterruptedException {
		ClickOnSelectSpendTokenDropdown();
		TokenSearchField(tokenA);
		Thread.sleep(2000);
		ClickOnEtherumToken();
		ClickOnSelectRecieveTokenDropdown();
		TokenSearchField(tokenB);
		Thread.sleep(2000);
		ClickOnEtherumToken();
		Thread.sleep(5000);
		ClickOn25percent();
		Thread.sleep(15000);
		clickOnClickAndHoldButton();
//		ClickOnRejectButton();
		
	}
	
	public void BinanceSwap(String tokenA, String tokenB) throws InterruptedException {
		ClickOnSelectSpendTokenDropdown();
		TokenSearchField(tokenA);
		Thread.sleep(2000);
		ClickOnBscToken();
		ClickOnSelectRecieveTokenDropdown();
		TokenSearchField(tokenB);
		Thread.sleep(2000);
		ClickOnBscToken();
		Thread.sleep(5000);
		ClickOn25percent();
		Thread.sleep(15000);
		clickOnClickAndHoldButton();
//		ClickOnRejectButton();
		
	}

}
