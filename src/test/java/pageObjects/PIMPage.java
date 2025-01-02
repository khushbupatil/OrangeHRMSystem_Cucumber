package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {

	WebDriver ldriver;

	public PIMPage(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a//span[normalize-space()='PIM'] ")
	WebElement PIMOption;
	
	@FindBy(xpath ="//h6[normalize-space()='PIM']")
	WebElement VerifypimPage;
	
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")
	WebElement ConfigurationDropdown;
	
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")
	WebElement Dropdownavailability;
	
	
	@FindBy(xpath="//li//a[normalize-space()='Optional Fields']")
	WebElement OptionalFieldsoption;
	@FindBy(xpath="//li//a[normalize-space()='Custom Fields']")
	WebElement CustomFieldsoption;
	@FindBy(xpath="//li//a[normalize-space()='Data Import']']")
	WebElement DataImportsoption;
	@FindBy(xpath="//li//a[normalize-space()='Reporting Methods']")
	WebElement ReportingMethodsoption;
	@FindBy(xpath="//li//a[normalize-space()='Termination Reasons']")
	WebElement TerminationReasonsoption;
	
	public void clickPIMOption() {
		PIMOption.click();
	}
	
	public void clickConfigurationDropdown() {
		ConfigurationDropdown.click();
	}
	public void clickOptionalFieldsoption() {
		OptionalFieldsoption.click();
	}
	public void clickCustomFieldsoption() {
		CustomFieldsoption.click();
	}
	public void clickDataImportsoption() {
		DataImportsoption.click();
	}
	public void clickReportingMethodsoption() {
		ReportingMethodsoption.click();
	}
	public void clickTerminationReasonsoption() {
		TerminationReasonsoption.click();
	}
	public String VerifyPIMPage() {
		String verifypimpage =VerifypimPage.getText();
		return verifypimpage;
	}
	
	public boolean checkDropdownavailability() {
		if(Dropdownavailability.isDisplayed()) {
			System.out.println("Dropdown is available");
		}
		return true;
	}
}
