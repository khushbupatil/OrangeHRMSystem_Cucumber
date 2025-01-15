package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmployeePage {
	

		WebDriver driver;
		DeleteEmployeePage deleteEmpPage;
		
		public SearchEmployeePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[normalize-space()='Employee List']")
		WebElement EmployeeList;
		
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
		WebElement searchEmpName;
		
		@FindBy(xpath="//button[normalize-space()='Search']")
		WebElement searchbtn;
		
		public void clickOnEmpList()
		{
			EmployeeList.click();			
		}
		public void SearchEmp(String empname) {
			searchEmpName.sendKeys(empname);
		}
		
		public void ClickSearch() {
			searchbtn.click();
		}
		
		
		/*public void setEmpName(String txt)
		{
			searchEmpName.clear();
			searchEmpName.click();
			Actions actions = new Actions(driver);
			actions.sendKeys(searchEmpName, txt).perform();
//			TestUtil.sendKeys(driver, searchEmpName, txt);
		}
			
		public void clickOnEmpList()
		{
			
			TestUtil.JSClick(driver, empList);
			
		}
		public DeleteEmployeePage clickOnSearchBtn()
		{
			
			return new DeleteEmployeePage(driver);
		}
		*/

	
}
