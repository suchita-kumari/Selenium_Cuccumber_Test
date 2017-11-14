package info.seleniumcucumber.methods;

import com.paulhammant.ngwebdriver.ByAngular;
import env.DriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClickElementsMethods extends SelectElementByType implements BaseTest
{
	
	private WebElement element=null;

	/** Method to click on an element
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	*/
	public void click(String accessType, String accessName)throws Exception
	{
		SelectElementByType selectElementByType =new SelectElementByType();
		driver = DriverUtil.getDefaultDriver();
        element= driver.findElement(selectElementByType.getelementbytype(accessType,accessName));
		//element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();

	}
    /** Method to click on an repeater element
     @param accessName : String : Locator value
     */
    public void clickonrepeater(String accessName) throws Exception
    {
        SelectElementByType selectElementByType =new SelectElementByType();
        driver = DriverUtil.getDefaultDriver();
        element= driver.findElement(ByAngular.exactRepeater(accessName).row(1));
        element.click();
    }
	/** Method to forcefully click on an element
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	*/
	public void clickForcefully(String accessType, String accessName)throws Exception
	{
		driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
	}
	
	/** Method to Double click on an element
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessValue : String : Locator value
	*/
	public void doubleClick(String accessType, String accessValue)
	{
		driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessValue)));

		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}

    /** Method to Double click on repeater element
     @param accessName : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
     @*/
    public void doubleClickonrepeater(String accessName, int index)
    {
        driver = DriverUtil.getDefaultDriver();
        wait = new WebDriverWait(driver, 30);
        element= driver.findElement(ByAngular.exactRepeater(accessName).row(1));

        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }
}