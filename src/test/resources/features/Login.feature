@Login
Feature: user login

  Scenario Outline: Check all mandatory field in login page is marked with asterix  *
    Given I am in app homepage
    Then element having <user_access_type> "<user_access_name>" should be present
    Then element having <password_access_type> "<password_access_name>" should be present

    Examples:
      |user_access_type|user_access_name|password_access_type|password_access_name|
      |xpath          |//*[contains(text(),"Username*")]        |xpath              |//*[contains(text(),"Password*")]     |



  Scenario Outline: Check for text field username and password appeared in login page, check submit button "Login" exist
    Given I am in app homepage
    Then element having <user_access_type> "<user_access_value>" should be present
    Then element having <password_access_type> "<password_access_value>" should be present
    Then element having <login_access_type> "<login_access_value>" should be present
  Examples:
    |user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|
    |model          |user.name        |model               |user.password        |buttonText        |Login             |



  Scenario Outline: Check for successful login using valid credentials and verify repeater element to show "employee list" appeared in home page
    Given I am in app homepage
    And I enter "<username>" into input field having <user_access_type> "<user_access_value>"
    And I enter "<password>" into input field having <password_access_type> "<password_access_value>"
    When I click on element having <login_access_type> "<login_access_value>"
    Then I wait 5 ms for element having <emp_list_access_type> "<emp_list_access_value>" to display
  Examples:
    |username|password|user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|emp_list_access_type|emp_list_access_value|
    |Luke    |Skywalker|model          |user.name        |model               |user.password        |buttonText       |Login             |repeater            |employee in employees|


  Scenario Outline: Check for validation error if either or both username and password is incorrect and Login button is clicked
    Given I am in app homepage
    And I enter "<username>" into input field having <user_access_type> "<user_access_value>"
    And I enter "<password>" into input field having <password_access_type> "<password_access_value>"
    When I click on element having <login_access_type> "<login_access_value>"
    Then I wait 5 ms for element having <invalid_login_access_type> "<invalid_login_access_value>" to display
    Then I assert element having <invalid_login_access_type> "<invalid_login_access_value>" should have text as "<error_message>"

    Examples:
      |username|password|user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|invalid_login_access_type|invalid_login_access_value|error_message|
      |tomsmith    |Skywalker|model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.error-message.ng-binding|Invalid username or password!|
      |Luke    |SkywalkerSecure|model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.error-message.ng-binding|Invalid username or password!|
      |Lukeer    |SkywalkerSecure|model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.error-message.ng-binding|Invalid username or password!|


  Scenario Outline:  Check for validation error if either or both username and password are blank and Login button is clicked
    Given I am in app homepage
    And I enter "<username>" into input field having <user_access_type> "<user_access_value>"
    And I enter "<password>" into input field having <password_access_type> "<password_access_value>"
    When I click on element having <login_access_type> "<login_access_value>"
    Then I wait 5 ms for element having <blank_login_access_type> "<blank_login_access_value>" to display

    Examples:
      |username|password|user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|blank_login_access_type|blank_login_access_value|
      |   | |model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.ng-pristine.ng-invalid.ng-invalid-required|
      |   |SkywalkerSecure|model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.ng-pristine.ng-invalid.ng-invalid-required|
      |Luke   ||model          |user.name        |model               |user.password        |buttonText       |Login             |css            |.ng-pristine.ng-invalid.ng-invalid-required|

