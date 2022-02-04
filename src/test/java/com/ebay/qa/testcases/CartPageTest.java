package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.CartPage;
import com.ebay.qa.pages.CheckoutPage;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.SignInPage;
import com.ebay.qa.pages.WatchListPage;

public class CartPageTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	WatchListPage watchListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		signInPage = homePage.clickOnSignInLink();
		homePage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		watchListPage = homePage.watchingList();
		cartPage = watchListPage.addingToCart();
	}
	
	@Test(priority=1)
	public void cartPageTitleTest() {
		String cartPageTitle = cartPage.validateCartPageTitle();
		Assert.assertEquals(cartPageTitle, "eBay shopping cart", "CartPage title not matched");
	}
	
	@Test(priority=2)
	public void verifyGoToCheckoutTest() {
		checkoutPage = cartPage.goToCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
