package com.jamcracker.testcases.marketplace;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jamcracker.commonFunctions.marketplace.MarketplaceLogin;
import com.jamcracker.commonFunctions.marketplace.ResellService;
import com.jamcracker.objectRepository.store.MarketplacePage;
import com.jamcracker.utilities.TestBase;
@Listeners(com.jamcracker.listeners.TestListener.class)

public class TC007ResellService extends TestBase {
	
	private String getURL() 
	{
		return getData("TestData.xls", "URLSheet", "URL", 3);
	}


	
	@BeforeMethod
	@Parameters({"browser","targetMpUrl"})
	public void setUp(String browser,String url)
	{
		init(browser, url);
	}
	
	@DataProvider(name="resellData")
	private String[][] getResellData()
	{
		return getData("TestData.xls","ServiceResellSheet");

	}

	
	
	@Test(dataProvider="resellData")
	public void tc007resellService(String serviceName,String offerName,String retailPrice){
		String resellerAdminEmail =  getData("TestData.xls", "CredentialsSheet", "Email Address", 5);
		String resellerAdminPassword =  getData("TestData.xls", "CredentialsSheet", "Password", 5);
		MarketplaceLogin objMarketplacLogin = new MarketplaceLogin();
		objMarketplacLogin.login(resellerAdminEmail, resellerAdminPassword);
		MarketplacePage objMarketplacePage = new MarketplacePage();
		objMarketplacePage.marketplaceLink.click();
		ResellService objResell = new ResellService();
		objResell.resellService(serviceName,offerName,retailPrice);
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		getDriver().quit();
	}
	
	
}
