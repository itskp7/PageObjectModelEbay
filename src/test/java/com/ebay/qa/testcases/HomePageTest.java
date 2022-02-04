package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.SearchedPage;
import com.ebay.qa.pages.SignInPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	SearchedPage searchedPage;                 // GOOD created bcz "searchTest()" method will return "searchedPage"
	SignInPage signInPage;
	
	public HomePageTest() {
		super();                               // super keyword calls superclass constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();                     // bcz we have called super class constructor it wont give nullpointerexception as properties are definedby calling testbase constructor 
		homePage = new HomePage();             // created a object of homepage class and we'll define the homepage variable at class level	                                    
		signInPage = new SignInPage();         // if we dont will give null pointer exception, so we have to load it first and then we can use its methods
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay", "HomePage title not matched" );  // last part will be displayed only if test fails
	}
	
	@Test(priority=2)
	public void ebayLogoTest() {
		boolean flag = homePage.validateEbayImage();
		Assert.assertTrue(flag);
	}
	
//	@DataProvider
//	public void getEbayTestData() {
//		
//	}
	
	@Test(priority=3)
	public void searchTest() {
		searchedPage = homePage.searchProduct("iphone");           // bcz this method will return searchedpage so searchedPage class object created 
	}
	
	@Test(priority=4)                                              // GOOD DONE LATER (will work only after logging/signing in so logged in)
	public void userNameLabelTest() {
		homePage.clickOnSignInLink();
		signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag = homePage.verifyingUserNameLabelAfterLogin();
		Assert.assertTrue(flag, "UserName Label is not Krunal");
	}

	
	

	/*	
	@Test(priority=1)
	public void mouseHoverTest() throws InterruptedException {
		homePage.mouseHover();
	}*/
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
