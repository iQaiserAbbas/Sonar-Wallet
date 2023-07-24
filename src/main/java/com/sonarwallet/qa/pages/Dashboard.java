package com.sonarwallet.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sonarwallet.qa.base.TestBase;

public class Dashboard extends TestBase{
	
	//All wallet dropdown element
	@FindBy(id="Dashboard-triggerWalletFilter")
	WebElement AllWalletDropdown;
	
	//Network switch button element
	@FindBy(id="WalletsFilterModal-handleSwitchNetwork")
	WebElement NetworkSwitchbtn;
	
	@FindBy(id="Dashboard-goToSetting")
	WebElement Hamburgerbtn;

	//Send button element
	@FindBy(id = "FunctionalityNavigators-onSendClick")
	WebElement Sendbtn;
	
	@FindBy(id="FunctionalityNavigators-onSwapClick")
	WebElement Swapbtn;
	
	@FindBy(id="FunctionalityNavigators-onReceiveClick")
	WebElement Recievebtn;
	
	@FindBy(xpath = "//div[normalize-space()='Tokens']")
	WebElement Tokentab;
	
	@FindBy(xpath = "//div[normalize-space()='NFTs']")
	WebElement NFTstab;
	
	@FindBy(xpath = "//div[normalize-space()='Activity']")
	WebElement Activitytab;
	
	@FindBy(id="ExplorerSection-navigateEditlist")
	WebElement EditTokenBtn;
	
	//ChainDropdown elements
	@FindBy(id = "RenderChainsList-ChainAccordionSummary-0")
	WebElement BinanceSmartChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-1")
	WebElement EthereumChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-2")
	WebElement PolygonChain;
	
	@FindBy(id = "RenderChainsList-ChainAccordionSummary-3")
	WebElement NearChain;
	
	@FindBy(id = "RenderChainsList-ChainAccordionSummary-4")
	WebElement ArouraChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-5")
	WebElement AvalancheChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-6")
	WebElement CronosChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-7")
	WebElement FantomChain;

	@FindBy(id = "RenderChainsList-ChainAccordionSummary-8")
	WebElement SolanaChain;
	
	@FindBy(id = "dashboard-totalsum")
	WebElement TotalAsset;
	
	@FindBy(id = "WalletsFilterModal-handleResetWallets")
	WebElement Resetbtn;
	
	@FindBy(id = "WalletFilterCheckbox-handleWalletChange-0")
	WebElement Wallet1Unchecked;
	
	@FindBy(xpath = "//div[@aria-label='X-MainAccount']")
	WebElement SelectMainnetAccount;
		
	@FindBy(id = "WalletsFilterModal-handleClose")
	WebElement WalletFilterCrossBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Swap')]")
	WebElement ActivitySwapCard;
	
	@FindBy(xpath = "//*[contains(text(), 'See in Explorer')]")
	WebElement ActivitySeeinExplorerBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Success')]")
	WebElement ActivitySuccessMsg;


	// Initializing the Page Objects:
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyWalletFilter(){
		return AllWalletDropdown.isDisplayed();
	}
	
	public boolean verifySettigButton(){
		return Hamburgerbtn.isDisplayed();
	}
	
	public boolean verifySendButton(){
		return Sendbtn.isDisplayed();
	}
	
	public boolean verifyReceiveButton(){
		return Recievebtn.isDisplayed();
	}
	
	public boolean verifySwapButton(){
		return Swapbtn.isDisplayed();
	}
	
	public boolean verifyTokenTab(){
		return NFTstab.isDisplayed();
	}
	
	public boolean verifyNFTsTab(){
		return Tokentab.isDisplayed();
	}
	
	public boolean verifyActivityTab(){
		return Activitytab.isDisplayed();
	}
	
	public boolean verifyEditTokenButton(){
		return EditTokenBtn.isDisplayed();
	}
	
	public boolean verifyAsset(){
		return TotalAsset.isDisplayed();
	}
	
	public boolean verifyResetButton(){
		return Resetbtn.isEnabled();
	}
	
	public void ClickOnResetButton(){
		Resetbtn.click();
	}
	
	
	public void AllWalletdropdown(){
		AllWalletDropdown.click();
	}
	
	public void UncheckedWalletone(){
		Wallet1Unchecked.click();
	}
	
	public String VerifyNetworkButton(){
		return NetworkSwitchbtn.getText();
	}
	
	public void NetworkSwitchButton(){
		NetworkSwitchbtn.click();
	}
	
	public void BinanceChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(BinanceSmartChain));
		BinanceSmartChain.click();
	}
	
	public void EtheriumChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(EthereumChain));
		EthereumChain.click();
	}
	
	public void PolygonChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(PolygonChain));
		PolygonChain.click();
	}
	
	public void NearChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(NearChain));
		NearChain.click();
	}
	
	public void ArouraChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ArouraChain));
		ArouraChain.click();
	}
	
	public void AvalancheChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(AvalancheChain));
		AvalancheChain.click();
	}
	
	public void CronosChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(CronosChain));
		CronosChain.click();
	}
	
	public void FantomChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(FantomChain));
		FantomChain.click();
	}
	
	public void SolanaChainExpand(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SolanaChain));
		SolanaChain.click();
	}
	
	public String TotalDollarAsset(){
		return TotalAsset.getText();
	}
	
	
	
	
	public SendPage clickOnSendButton(){
		Sendbtn.click();
		return new SendPage();
	}
	
	public SettingPage clickOnSettingPage(){
		Hamburgerbtn.click();
		return new SettingPage();
	}
	
	public DirectSendPage clickOnDirectSendPage(){
		Tokentab.click();
		return new DirectSendPage();
	}
	
	public SwapPage clickOnSwapButton(){
		Swapbtn.click();
		return new SwapPage();
	}
	
	public EditTokenPage clickOnEditTokenButton(){
		EditTokenBtn.click();
		return new EditTokenPage();
	}
	
	public void SelectXethAccount(){
		SelectMainnetAccount.click();
		WalletFilterCrossBtn.click();
	}
	
	public void clickSwapCard(){
		ActivitySwapCard.click();
	}
	
	public boolean verifyActivitySuccessMsg(){
		return ActivitySuccessMsg.isDisplayed();
	}
	
	public void clickSeeinExolorer(){
		ActivitySeeinExplorerBtn.click();
	}
	
//	
//	public TasksPage clickOnTasksLink(){
//		tasksLink.click();
//		return new TasksPage();
//	}
	
	
	

}
