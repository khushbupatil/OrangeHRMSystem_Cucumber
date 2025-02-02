package com.hrms.testrunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=".//Features/CRUDEmployee.feature",
		glue ="com.hrms.tests",
	    plugin = {
	        "pretty",  // Pretty print
	        "html:target/cucumber-reports.html",  // HTML report
	        "json:target/cucumber-reports/Cucumber.json" // JSON report
	    },
	    monochrome = true,  // Readable console output
	    tags = "@SmokeTest"  // You can run tests with specific tags
	)
	
	  
public class CucumberTestngTestrunner extends AbstractTestNGCucumberTests {
	 @Test
	    public void runCucumber() {
	        // This will run the Cucumber tests with TestNG
	    }

}
