package com.hrms.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/CRUDEmployee.feature",
		glue ="stepDefinitions",
		dryRun = false ,
		plugin= {"pretty", "html:target/test-output.html"}
		)
public class PimSectionTestrunner {

}
