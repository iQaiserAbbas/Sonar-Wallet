package com.sonarwallet.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sonarwallet.qa.base.TestBase;
import com.sonarwallet.qa.pages.Dashboard;
import com.sonarwallet.qa.pages.ImportWallet;
import com.sonarwallet.qa.pages.ManageWallet;
import com.sonarwallet.qa.pages.SettingsPage;
import com.sonarwallet.qa.pages.SwapPage;

public class SwapTest extends TestBase {

	ImportWallet importWallet;
	Dashboard dashboard;
	SwapPage swapPage;
	ManageWallet managewallet;
	SettingsPage settingpage;

	public SwapTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		initialization();
		// testUtils = new TestUtils();
		swapPage = new SwapPage();
		importWallet = new ImportWallet();
		managewallet = new ManageWallet();
		settingpage = new SettingsPage();

		dashboard = importWallet.ImportWalletToDashboard(prop.getProperty("Password"),
				prop.getProperty("ConfirmPassword"));
		Thread.sleep(5000);

		// Import wallet
		settingpage.ClickResetLocalNodeButton();
		Thread.sleep(2000);
		settingpage.clickOnManageWallet();
		managewallet.ClickonWallet1();
		managewallet.ClickOnImportAccountMainbutton();
		managewallet.EnterPrivateKeyinImportAccountField(prop.getProperty("ForkedPvtKey"));
		managewallet.ClickOnImportbutton();
		managewallet.ClearAccountNameField();
		managewallet.EditAccountNameField("X-MainAccount");
		managewallet.ClickOnOkbutton();
		driver.findElement(By.xpath("//*[ contains (text(),'Ok')]")).click();
		Thread.sleep(15000);
		dashboard.AllWalletdropdown();
		Thread.sleep(2000);
		dashboard.SelectXethAccount();

		// For testing on testnet, uncomment the below three lines
//			dashboard.AllWalletdropdown();
//			dashboard.NetworkSwitchButton();
//			Thread.sleep(5000);

		swapPage = dashboard.clickOnSwapButton();

	}

	@Test(priority = 21, groups = "Regression", description = ("Test Case Description: Swap token"))
	public void TestCase24() throws InterruptedException {
		Thread.sleep(5000);
		swapPage.ClickOnSelectSpendTokenDropdown();
		swapPage.TokenSearchField("MATIC");
		swapPage.ClickOnPolygonToken();
		swapPage.ClickOnSelectRecieveTokenDropdown();
		swapPage.TokenSearchField("USDT");
		swapPage.ClickOnPolygonToken();
		Thread.sleep(5000);
		swapPage.EnterValuefield("1000");
		Thread.sleep(5000);
		driver.findElement(By.id("swap-error-text")).isDisplayed();
		Thread.sleep(5000);
		swapPage.ClearValuefield();
		Thread.sleep(5000);
		swapPage.ClickOn50percent();
		Thread.sleep(5000);
		Thread.sleep(5000);
		swapPage.ClearValuefield();
		Thread.sleep(5000);
		swapPage.ClickOn25percent();
		Thread.sleep(5000);
		Thread.sleep(5000);
		swapPage.ClearValuefield();
		swapPage.EnterValuefield("0.001");
		Thread.sleep(5000);
		swapPage.ClickOnEditButton();
		swapPage.ClickOnResetButton();
		swapPage.ClickOnRejectButton();
		Thread.sleep(5000);
		swapPage.ClickOnSwapButton();
		swapPage.ClickOnSelectSpendTokenDropdown();
		swapPage.TokenSearchField("Matic");
		swapPage.ClickOnPolygonToken();
		swapPage.ClickOnSelectRecieveTokenDropdown();
		swapPage.TokenSearchField("USDC");
		swapPage.ClickOnPolygonToken();
		Thread.sleep(5000);
		swapPage.EnterValuefield("0.001");
		Thread.sleep(5000);
		swapPage.ClickOnRejectButton();
		swapPage.ClickOnActivityButton();
		Thread.sleep(2000);
	}

	/*
	 * Start of Ethereum Forked Chain Swap Cases
	 */
	/*
	@Test(priority = 1, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/USDT token"))
	public void ethETH_USDT() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "USDT");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 2, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/PING token"))
	public void ethETH_PING() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "ePING");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 3, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/DAI token"))
	public void ethETH_DAI() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "DAI Stablecoin");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 4, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked USDT/USDC token"))
	public void ethUSDT_USDC() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Tether USD", "USDC");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 5, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/sETH2 token"))
	public void ethETH_sETH2() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "sETH2");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 6, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/UNI token"))
	public void ethETH_UNI() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "Uniswap");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 7, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/LDO token"))
	public void ethETH_LDO() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "Lido DAO");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 8, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/MATIC token"))
	public void ethETH_MATIC() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "Matic");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 9, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/FRAX token"))
	public void ethETH_FRAX() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "FRAX");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 10, groups = "Regression", description = ("Test Case Description: Swap Ethereum Forked ETH/RPL token"))
	public void ethETH_RPL() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.EthereumSwap("Ethereum", "0xD33526068D116cE69F19A9ee46F0bd304F21A51f");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	*/
	/*
	 * End of Ethereum Forked Chain Swap Cases
	 */

	/*
	 * Start of Binance Forked Chain Swap Cases
	 */
	@Test(priority = 11, groups = "Regression", description = ("Test Case Description: Swap BSC Forked BNB/CAKE token"))
	public void bscBNB_CAKE() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("BNB", "Pancakeswap Token");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	@Test(priority = 12, groups = "Regression", description = ("Test Case Description: Swap BSC Forked BNB/PING token"))
	public void bscBNB_PING() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("BNB", "PING");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 13, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/BNB token"))
	public void bscPING_BNB() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "BNB");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 14, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/BUSD token"))
	public void bscPING_BUSD() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "Binance USD");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 15, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/ETH token"))
	public void bscPING_ETH() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "Ethereum Token");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 16, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/BAT token"))
	public void bscPING_BAT() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "Basic Attention Token");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 17, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/DOGE token"))
	public void bscPING_DOGE() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "0xba2ae424d960c26247dd6c32edc70b295c744c43");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 18, groups = "Regression", description = ("Test Case Description: Swap BSC Forked BUSD/BabyFloki token"))
	public void bscBUSD_BabyFloki() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("Binance USD", "0x71e80e96af604afc23ca2aed4c1c7466db6dd0c4");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 19, groups = "Regression", description = ("Test Case Description: Swap BSC Forked PING/SHIB token"))
	public void bscPING_SHIB() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("PING", "0x2859e4544c4bb03966803b044a93563bd2d0dd4d");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}
	
	@Test(priority = 20, groups = "Regression", description = ("Test Case Description: Swap BSC Forked BNB/USDT token"))
	public void bscBNB_USDT() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		swapPage.BinanceSwap("BNB", "Tether USD");
		softassert.assertTrue(swapPage.VerifySwappingModal());
		Thread.sleep(30000);
		swapPage.ClickOnActivityButton();
		dashboard.clickSwapCard();
		softassert.assertTrue(dashboard.verifyActivitySuccessMsg());
		Thread.sleep(3000);
		dashboard.clickSeeinExolorer();
		Thread.sleep(10000);
		softassert.assertAll();
	}

	/*
	 * End of Ethereum Forked Chain Swap Cases
	 */

	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
