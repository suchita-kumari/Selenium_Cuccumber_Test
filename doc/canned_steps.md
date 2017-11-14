# Canned Steps

Project comes with the following set of predefined steps.
You can add your own steps or change the ones you see here.


## Navigation Steps

To open/close URL and to navigate between pages use following steps :

	Then I navigate to "([^\"]*)"
	Then I navigate forward
	Then I navigate back
	Then I refresh page


	
To interact with browser use following steps :    

	Then I resize browser window size to width (\d+) and height (\d+)
	Then I maximize browser window
	Then I close browser


To hover over a element use following steps :

	Then I hover over element having id "(.*?)"
	Then I hover over element having name "(.*?)"
	Then I hover over element having class "(.*?)"
	Then I hover over element having xpath "(.*?)"
	Then I hover over element having css "(.*?)"
	
	
To scroll webpage use following steps :
	
	Then I scroll to top of page
	I scroll to bottom of page	
	


Assertion Steps
---------------
To assert that page title can be found use following step :

	Then I should see page title as "(.*?)"
	Then I should not see page title as "(.*?)"

	Then I should see page title having partial text as "(.*?)"
  Then I should not see page title having partial text as "(.*?)"
    
#### Steps For Asserting Element Text

To assert element text use any of the following steps :

	Then element having id "([^\"]*)" should have text as "(.*?)"
	Then element having name "([^\"]*)" should have text as "(.*?)"
	Then element having class "([^\"]*)" should have text as "(.*?)"
	Then element having xpath "([^\"]*)" should have text as "(.*?)"
	Then element having css "([^\"]*)" should have text as "(.*?)"
	Then element having buttonText "([^\"]*)" should have text as "(.*?)"
	Then element having model "([^\"]*)" should have text as "(.*?)"
	

	Then element having id "([^\"]*)" should have partial text as "(.*?)"
	Then element having name "([^\"]*)" should have partial text as "(.*?)"
	Then element having class "([^\"]*)" should have partial text as "(.*?)"
	Then element having xpath "([^\"]*)" should have partial text as "(.*?)"
	Then element having css "([^\"]*)" should have partial text as "(.*?)"
	
	Then element having id "([^\"]*)" should not have text as "(.*?)"
	Then element having name "([^\"]*)" should not have text as "(.*?)"
	Then element having class "([^\"]*)" should not have text as "(.*?)"
	Then element having xpath "([^\"]*)" should not have text as "(.*?)"
	Then element having css "([^\"]*)" should not have text as "(.*?)"
	Then element having buttonText "([^\"]*)" should not have text as "(.*?)"
	

	Then element having id "([^\"]*)" should not have partial text as "(.*?)"
	Then element having name "([^\"]*)" should not have partial text as "(.*?)"
	Then element having class "([^\"]*)" should not have partial text as "(.*?)"
	Then element having xpath "([^\"]*)" should not have partial text as "(.*?)"
	Then element having css "([^\"]*)" should not have partial text as "(.*?)"
	
#### Steps For Asserting Element Attribute

To assert element attribute use any of the following steps : 

	Then element having id "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	Then element having name "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	Then element having class "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	Then element having xpath "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	Then element having css "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	Then element having model "([^\"]*)" should have attribute "(.*?)" with value "(.*?)"
	
	
	Then element having id "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	Then element having name "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	Then element having class "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	Then element having xpath "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	Then element having css "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	Then element having model "([^\"]*)" should not have attribute "(.*?)" with value "(.*?)"
	

#### Steps For Asserting Element Accesibility

To assert that element is enabled use any of the following steps :

	Then element having id "([^\"]*)" should be enabled
	Then element having name "([^\"]*)" should be enabled
	Then element having class "([^\"]*)" should be enabled
	Then element having xpath "([^\"]*)" should be enabled
	Then element having css "([^\"]*)" should be enabled

To assert that element is disabled use any of the following steps :

	Then element having id "([^\"]*)" should be disabled
	Then element having name "([^\"]*)" should be disabled
	Then element having class "([^\"]*)" should be disabled
	Then element having xpath "([^\"]*)" should be disabled
	Then element having css "([^\"]*)" should be disabled

#### Steps For Asserting Element Visibility

To assert that element is present use any of the following steps :

	Then element having id "([^\"]*)" should be present
	Then element having name "([^\"]*)" should be present
	Then element having class "([^\"]*)" should be present
	Then element having xpath "([^\"]*)" should be present
	Then element having css "([^\"]*)" should be present
	Then element having model "([^\"]*)" should be present
	Then element having buttonText "([^\"]*)" should be present
	Then element having repeater "([^\"]*)" should be present
	


#### Steps For Asserting Javascript Pop-Up Alert 

To assert text on javascipt pop-up alert use following step :

	Then I should see alert text as "(.*?)"
	
	



Input Steps
-----------

#### Steps For TextFields

To enter text into input field use following steps :

	Then I enter "([^\"]*)" into input field having id "([^\"]*)"
	Then I enter "([^\"]*)" into input field having name "([^\"]*)"
	Then I enter "([^\"]*)" into input field having class "([^\"]*)"
	Then I enter "([^\"]*)" into input field having xpath "([^\"]*)"
	Then I enter "([^\"]*)" into input field having css "([^\"]*)"
	
To clear input field use following steps :

	Then I clear input field having id "([^\"]*)"
	Then I clear input field having name "([^\"]*)"
	Then I clear input field having class "([^\"]*)" 
	Then I clear input field having xpath "([^\"]*)"
	Then I clear input field having css "([^\"]*)"


Click Steps
-----------
To click on web element use following steps :

	Then I click on element having id "(.*?)"
	Then I click on element having name "(.*?)"
	Then I click on element having class "(.*?)"
	Then I click on element having xpath "(.*?)"
	Then I click on element having css "(.*?)"

To forcefully click on web element use following steps (if above steps do not work) :

	Then I forcefully click on element having id "(.*?)"
	Then I forcefully click on element having name "(.*?)"
	Then I forcefully click on element having class "(.*?)"
	Then I forcefully click on element having xpath "(.*?)"
	Then I forcefully click on element having css "(.*?)"
	Then I forcefully click on element having buttonText "(.*?)"
	Then I forcefully click on element having repeater "(.*?)"

To double click on web element use following steps :

	Then I double click on element having id "(.*?)"
	Then I double click on element having name "(.*?)"
	Then I double click on element having class "(.*?)"
	Then I double click on element having xpath "(.*?)"
	Then I double click on element having css "(.*?)"
	Then I double click on element having buttonText "(.*?)"
	Then I double click on element having repeater "(.*?)"




Progress Steps
--------------
To implicitly wait for specific time use following step :

	Then I wait for (\d+) sec
	
To wait for specific element to display use following steps :

	Then I wait (\d+) seconds for element having id "(.*?)" to display
	Then I wait (\d+) seconds for element having name "(.*?)" to display
	Then I wait (\d+) seconds for element having class "(.*?)" to display
	Then I wait (\d+) seconds for element having xpath "(.*?)" to display
	Then I wait (\d+) seconds for element having css "(.*?)" to display

To wait for specific element to enable use following steps : why it is clickable in code

	Then I wait (\d+) seconds for element having id "(.*?)" to enable
	Then I wait (\d+) seconds for element having name "(.*?)" to enable
	Then I wait (\d+) seconds for element having class "(.*?)" to enable
	Then I wait (\d+) seconds for element having xpath "(.*?)" to enable
	Then I wait (\d+) seconds for element having css "(.*?)" to enable

Javascript Handling Steps
-------------------------
To handle javascript pop-up use following steps :

	Then I accept alert 
	Then I dismiss alert
  

Screenshot Steps 
----------------
To take screenshot use following step :

	Then I take screenshot



