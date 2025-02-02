package com.hrms.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmployeePage {

		WebDriver driver;
		
		public DeleteEmployeePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[@role='columnheader']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
		WebElement selectAll;
		
		@FindBy(xpath="//button[normalize-space()='Delete Selected']")
		WebElement deleteAll;
		
		@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
		WebElement popUpYesDeleteBtn;
		
		public void clickSelectAll()
		{
			selectAll.click();
		}
		
		public void clickOnDelBtn()
		{
			deleteAll.click();
		}
		
		public void handlePopUp()
		{
			popUpYesDeleteBtn.click();
		}
		
	/*	public void clickOnDelBtn()
		{
			TestUtil.JSClick(driver, deleteBtn);
		}
		
		public void handlePopUp()
		{
			
			TestUtil.JSClick(driver, popUpOkBtn);
			
		}*/
		
		
}
