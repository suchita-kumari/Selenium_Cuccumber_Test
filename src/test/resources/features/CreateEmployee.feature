@Create
Feature: Create employee

  Scenario: Check for create button is enabled in homepage
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 10 ms for element having id "bAdd" to be enabled

  Scenario Outline: Check for all fields appeared when create button is clicked
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 20 ms for element having id "bAdd" to be enabled
    When I click on element having id "bAdd"
    Then element having <firstname_type> "<firstname_value>" should be present
    Then element having <lastname_type> "<lastname_value>" should be present
    Then element having <startdate_type> "<startdate_value>" should be present
    Then element having <email_type> "<email_value>" should be present

  Examples:
      |firstname_type|firstname_value|lastname_type|lastname_value|startdate_type|startdate_value|email_type|email_value|
      |model          |selectedEmployee.firstName        |model               |selectedEmployee.lastName         |model        |selectedEmployee.startDate |model|selectedEmployee.email |

  Scenario Outline: check for validation error if first name is not entered and add button is clicked
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 15 ms for element having id "bAdd" to be enabled
    When I click on element having id "bAdd"
    Then I wait 5 ms for element having buttonText "Add" to display
    And I enter "<lastname>" into input field having <lastname_type> "<lastname_value>"
    And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    When I click on element having buttonText "Add"
    Then I wait 10 ms for element having <blank_login_access_type> "<blank_login_access_value>" to display

    Examples:
      |lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|blank_login_access_type|blank_login_access_value|
      |walner|model          |selectedEmployee.lastName|2017-11-11|model|selectedEmployee.startDate|steve.walner@gmail.com|model|selectedEmployee.email|css            |.ng-pristine.ng-invalid.ng-invalid-required|

  Scenario Outline: check for validation error if last name is not entered and add button is clicked
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 15 ms for element having id "bAdd" to be enabled
    When I click on element having id "bAdd"
    Then I wait 5 ms for element having buttonText "Add" to display
    And I enter "<firstname>" into input field having <firstname_type> "<firstname_value>"
    And I enter "<startdate>" into input field having <startdate_type> "<startdate_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    When I click on element having buttonText "Add"
    Then I wait 10 ms for element having <blank_login_access_type> "<blank_login_access_value>" to display

    Examples:
      |firstname|firstname_type|firstname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|blank_login_access_type|blank_login_access_value|
      |Steve|model          |selectedEmployee.firstName|2017-11-11|model|selectedEmployee.startDate|steve.walner@gmail.com|model|selectedEmployee.email|css            |.ng-pristine.ng-invalid.ng-invalid-required|

  Scenario Outline: check for validation error if start date is not entered and add button is clicked
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 15 ms for element having id "bAdd" to be enabled
    When I click on element having id "bAdd"
    Then I wait 5 ms for element having buttonText "Add" to display
    And I enter "<firstname>" into input field having <firstname_type> "<firstname_value>"
    And I enter "<lastname>" into input field having <lastname_type> "<lastname_value>"
    And I enter "<email>" into input field having <email_type> "<email_value>"
    When I click on element having buttonText "Add"
    Then I wait 10 ms for element having <blank_login_access_type> "<blank_login_access_value>" to display

    Examples:
      |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|email|email_type|email_value|blank_login_access_type|blank_login_access_value|
      |Steve|model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|steve.walner@gmail.com|model|selectedEmployee.email|css            |.ng-pristine.ng-invalid.ng-invalid-required|

  Scenario Outline: check for validation error if email is not entered and add button is clicked
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
    When I click on element having buttonText "Add"
    Then I wait 10 ms for element having <blank_login_access_type> "<blank_login_access_value>" to display

    Examples:
      |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|blank_login_access_type|blank_login_access_value|
      |Steve|model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|2017-12-12|model|selectedEmployee.startDate|css            |.ng-pristine.ng-invalid.ng-invalid-required|


  Scenario Outline: check for validation error if startdate entered is invalid and add button is clicked
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
    Then I accept alert
    Then element having <startdate_type> "<startdate_value>" should have attribute "title" with value "<value>"

    Examples:
      |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|value|
      |Steve|model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|20111121|model |selectedEmployee.startDate|steve.walner@gmail.com|model|selectedEmployee.email|Please enter a date formatting YYYY-MM-DD           |

  Scenario Outline: check the success of create operation when all fields are filled correctly and newly added employee is listed in home page
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
    Then I assert repeater element having "employee in employees" should "<emp_full_name>" have text present


     Examples:
      |firstname|firstname_type|firstname_value|lastname|lastname_type|lastname_value|startdate|startdate_type|startdate_value|email|email_type|email_value|emp_full_name|
      |MarchelSteven|model          |selectedEmployee.firstName|walner|model|selectedEmployee.lastName|2011-11-21|model |selectedEmployee.startDate|steve.walner@gmail.com|model|selectedEmployee.email|MarchelSteven walner|

  Scenario Outline: Check edit and delete button get enabled when employee from the list is selected
    Given I am in app homepage
    And I enter "Luke" into input field having model "user.name"
    And I enter "Skywalker" into input field having model "user.password"
    When I click on element having buttonText "Login"
    Then I wait 15 ms for element having id "bAdd" to be enabled
    When I click on repeater element having repeater "employee in employees"
    Then element having id "<button_id>" should be enabled
  Examples:
    |button_id|
    |bEdit         |
    |bDelete              |



