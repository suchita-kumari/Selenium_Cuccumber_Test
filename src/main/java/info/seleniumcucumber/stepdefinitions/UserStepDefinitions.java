package info.seleniumcucumber.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.ScenarioImpl;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;
import info.seleniumcucumber.methods.ProgressMethods;
import info.seleniumcucumber.methods.TestCaseFailed;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class UserStepDefinitions implements BaseTest{
    protected WebDriver driver = DriverUtil.getDefaultDriver();
    ProgressMethods progressMethods =new ProgressMethods();

 // Navigation steps ------------

    //Step to navigate to specified URL
    @Given("^I am in app homepage")
    public void I_am_in_app_homepage() throws InterruptedException {
        navigationObj.navigateTo("http://cafetownsend-angular-rails.herokuapp.com");
        progressMethods.waitForAngularLoad();

    }

// Getter method----------------

    // Step to get element text
    @Then("^I get input field text having (.+) \"([^\"]*)\"$")
    public void I_get_element_text(String accessType, String accessName) {
        assertionObj.getElementText(accessType,  accessName);
        System.out.println("text present is ---"+ assertionObj.getElementText(accessType,  accessName));


    }
// Input steps -------------

    // clear input field steps
    @Then("^I clear input field having (.+) \"([^\"]*)\"$")
    public void clear_text(String type, String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        inputObj.clearText(type, accessName);
    }

    // enter text into input field steps
    @Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
    public void enter_text(String text, String type,String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        inputObj.enterText(type, text, accessName);
    }

    // click on web element
    @Then("^I click on element having (.+) \"(.*?)\"$")
    public void click(String type,String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        clickObj.click(type, accessName);
        progressMethods.waitForAngularLoad();

    }
    // click on repeater web element
    @Then("^I click on repeater element having repeater \"(.*?)\"$")
    public void clickrepeater(String accessName) throws Exception
    {
        clickObj.clickonrepeater(accessName);
        progressMethods.waitForAngularLoad();

    }

    // double click on repeater element
    @Then("^I double click on repeater element having repeater \"(.*?)\" \"(.*?)\"$")
    public void doubleclick(String accessName,int value) throws Exception
    {
         clickObj.doubleClickonrepeater(accessName,value);
        progressMethods.waitForAngularLoad();

    }

    // double click on web element
    @Then("^I double click on element having (.+) \"(.*?)\"$")
    public void double_click(String type, String accessValue) throws Exception
    {
        miscmethodObj.validateLocator(type);
        clickObj.doubleClick(type, accessValue);
    }

// Assertion method   ---------------

     // step to check attribute value
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
    public void check_element_attribute(String type,String accessName,String present,String attrb,String value) throws Exception
    {
        miscmethodObj.validateLocator(type);
        assertionObj.checkElementAttribute(type, attrb, value, accessName, present.isEmpty());
    }

    // step to check element enabled or not
    @Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
    public void check_element_enable(String type, String accessName,String present,String state) throws Exception
    {
        miscmethodObj.validateLocator(type);
        boolean flag = state.equals("enabled");
        if(!present.isEmpty())
        {
            flag = !flag;
        }
        assertionObj.checkElementEnable(type, accessName, flag);
    }

    //step to check element present or not
    @Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void check_element_presence(String type,String accessName,String present) throws Exception
    {
        miscmethodObj.validateLocator(type);
        assertionObj.checkElementPresence(type, accessName, present.isEmpty());
    }

    //step to check element with class name present or not
    @Then("^I assert element having (.+) \"(.*?)\" and has class \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
    public void check_element_withclass_presence(String type,String accessName,String classString,String present) throws Exception
    {
        miscmethodObj.validateLocator(type);
        assertionObj.checkElementwithclassPresence(type, accessName, classString,present.isEmpty());
    }
    // step to check element text
    @Then("^I assert element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
    public void check_element_text(String type, String accessName,String present,String value) throws Exception
    {
        miscmethodObj.validateLocator(type);
        assertionObj.checkElementText(type, value, accessName,present.isEmpty());
    }

	// step to check element from repeater list
    @Then("^I assert repeater element having \"([^\"]*)\" should \"([^\"]*)\" have text present$")
    public void i_assert_repeater_element_having_should_have_text_present(String accessName, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertionObj.checkRepeaterElementText(accessName,value);
    }

    // step to click on element from repeater list
    @Then("^I click on repeater element having text \"([^\"]*)\" should \"([^\"]*)\" be clicked$")
    public void i_click_on_repeater_element_having_text_should_be_clicked(String accessName, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertionObj.clickRepeaterElementText(accessName,value);
    }

    //Steps to assert java script alert message and dismiss
    @Then("^I assert message from alert should be \"([^\"]*)\" and dismiss alert$")
    public void assert_alert_message_and_dismiss(String message)throws UnhandledAlertException
    {
        Alert alert = driver.switchTo().alert();
        assert alert.getText().contains(message);
        alert.dismiss();

    }

    //Steps to assert java script alert message and dismiss
    @Then("^I assert message from alert should be \"([^\"]*)\" and accept alert$")
    public void assert_alert_message_and_accept(String message)
    {
        try{
            //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            assert alert.getText().contains(message);
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }



    }

    //Forcefully click on element
    @Then("^I forcefully click on element having (.+) \"(.*?)\"$")
    public void click_forcefully(String type,String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        clickObj.clickForcefully(type,accessName);
    }

    //step to assert javascript pop-up alert text
    @Then("^I should see alert text as \"(.*?)\"$")
    public void check_alert_text(String actualValue) throws TestCaseFailed,UnhandledAlertException
    {
        assertionObj.checkAlertText(actualValue);
    }

// Progress methods --------------------------

    // wait for specific period of time
    @Then("^I wait for (\\d+) sec$")
    public void wait(String time) throws NumberFormatException, InterruptedException
    {
        progressObj.wait(time);
    }

    //wait for specific element to display for specific period of time
    @Then("^I wait (\\d+) ms for element having (.+) \"(.*?)\" to display$")
    public void wait_for_ele_to_display(String duration, String type, String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        progressObj.waitForElementToDisplay(type, accessName, duration);
    }
    // wait for specific element to enable for specific period of time
    @Then("^I wait (\\d+) ms for element having (.+) \"(.*?)\" to be enabled$")
    public void wait_for_ele_to_click(String duration, String type, String accessName) throws Exception
    {
        miscmethodObj.validateLocator(type);
        progressObj.waitForElementToClick(type, accessName, duration);
    }

// Javascript handling steps ----------

    //Step to handle java script
    @Then("^I accept alert$")
    public void handle_alert()throws UnhandledAlertException
    {
        javascriptObj.handleAlert("accept");
    }

    //Steps to dismiss java script
    @Then("^I dismiss alert$")
    public void dismiss_alert()throws UnhandledAlertException
    {
        javascriptObj.handleAlert("dismiss");
    }

    //Steps to retrieve  java script alert message
    @Then("^I get message from alert$")
    public void get_alert_message()throws UnhandledAlertException
    {
        javascriptObj.handleAlert("Text");

    }



// Screenshots methods -------------------

    @Then("^I take screenshot$")
    public void take_screenshot() throws IOException
    {
        screenshotObj.takeScreenShot();
    }

// Scroll methods
// scroll webpage

    @Then("^I scroll to (top|end) of page$")
    public void scroll_page(String to) throws Exception
    {
        navigationObj.scrollPage(to);
    }

    @Then("^I scroll to bottom of page$")
    public void scroll_page_to_bottom() throws Exception
    {
        navigationObj.scrollPagetoBottom();
    }

// browser exit methods ----------

    //Step to close the browser
    @Then("^I close browser$")
    public void close_browser() throws InterruptedException {
        navigationObj.closeDriver();
    }

    @After
    public final void tearDown() {
        DriverUtil.closeDriver();
    }




}
