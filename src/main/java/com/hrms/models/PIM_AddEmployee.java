package com.hrms.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM_AddEmployee {
	WebDriver driver;
	
	public PIM_AddEmployee(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li//span[normalize-space()='PIM']")
	WebElement pim;
	
	@FindBy(xpath="//a[normalize-space()='Add Employee']")
	WebElement addEmp;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	WebElement middlename;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement savebtn;
	
	public void hoverPIM() {
		pim.click();
	}
	
	public void clickAddEmployee() {
		addEmp.click();
	}
	
	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	public void setMiddleName(String mname) {
		middlename.sendKeys(mname);
	}
	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void clicksave() {
		savebtn.click();
	}
	
}

