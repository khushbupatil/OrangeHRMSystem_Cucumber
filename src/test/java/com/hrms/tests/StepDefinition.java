package com.hrms.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hrms.base.BaseClass;
import com.hrms.models.LoginPage;
import com.hrms.models.PIM_AddEmployee;
import com.hrms.models.SearchEmployeePage;
import com.hrms.utilities.ScreenshotUtility;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	public String empFullName;
	boolean status;
	String searchEmpName;
	
	@Before
	public void setup() throws IOException {
		
		//reading properties
		configuprop = new Properties();
		FileInputStream fileinput = new FileInputStream("config.properties");
		configuprop.load(fileinput);
		
		String br = configuprop.getProperty("Browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configuprop.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configuprop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configuprop.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
	}
	
	
	//Login Page
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{

		lp = new LoginPage(driver);
		
		//logger.info("User lanuchs chrome browser");
		
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException 
	{
		//logger.info("Getting application URL- "+url);
		driver.get(url);
		Thread.sleep(3000);
	}
	@When("User Enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String un, String pwd) 
	{
		lp.setUsername(un);
	    lp.setPassword(pwd);
	   // logger.info("Logging in application using "+un+" as an username and "+pwd+" as a password");
	    
	    
	}
	@When("Click on Login")
	public void click_on_login() throws InterruptedException 
	{
		lp.Clicklogin();
		Thread.sleep(5000);
		//logger.info("Clicked on Login Button");
		ScreenshotUtility screenshot = new ScreenshotUtility(driver);
		screenshot.Screenshot("Login");
	}
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) 
	{
		try
		{
		Assert.assertEquals(title, driver.getTitle());
		//logger.info("Successfully validated the Page Tile: "+title);
		}
		catch(Exception e)
		{
			System.out.println(e);
			//logger.info("Title validation failed");
		}
	}
	@When("User click on profile link")
	public void user_click_on_profile_link() 
	{
	    lp.clickProfileName();
	    //logger.info("User clicked on My Profile icon");
	}
	@When("click on Logout link")
	public void click_on_logout_link() 
	{
	    lp.ClickLogout();
	    //logger.info("logging out of an Application");
	}
	@Then("close the browser")
	public void close_the_browser()
	{
	    driver.close();
	   // logger.info("Closing browser");
	}

	//*********Add Employee************
	
	@When("User hover over PIM menu")
	public void user_hover_over_pim_menu() throws InterruptedException
	{
		addEmp = new PIM_AddEmployee(driver);
	    addEmp.hoverPIM();
	    Thread.sleep(5000);
	    
	    //logger.info("Clicked on PIM menu");
	    
	    
	}
	
	@When("clicks on Add Employee menu item")
	public void clicks_on_add_employee_menu_item() throws InterruptedException 
	{
	    addEmp.clickAddEmployee();
	    Thread.sleep(5000);
	    
	    //logger.info("Go to Add Employee workarea");
	}
	
	
	@Then("User fills info of new Employee {string} {string} {string}")
	public void user_fills_info_of_new_employee(String fName, String mName, String lName) 
	{
	    addEmp.setFirstName(fName);
	   // logger.info("Setting First Name: "+fName);
	    addEmp.setMiddleName(mName);
	   // logger.info("Setting Middle Name: "+mName);
	    addEmp.setLastname(lName);
	  //  logger.info("Setting Last Name: "+lName);
	    
	    empFullName = fName+" "+mName+" "+lName;
	}
	
	
	@Then("clicks on Save button")
	public void clicks_on_save_button() throws InterruptedException 
	{
	    addEmp.clicksave();
	    Thread.sleep(5000);
	   // logger.info("Saving info by clicking on Save button");
	}
	
	// Search Employee Steps
	
	
			@When("Clicks on Employee List menu item")
			public void clicks_on_employee_list_menu_item() 
			{
			    searchEmpPage = new SearchEmployeePage(driver);
			   // logger.info("Initiating Search Page Constructor"); 
			   // logger.info("Go to Employee list work area");
			    searchEmpPage.clickOnEmpList();
			    
			}
			
			@When("User searchs for this employee {string}")
			public void user_searchs_for_this_employee(String name) throws Exception 
			{
				Thread.sleep(3000);
				//searchEmpName = name;
			    searchEmpPage.SearchEmp(name);
			   // logger.info("Search for this employee"+searchEmpName);
			}
			
			@When("clicks on Search button")
			public void clicks_on_search_button() throws InterruptedException
			{
			    searchEmpPage.ClickSearch();
			    Thread.sleep(5000);
			    //logger.info("User clicks on Search button and initiates DeletePage constructor");
			    
			}
			
			@Then("it displays results")
			public void it_displays_results() throws InterruptedException
			{
				Thread.sleep(5000);
				try {
					 boolean status = driver.getPageSource().contains("John");
					 Assert.assertTrue(status);
			  //  logger.info("Employee "+empFullName+" found in database");
			  //  logger.info("Search Employee test passed");
				}
				catch(NoSuchElementException e)
				{
				//	logger.info("There is no Employee "+searchEmpName+" present in application");
				//	logger.info("Search Employee test failed");
					driver.close();
					System.out.println(e);
				}
				
			}

			
			// Delete Employee steps
			
			
			@When("User clicks on select all")
			public void user_clicks_on_select_all() throws InterruptedException 
			{
				Thread.sleep(3000);
				//logger.info("Deleting employee "+empFullName);
				deleteEmpPage.clickSelectAll();
				Thread.sleep(3000);  
			   // logger.info("Clicked on Select All control");
			}
			
			@When("clicks on delete button")
			public void clicks_on_delete_button() throws InterruptedException
			{
			    deleteEmpPage.clickOnDelBtn();
			    Thread.sleep(5000);
			 //   logger.info("Clicked on Delete button");
			}
			
			@Then("confirmation pop up will appear")
			public void confirmation_pop_up_will_appear() throws InterruptedException
			{
				Thread.sleep(2000);
			    deleteEmpPage.handlePopUp();
			    Thread.sleep(5000);
			  //  logger.info("Confirmation pop up");
			}
		}
