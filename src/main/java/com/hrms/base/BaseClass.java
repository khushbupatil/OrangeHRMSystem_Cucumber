package com.hrms.base;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hrms.models.DeleteEmployeePage;
import com.hrms.models.LoginPage;
import com.hrms.models.PIM_AddEmployee;
import com.hrms.models.SearchEmployeePage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public static Logger logger;
	public Properties configuprop;
	public PIM_AddEmployee addEmp;
	public SearchEmployeePage searchEmpPage;
	public DeleteEmployeePage deleteEmpPage;
	
	public static String randomstring() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return (generateString);
	}
}
