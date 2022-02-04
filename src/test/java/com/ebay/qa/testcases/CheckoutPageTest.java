package com.ebay.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CheckoutPageTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	WatchListPage watchListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public CheckoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		signInPage = homePage.clickOnSignInLink();
		homePage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		watchListPage = homePage.watchingList();
		cartPage = watchListPage.addingToCart();
		checkoutPage = cartPage.goToCheckout();
		WebDriverWait wait  = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlContains("https://pay.ebay.ca/rxo?action"));          ///GOODD 
	}
	
	@Test(priority=1)
	public void checkoutPageTitleTest() {
		String checkoutPageTitle = checkoutPage.validateCheckoutPageTitle();
		Assert.assertEquals(checkoutPageTitle, "Checkout | eBay", "CheckoutPage title not matched");
	}
	
	@Test(priority=2)
	public void endCheckoutTest() {
		checkoutPage.addingCardAndConfirmAndPay(prop.getProperty("cardnumber"), prop.getProperty("cardexpiry"), prop.getProperty("cardcvv"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
