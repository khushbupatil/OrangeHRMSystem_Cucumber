package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginSteps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
	    driver.get(url);
	    Thread.sleep(3000);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) throws InterruptedException {
	    lp.setEmail(username);
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
	   if(driver.getPageSource().contains("Login was unsuccessful.")) {
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



}
