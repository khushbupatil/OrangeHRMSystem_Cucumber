Feature: Scenarios related to Employee

  Background: Background steps
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login
	
	@SmokeTest
  Scenario Outline: Add new Employee
    When User hover over PIM menu
    And clicks on Add Employee menu item
    Then User fills info of new Employee <First name> <Middle name> <Last name>
    And clicks on Save button
    Then close the browser

    Examples: 
      | First name | Middle name | Last name |
      | "Damu"     | "Damu"      | "Damu"    |
      | "Pooja"    | "Pooja"     | "Pooja"   |


  Scenario Outline: Search for a given employee
    When User hover over PIM menu
    And Clicks on Employee List menu item
    When User searchs for this employee <Employee name>
    And clicks on Search button
    Then it displays results
    Then close the browser

    Examples: 
      | Employee name |
      | "John"       |


  Scenario Outline: Search for a given employee
    When User hover over PIM menu
    And Clicks on Employee List menu item
    When User searchs for this employee <Employee name>
    And clicks on Search button
    Then it displays results
    When User clicks on select all
    And clicks on delete button
    Then confirmation pop up will appear
    Then close the browser

    Examples: 
      | Employee name |
      | "John" |
