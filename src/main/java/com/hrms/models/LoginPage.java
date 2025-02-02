package com.hrms.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement Username;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath=" //a[normalize-space()='Logout']")
	WebElement logoutbtn;
	
	@FindBy(xpath="//p[@class=\"oxd-userdropdown-name\"]")
	WebElement profilename;
	
	
	public void setUsername(String user_name) {
		Username.clear();
		Username.sendKeys(user_name);
		
	}
	
	public void setPassword(String pass_word) {
		Password.clear();  
		Password.sendKeys(pass_word);
	}
	
	public void Clicklogin() {
		loginbtn.click();
	}
	
	public void clickProfileName() {
		profilename.click();
	}
	public void ClickLogout() {
		
		logoutbtn.click();
	}
	
	
}
