package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.CartPage;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.SignInPage;
import com.ebay.qa.pages.WatchListPage;

public class WatchListPageTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	WatchListPage watchListPage;
	CartPage cartPage;
	
	public WatchListPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
//		signInPage = new SignInPage();           //this and below two added later 
//		watchListPage =new WatchListPage();
//		cartPage = new CartPage();
		signInPage = homePage.clickOnSignInLink();
		homePage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		watchListPage = homePage.watchingList();
	}
	
	@Test(priority=1)
	public void watchListPageTitleTest() {
		String watchListPageTitle = watchListPage.validateWatchListPageTitle();
		Assert.assertEquals(watchListPageTitle, "My eBay - Watchlist", "WatchListPage title not matched");
	}
	
	@Test(priority=2)
	public void addingToCartTest() {
		cartPage = watchListPage.addingToCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	
	
	
	
	
	

}
