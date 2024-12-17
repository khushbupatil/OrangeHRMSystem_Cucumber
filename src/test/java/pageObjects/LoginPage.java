package pageObjects;

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
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(tagName="button")
	WebElement loginbtn;
	
	@FindBy(linkText="Logout")
	WebElement logoutbtn;
	
	
	public void setEmail(String name) {
		Email.clear();
		Email.sendKeys(name);
	}
	
	public void setPassword(String pswd) {
		password.clear();
		password.sendKeys(pswd);
	}

	public void Clicklogin() {
		loginbtn.click();
	}
	
	public void ClickLogout() {
		logoutbtn.click();
	}
}
