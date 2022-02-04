package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class WatchListPage extends TestBase{
	
	// Page Objects - OR
	
	@FindBy(xpath="//b[contains(text(),'Krunal')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[@id='selected-list']")
	WebElement watchListText;
	
	@FindBy(xpath="//span[@class='checkbox checkbox__custom-control checkbox__control item-checkbox']//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//a[@role='button' and @class='default secondary fake-btn fake-btn--none fake-btn--secondary']")
	WebElement addToCartBtn;
	
	// Initializing page factory
	
	public WatchListPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String validateWatchListPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatingUserNameLabel() {                            //DOUBT
		return userNameLabel.isDisplayed();
	}
	
	public CartPage addingToCart() {
		checkBox.click();
		addToCartBtn.click();
		return new CartPage();
	}
}
