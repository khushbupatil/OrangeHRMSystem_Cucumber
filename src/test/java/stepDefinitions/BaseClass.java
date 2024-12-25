package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public static Logger logger;
	public Properties configuprop;
	
	
	public static String randomstring() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return (generateString);
	}
}
