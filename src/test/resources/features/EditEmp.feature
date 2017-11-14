@Edit
Feature: Edit employee


  Scenario: check for edit button is disabled in home page
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I take screenshot
    Then I assert element having id "bEdit" and has class "disabled" should be present


  Scenario: check for edit button gets enabled when employee from list is selected in home page
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    When I click on repeater element having repeater "employee in employees"
    Then element having id "bEdit" should be enabled


  Scenario Outline: Check for all field in a employee form have vaild data when edit button is clicked
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I click on repeater element having repeater "employee in employees"
    Then I click on element having id "bEdit"
    Then I assert element having model "<firstname_value>" and has class "<valid_class_name>" should be present
    Then I assert element having model "<lastname_value>" and has class "<valid_class_name>" should be present
    Then I assert element having model "<startdate_value>" and has class "<valid_class_name>" should be present
    Then I assert element having model "<email_value>" and has class "<valid_class_name>" should be present
    Then element having buttonText "Update" should be present
    Then element having buttonText "Update" should be enabled
    Then element having <button_type> "<button_value>" should be present
    Then element having <button_type> "<button_value>" should be enabled
  Examples:
      |firstname_value|lastname_value|startdate_value|email_value|valid_class_name|button_type|button_value|
      |selectedEmployee.firstName|selectedEmployee.lastName|selectedEmployee.startDate |selectedEmployee.email |ng-valid-required|xpath|//p[contains(text(),'Delete')]|


  Scenario Outline: check for first name field is editable and updated correctly
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
    Then I click on repeater element having text "employee in employees" should "<emp_full_name>" be clicked
    When I click on element having id "bEdit"
    Then I clear input field having <firstname_type> "<firstname_value>"
    And I enter "<firstname_new>" into input field having <firstname_type> "<firstname_value>"
    When I click on element having buttonText "Update"
    Then I assert repeater element having "employee in employees" should "<new_emp_name>" have text present

    Examples:
      |firstname|firstname_new|new_emp_name|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|emp_full_name|
      |Saujanya |Solmin     |Solmin kumar  |model          |selectedEmployee.firstName|kumar|model|selectedEmployee.lastName|2011-11-21|model |selectedEmployee.startDate|saujanya_kumar@gmail.com|model|selectedEmployee.email|Saujanya kumar|


  Scenario Outline: check for lastname field is editable and updated correctly
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
    Then I click on repeater element having text "employee in employees" should "<emp_full_name>" be clicked
    When I click on element having id "bEdit"
    Then I take screenshot
    Then I clear input field having <lastname_type> "<lastname_value>"
    And I enter "<lastname_new>" into input field having <lastname_type> "<lastname_value>"
    When I click on element having buttonText "Update"
    Then I scroll to bottom of page
    Then I assert repeater element having "employee in employees" should "<new_emp_name>" have text present

    Examples:
      |firstname|lastname_new|new_emp_name|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|emp_full_name|
      |Gaujanya |renold     |Gaujanya renold  |model          |selectedEmployee.firstName|kumar|model|selectedEmployee.lastName|2011-11-21|model |selectedEmployee.startDate|gaujanya_kumar@gmail.com|model|selectedEmployee.email|Gaujanya kumar|

  Scenario Outline: check for employee startdate get updated successfully if new startdate is valid
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I click on repeater element having repeater "employee in employees"
    Then I click on element having id "bEdit"
    Then I clear input field having <startdate_type> "<startdate_value>"
    And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
    Then I assert element having model "<startdate_value>" and has class "<valid_class_name>" should be present
    Then I click on element having buttonText "Update"
    Examples:
    |valid_class_name|startdate|startdate_type|startdate_value|
    |ng-valid-pattern|2017-12-22|model |selectedEmployee.startDate|

  Scenario Outline: check for validation error if new start date is invalid
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I click on repeater element having repeater "employee in employees"
    Then I click on element having id "bEdit"
    Then I clear input field having <startdate_type> "<startdate_value>"
    And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
    Then I assert element having model "<startdate_value>" and has class "<valid_class_name>" should be present

    Examples:
      |valid_class_name|startdate|startdate_type|startdate_value|
      |ng-invalid-pattern|20171222|model |selectedEmployee.startDate|

  Scenario Outline: check for employee email details get updated successfully if new email is valid
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I click on repeater element having repeater "employee in employees"
    Then I click on element having id "bEdit"
    Then I clear input field having <email_type> "<email_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    Then I assert element having <email_type> "<email_value>" and has class "<valid_class_name>" should be present
    Then I click on element having buttonText "Update"
    Examples:
      |email|email_type|email_value|valid_class_name|
      |newtest@hotmail.com     |model|selectedEmployee.email|ng-valid-email|

  Scenario Outline: check for validation failure if employee email details are incorrect during update
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I click on repeater element having repeater "employee in employees"
    Then I click on element having id "bEdit"
    Then I clear input field having <email_type> "<email_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    Then I assert element having <email_type> "<email_value>" and has class "<valid_class_name>" should be present
    Then I click on element having buttonText "Update"
    Examples:
      |email|email_type|email_value|valid_class_name|
      |newhotmail.com     |model|selectedEmployee.email|ng-invalid-email|
