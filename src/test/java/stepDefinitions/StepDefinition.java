package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.PIM_AddEmployee;

public class StepDefinition extends BaseClass {
	
	public String empFullName;
	boolean status;
	
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
	
	
	/*@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		lp = new LoginPage(driver);		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
	    driver.get(url);
	    Thread.sleep(3000);
	}

	@When("User enters username as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) throws InterruptedException {
	    lp.setUsername(username);
	    lp.setPassword(password);
	    Thread.sleep(3000);
	}

	@When("Click on login")
	public void click_on_login() throws InterruptedException {
	   lp.Clicklogin();
	   Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		//WebElement msg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		//if(msg.getText().equals("Invalid credentials"))
		if(driver.getPageSource().contains("Invalid credentials"))
		{
		   driver.close();
		   Assert.assertTrue(false);
	   }
	   else {
		   Assert.assertEquals(title, driver.getTitle());
	   }
	   Thread.sleep(3000);
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	    lp.ClickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	   driver.quit();
	}
	*/
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
	public void clicks_on_save_button() 
	{
	    addEmp.clicksave();
	   // logger.info("Saving info by clicking on Save button");
	}
	
	
	/*@Then("User is added successfully")
	public void user_is_added_successfully() 
	{
	    boolean status = driver.getPageSource().contains(empFullName);
	    
	    try
	    {
	    Assert.assertTrue(status);
	   // logger.info(empFullName+" employee is added successfully");
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    	//logger.info(empFullName+" employee is not added");
	    }
	    
	    
	}*/
	



}
