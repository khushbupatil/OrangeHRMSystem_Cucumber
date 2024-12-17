Feature: Login

Scenario: Successful Login with Valid Credentials
	Given user Launch Chrome Browser
	When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	And User enters username as "Admin" and Password as "admin123"
	And Click on login
	Then Page title should be "OrangeHRM"
	When User click on log out link
	Then Page title should be "OrangeHRM"
	And close browser
	
	