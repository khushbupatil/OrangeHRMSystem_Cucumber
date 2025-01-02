Feature: Scenarios related to Employee

  Background: Background steps
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And User Enters username as "Admin" and Password as "admin123"
    And Click on Login

  @AddEmp
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
