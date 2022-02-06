package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// Page Factory - Object Repository
	@FindBy(id="gh-ac")
	@CacheLookup
	WebElement searchBar;
	
	@FindBy(id="gh-cat")
	WebElement allCategoriesDropdown;
	
	@FindBy(id="gh-btn")
	WebElement searchBtn;
	
	@FindBy(xpath="//a[@title='Watch List']")
	WebElement watchListLink;
	
	@FindBy(xpath="//span[@id='gh-ug']//a[text()='Sign in']")
	WebElement signInLink;
	
	@FindBy(id="gh-logo")
	WebElement ebayLogo;
	
	@FindBy(xpath="//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Fashion')]")
	WebElement fashionLink;
	
	@FindBy(linkText="Women's Clothing")                                                        // SEE locator
	WebElement womensClothingLink;
	
	@FindBy(xpath="//div[@class='rvi__title']")                     // ADDED LATER FOR WATCHLISTPage TEST ////span[text()='View all items you are watching']
	WebElement viewAllItemslink;
	
	@FindBy(xpath="//b[contains(text(),'Krunal')]")                          // comes after logging in
	WebElement userNameLabel;
	
	//@FindBy(xpath="//a[contains(text(),'sign in')]")
	//WebElement signInLinkInWatchList;
	
	
	// Constructor for initializing the Page Factory
	public HomePage() {     
		PageFactory.initElements(driver, this);                  //or instead of "this"  we can also write "HomePage.class"
	}
	
	// Actions:
	public String validateHomePageTitle() {                    // was public void but bcz getTitle returns string
		return driver.getTitle();
	}
	
	public boolean validateEbayImage() {
		return ebayLogo.isDisplayed();
	}
	
	public SignInPage clickOnSignInLink() {
		signInLink.click();
		return new SignInPage();
	}
	
	public void drpDownSelection() {                                 //DROPDOWN using "Select" class
		Select se = new Select(allCategoriesDropdown);
		se.selectByVisibleText("Cell Phones & Accessories");
	}
	
	public SearchedPage searchProduct(String xyz) {
		searchBar.sendKeys(xyz);
		searchBtn.click();
		return new SearchedPage();
	}
	
	public WatchListPage watchingList() {
		watchListLink.click();
	    viewAllItemslink.click();
	    return new WatchListPage();
	}
	
	public WomensClothingPage mouseHover() {                          // Mouse HOVER using "Actions" class
		Actions act = new Actions(driver);
		act.moveToElement(fashionLink).build().perform();             // can put thread.sleep
		act.moveToElement(womensClothingLink).click();                // will return womens clothing page
		return new WomensClothingPage();
	}
	
	public boolean verifyingUserNameLabelAfterLogin() {               // after logging in
		return userNameLabel.isDisplayed();
	}
	
	public void gitTestingMethod() {
		System.out.println("GIT");
		System.out.println("2nd time");
	}

}
