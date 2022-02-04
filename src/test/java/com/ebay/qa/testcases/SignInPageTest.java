package com.ebay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.SignInPage;

public class SignInPageTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();                              // THIS IS IMPORTANT THINK IT
		signInPage = homePage.clickOnSignInLink();            //bcz of this line no need of   signInPage = new SignInPage();  
            
	}
	
	@Test(priority=1)
	public void signInPageTitleTest() {
		String signInPageTitle = signInPage.validateSignInPageTitle();
		Assert.assertEquals(signInPageTitle, "Sign in or Register | eBay", "SignIn page title not matched");
	}
	
	@Test(priority=2)
	public void signInTest() {
		homePage = signInPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
