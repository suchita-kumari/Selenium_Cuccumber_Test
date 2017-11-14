package info.seleniumcucumber.methods;


import java.util.List;

import com.paulhammant.ngwebdriver.ByAngular;
import env.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.HTMLDocument;

public class AssertionMethods extends SelectElementByType implements BaseTest
{
	//This file contains assertion methods which are called from predefinedStepDefinitions

	  SelectElementByType eleType= new SelectElementByType();
	  private WebElement element=null;
      List<WebElement> list_element=null;


	/** Method to get element text
	 * @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	 * @param accessName : String : Locator value
	 * @return String
	 */
	public String getElementText(String accessType, String accessName)
	{
		SelectElementByType selectElementByType =new SelectElementByType();
		driver = DriverUtil.getDefaultDriver();
		element = driver.findElement(selectElementByType.getelementbytype(accessType,accessName));
		return element.getText();
		
	}

    /** Method to get exact repeater text
      * @param accessName : String : Locator value
     * @return String
     */
    public String getRepeaterText(String accessName,String actualValue)
    {
        int ele_iterator ;
        SelectElementByType selectElementByType =new SelectElementByType();
        driver = DriverUtil.getDefaultDriver();

        list_element= driver.findElements(ByAngular.repeater(accessName));
        for(ele_iterator =0;ele_iterator<list_element.size()-1;ele_iterator++)
        {
            if(list_element.get(ele_iterator).getText().equalsIgnoreCase(actualValue))
            break;
        }

         return list_element.get(ele_iterator).getText();
    }

	/** Method to click on  exact repeater text
	 * @param accessName : String : Locator value
	 * @return String
	 */
	public WebElement clickRepeaterText(String accessName, String actualValue)
	{
		int ele_iterator ;
		SelectElementByType selectElementByType =new SelectElementByType();
		driver = DriverUtil.getDefaultDriver();

		list_element= driver.findElements(ByAngular.repeater(accessName));
		for(ele_iterator =0;ele_iterator<list_element.size();ele_iterator++)
		{
			if(list_element.get(ele_iterator).getText().equalsIgnoreCase(actualValue))
				break;
		}

		   return list_element.get(ele_iterator);
	}
	
	/** Method to check element text
	* @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	* @param actualValue : String : Expected element text
	* @param accessName : String : Locator value
	* @param testCase : Boolean : test case [true or false]
	*/
	public void checkElementText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);
		System.out.println("Element text -------" +elementText);
		if (testCase)
		{
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Text Not Matched");
		}
		else
		{
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Text Matched");
		}
	}

    /** Method to check element text
     * @param actualValue : String : Expected element text
     * @param accessName : String : Locator value
     */
    public void checkRepeaterElementText(String accessName,String actualValue) throws TestCaseFailed
    {
        String elementText = getRepeaterText(accessName,actualValue);
        System.out.println("repeater element" + elementText);
        Assert.assertEquals(elementText,actualValue);
    }

    /** Method to check on repeater element text
     * @param actualValue : String : Expected element text
     * @param accessName : String : Locator value
     */
    public void clickRepeaterElementText(String accessName,String actualValue) throws TestCaseFailed
    {
        driver = DriverUtil.getDefaultDriver();
        element = clickRepeaterText(accessName,actualValue);
        System.out.println("element finding to click" + element.getText());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }
	
	/** Method to return element status - enabled?
	* @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	* @param accessName : String : Locator value
	* @return Boolean
	*/
	public boolean isElementEnabled(String accessType, String accessName)
	{
	    driver=DriverUtil.getDefaultDriver();
        wait= new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.isEnabled();
	}
	
	/** Element enabled checking
	@param accessType : String : Locator type (id, name, class, xpath, css)
	@param accessName : String : Locator value
	@param testCase : Boolean : test case [true or false]
	*/
	public void checkElementEnable(String accessType, String accessName, boolean testCase) throws TestCaseFailed
	{
		boolean result=isElementEnabled(accessType,accessName);
		if(testCase)
		{
			if (!result)
				throw new TestCaseFailed("Element Not Enabled");
		}
		else 
		{ 
			 if(result)
				 throw new TestCaseFailed("Element Enabled");
		}
	}	  
	
	/** method to get attribute value
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	@param attributeName : String : attribute name
	@return String
	*/
	public String getElementAttribute(String accessType,String accessName,String attributeName)
	{
        driver=DriverUtil.getDefaultDriver();
        wait= new WebDriverWait(driver, 30);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getAttribute(attributeName);
	}
	
	/** method to check attribute value
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param attributeName : String : attribute name
	@param attributeValue : String : attribute value
	@param accessName : String : Locator value
	@param testCase : Boolean : test case [true or false]
	*/
	public void checkElementAttribute(String accessType, String attributeName, String attributeValue, String accessName, boolean testCase) throws TestCaseFailed
	{
		String attrVal = getElementAttribute(accessType, accessName, attributeName);
		if(testCase)
		{
			if(!attrVal.equals(attributeValue))
				throw new TestCaseFailed("Attribute Value Not Matched");
		}
		else 
		{
			if(attrVal.equals(attributeValue))
				throw new TestCaseFailed("Attribute Value Matched");
		}
	}
	
	/** method to get element status - displayed?
	@param accessType : String :Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	@return Boolean
	*/
	public boolean isElementDisplayed(String accessType,String accessName)
	{
		driver = DriverUtil.getDefaultDriver();
        wait= new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType,accessName)));
		return element.isDisplayed();
	}

    public boolean isElementHasClass(String accessType,String accessName,String classString)
    {
        driver = DriverUtil.getDefaultDriver();
        wait= new WebDriverWait(driver, 30);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType,accessName)));
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equalsIgnoreCase(classString)) {
                return true;
            }
        }

        return false;
    }
	/** method to check element presence
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	@param testCase : Boolean : test case [true or false]
	*/
	public void checkElementPresence(String accessType,String accessName,boolean testCase) throws TestCaseFailed
	{
		if (testCase)
		{
			if (!isElementDisplayed(accessType, accessName))
				throw new TestCaseFailed("Element Not Present");
		}
		else
		{
			try
			{
				if(isElementDisplayed(accessType, accessName))
					throw new Exception("Present"); //since it is negative test and we found element
			}
			catch(Exception e)
			{
				if(e.getMessage().equals("Present")) //only raise if it present
					throw new TestCaseFailed("Element Present");
			}
		}
	}

    public void checkElementwithclassPresence(String accessType,String accessName,String classString,boolean testCase) throws TestCaseFailed
    {
        if (testCase)
        {
            if (!isElementHasClass(accessType, accessName,classString))
                throw new TestCaseFailed("Element Not Present");
        }
        else
        {
            try
            {
                if(isElementHasClass(accessType, accessName,classString))
                    throw new Exception("Present"); //since it is negative test and we found element
            }
            catch(Exception e)
            {
                if(e.getMessage().equals("Present")) //only raise if it present
                    throw new TestCaseFailed("Element Present");
            }
        }
    }


	/** method to get javascript pop-up alert text
	 * @return String
	 */
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}
	  
	/**method to check javascript pop-up alert text
	 * @param text : String : Text to verify in Alert
	 * @throws TestCaseFailed
	 */
	public void checkAlertText(String text) throws TestCaseFailed
	{
		if(!getAlertText().equals(text))
			throw new TestCaseFailed("Text on alert pop up not matched");
	}
	

}
