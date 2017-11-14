@logout
Feature: Logout user

  Scenario Outline: Check for logout button appeared once user is logged on
    Given I am in app homepage
    And I enter "<username>" into input field having <user_access_type> "<user_access_value>"
    And I enter "<password>" into input field having <password_access_type> "<password_access_value>"
    When I click on element having <login_access_type> "<login_access_value>"
    Then I wait 5 ms for element having xpath "<access_value>" to display
  Examples:
    |username|password|user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|access_value|
    |Luke    |Skywalker|model          |user.name        |model               |user.password        |buttonText       |Login             |//p[contains(text(),'Logout')]|

  Scenario Outline: Check for logout button return back to user login page and username/password is blank
    Given I am in app homepage
    And I enter "<username>" into input field having <user_access_type> "<user_access_value>"
    And I enter "<password>" into input field having <password_access_type> "<password_access_value>"
    When I click on element having <login_access_type> "<login_access_value>"
    Then I click on element having xpath "<logout_access_value>"
    Then I assert element having model "<user_access_value>" and has class "<invalid_class_name>" should be present
    Then I assert element having model "<password_access_value>" and has class "<invalid_class_name>" should be present
  Examples:
      |username|password|user_access_type|user_access_value|password_access_type|password_access_value|login_access_type|login_access_value|invalid_class_name|logout_access_value|
      |Luke    |Skywalker|model          |user.name        |model               |user.password        |buttonText       |Login             | ng-invalid-required            |//p[contains(text(),'Logout')]|

