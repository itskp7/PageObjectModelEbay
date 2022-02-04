package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class CheckoutPage extends TestBase{
	
	// Page Factory -OR
	
	@FindBy(xpath="//input[@id='selectable-render-summary2']")
	WebElement addNewCardRadioBtn;
	
	@FindBy(xpath="//input[@id='cardNumber']")
	WebElement cardNumberInput;
	
	@FindBy(xpath="//input[@id='cardExpiryDate']")
	WebElement cardExpiryInput;
	
	@FindBy(xpath="//input[@id='securityCode']")
	WebElement cvvInput;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")
	WebElement doneBtn;
	
	@FindBy(xpath="//span[contains(text(),'Confirm and pay')]")
	WebElement confirmAndPayBtn;
	
	//Initializing the PageFactory
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateCheckoutPageTitle() {                 
		return driver.getTitle();
	}
		
	public void addingCardAndConfirmAndPay(String cardnum, String cardexp, String cvv) {
		addNewCardRadioBtn.click();
		cardNumberInput.sendKeys(cardnum);
		cardExpiryInput.sendKeys(cardexp);
		cvvInput.sendKeys(cvv);
		doneBtn.click();
		confirmAndPayBtn.click();
	}
	
	

}
