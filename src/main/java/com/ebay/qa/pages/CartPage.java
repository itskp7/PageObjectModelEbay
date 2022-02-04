package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class CartPage extends TestBase{
	
	//Page Factory - OR
	
	@FindBy(xpath="//button[contains(text(),'Go to checkout')]")
	WebElement checkoutBtn;
	
//	@FindBy(xpath="//input[@id='selectable-render-summary2']")
//	WebElement addNewCardButton;
//	
//	@FindBy(xpath="//span[contains(text(),'Confirm and pay')]")
//	WebElement confirmAndPayBtn;
	
	//Initializing PageElements
	
	public CartPage() {
		PageFactory.initElements(driver, this); 
	}
	
	//Actions
	
	public String validateCartPageTitle() {
		return driver.getTitle();
	}
	
	public CheckoutPage goToCheckout() {
		checkoutBtn.click();
		return new CheckoutPage();
	}
	
}

