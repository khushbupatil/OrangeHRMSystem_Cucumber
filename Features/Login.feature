Feature: Login

Scenario: Successful Login with Valid Credentials
	Given user Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page title should be "Your store. Login"
	And close browser
	
	Scenario Outline: Successful Login with multiple Credentials
	Given user Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on log out link
	Then Page title should be "Your store. Login"
	And close browser
	Examples:
		|email|password|
		|admin@yourstore.com|admin|
		|admin@yoursre.com|admi|
	