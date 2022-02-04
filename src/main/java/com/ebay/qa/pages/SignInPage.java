package com.ebay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.qa.base.TestBase;

public class SignInPage extends TestBase{
	
	// Page Factory - OR
	@FindBy(id="userid")
	WebElement email;
	
	@FindBy(id="signin-continue-btn")
	WebElement continueBtn;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="sgnBt")
	WebElement signInBtn;
	
//	@FindBy(xpath="//h1[text()='Hello']")
//	WebElement helloText;
	
	// Initializing 
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateSignInPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage signIn(String usn, String pwd) {     // email is username
		 email.sendKeys(usn);
		 continueBtn.click();
		 password.sendKeys(pwd);
		 signInBtn.click();
		 return new HomePage();
	}
	

	
//	public boolean validateHelloText() {
//		return helloText.isDisplayed();
//	}
	
	
	
	
	
	
	
	
	
	
	

}
