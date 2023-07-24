package com.sonarwallet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sonarwallet.qa.base.TestBase;

public class EditTokenPage extends TestBase {

	@FindBy(id = "ExplorerSection-navigateEditlist")
	WebElement EditTokenBtn;

	@FindBy(xpath = "//div[ contains (text(),'Add Custom Token')]")
	WebElement AddCustombtn;

	@FindBy(xpath = "//div[ contains (text(),'Add to List') ] ")
	WebElement AddToListbtn;
	
	@FindBy(id = "edit-list-clear-input")
	WebElement Crossbtn;
	
	@FindBy(id = "custom-token-clear-input")
	WebElement CrossforCustomTokenbtn;

	// Select Chain while adding token
	@FindBy(id = "NetworkList-5")
	WebElement SelectEthChain;

	@FindBy(id = "NetworkList-97")
	WebElement SelectBinanceChain;

	@FindBy(id = "NetworkList-338")
	WebElement SelectCronosChain;

	@FindBy(id = "NetworkList-338")
	WebElement SelectFantomChain;

	@FindBy(id = "NetworkList-43113")
	WebElement SelectAvalancheChain;

	@FindBy(id = "NetworkList-80001")
	WebElement SelectPolygonChain;
	// End

	@FindBy(id = "token-address-input")
	WebElement TokenAddressfld;

	@FindBy(id = "edit-list-search")
	WebElement SearchAddressfld;
	// End

	// Check Native token available
	@FindBy(id = "TokenHoldingTile-0-0")
	WebElement BnbToken;

	@FindBy(id = "TokenHoldingTile-1-0")
	WebElement EthToken;

	@FindBy(id = "TokenHoldingTile-2-0")
	WebElement MaticToken;

	@FindBy(id = "TokenHoldingTile-3-0")
	WebElement AvaxToken;

	@FindBy(id = "TokenHoldingTile-4-0")
	WebElement CROToken;

	@FindBy(id = "TokenHoldingTile-5-0")
	WebElement FTMToken;

	@FindBy(id = "TokenHoldingTile-6-0")
	WebElement SolToken;
	// End

	// Check Native token available
	@FindBy(id = "TokenHoldingTile-0-1")
	WebElement BnbTokenHolding1;

	@FindBy(id = "TokenHoldingTile-1-1")
	WebElement EthTokenHolding1;

	@FindBy(id = "TokenHoldingTile-2-1")
	WebElement MaticTokenHolding1;

	@FindBy(id = "TokenHoldingTile-3-1")
	WebElement AvaxTokenHolding1;

	@FindBy(id = "TokenHoldingTile-4-1")
	WebElement CROTokenHolding1;

	@FindBy(id = "TokenHoldingTile-5-1")
	WebElement FTMTokenHolding1;

	// End

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

	// Initializing the Page Objects:
	public EditTokenPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public void VerifyAllTokens() {
		EthToken.isDisplayed();
		BnbToken.isDisplayed();
		MaticToken.isDisplayed();
		CROToken.isDisplayed();
		AvaxToken.isDisplayed();
		FTMToken.isDisplayed();
		SolToken.isDisplayed();
		BnbTokenHolding1.isDisplayed();
		EthTokenHolding1.isDisplayed();
		MaticTokenHolding1.isDisplayed();
		CROTokenHolding1.isDisplayed();
		AvaxTokenHolding1.isDisplayed();
		FTMTokenHolding1.isDisplayed();

	}

	public boolean VerifySearchField() {
		return SearchAddressfld.isEnabled();
	}

	public void ClickonCrossButton() {
		Crossbtn.click();
	}
	
	public void ClickonCrossForAddressButton() {
		CrossforCustomTokenbtn.click();
	}
	
	public void EnterValueinSearchField(String SearchItem) {
		SearchAddressfld.sendKeys(SearchItem);
	}

	public void EnableAllNonNativeTokens() throws InterruptedException {
		BnbChainToken1Toggle.click();
		Thread.sleep(5000);
		EthChainToken1Toggle.click();
		Thread.sleep(5000);
		PolygonChainToken1Toggle.click();
		Thread.sleep(5000);
		AvalancheChainToken1Toggle.click();
		Thread.sleep(5000);
		CronosChainToken1Toggle.click();
		Thread.sleep(5000);
		FantomChainToken1Toggle.click();
		Thread.sleep(5000);
	}

	public boolean VerifyAddCustomButton() {
		return AddCustombtn.isEnabled();
	}

	public void ClickonAddCustomButton() {
		AddCustombtn.click();
	}

	public void SelectEthChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectEthChain));
		SelectEthChain.click();
	}

	public void SelectBNBChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectBinanceChain));
		SelectBinanceChain.click();
	}

	public void SelectCronosChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectCronosChain));
		SelectCronosChain.click();
	}

	public void SelectAvalacheChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectAvalancheChain));
		SelectAvalancheChain.click();
	}

	public void SelectFantomChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectFantomChain));
		SelectFantomChain.click();
	}

	public void SelectPolygonChainToAddToken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SelectPolygonChain));
		SelectPolygonChain.click();
	}

	public boolean VerifyTokenAddresField() {
		return TokenAddressfld.isDisplayed();
	}

	public void EnterTokenAddressField(String TokenAddress) {
		TokenAddressfld.sendKeys(TokenAddress);
	}

	public void ClickOnAddToListButton() {
		AddToListbtn.click();
	}

}
