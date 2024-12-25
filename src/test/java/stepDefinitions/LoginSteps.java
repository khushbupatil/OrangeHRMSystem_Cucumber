package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginSteps extends BaseClass {
	
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
	
	
	@Given("user Launch Chrome Browser")
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
