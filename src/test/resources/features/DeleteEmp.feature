@Delete
Feature: Delete employee

  Scenario: check for delete button is disabled in home page
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I take screenshot
    Then I assert element having id "bDelete" and has class "disabled" should be present


  Scenario: check for delete button gets enabled when employee from list is selected in home page
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    When I click on repeater element having repeater "employee in employees"
    Then element having id "bDelete" should be enabled

  Scenario Outline: check for validation alert pop if existing employee is selected to delete  ,employee gets deleted from homepage if alert is accepted
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 15 ms for element having id "bAdd" to be enabled
    When I click on element having id "bAdd"
    Then I wait 5 ms for element having buttonText "Add" to display
    And I enter "<firstname>" into input field having <firstname_type> "<firstname_value>"
    And I enter "<lastname>" into input field having <lastname_type> "<lastname_value>"
    And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    When I click on element having buttonText "Add"
    Then I scroll to bottom of page
    Then I assert repeater element having "employee in employees" should "<emp_full_name>" have text present
    Then I click on repeater element having text "employee in employees" should "<emp_full_name>" be clicked
    Then I take screenshot
    When I click on element having id "bDelete"
    Then I take screenshot
    Then I assert message from alert should be "<alert_message>" and accept alert
    Then I wait for 5 sec
    Then element having xpath "<repeater_path>" should not be present
  Examples:
    |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|emp_full_name|repeater_path|alert_message|
    |Malenagola123 |model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|2011-11-21|model |selectedEmployee.startDate|Malenawalner@gmail.com|model|selectedEmployee.email|Malenagola123 walner|.//*[@id='employee-list']/li[contains(text(),'Malenagola123 walner')]|Are you sure you want to delete|

  Scenario Outline: check for validation alert pop if existing employee is selected to delete  ,employee not deleted from homepage if alert is dismiss
  Given I am in app homepage
  And I enter "Luke" into input field having model "user.name"
  And I enter "Skywalker" into input field having model "user.password"
  When I click on element having buttonText "Login"
  Then I wait 15 ms for element having id "bAdd" to be enabled
  When I click on element having id "bAdd"
  Then I wait 5 ms for element having buttonText "Add" to display
  And I enter "<firstname>" into input field having <firstname_type> "<firstname_value>"
  And I enter "<lastname>" into input field having <lastname_type> "<lastname_value>"
  And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
  And I enter "<email>" into input field having <email_type> "<email_value>"
  When I click on element having buttonText "Add"
  Then I scroll to bottom of page
  Then I assert repeater element having "employee in employees" should "<emp_full_name>" have text present
  Then I click on repeater element having text "employee in employees" should "<emp_full_name>" be clicked
  Then I take screenshot
  When I click on element having id "bDelete"
  Then I take screenshot
  Then I assert message from alert should be "<alert_message>" and dismiss alert
  Then I wait for 5 sec
  Then element having xpath "<repeater_path>" should be present
  Examples:
    |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|emp_full_name|repeater_path|alert_message|
    |Harrydone |model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|2011-11-21|model |selectedEmployee.startDate|Harrydone@gmail.com|model|selectedEmployee.email|Harrydone walner|.//*[@id='employee-list']/li[contains(text(),'Harrydone walner')]|Are you sure you want to delete|

