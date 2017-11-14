package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InputMethods extends SelectElementByType implements BaseTest
{
	//SelectElementByType eleType= new SelectElementByType();
	private WebElement dropdown =null;
	private Select selectList=null;
	
	/** Method to enter text into text field
	 * @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	 * @param text : String : Text value to enter in field
	   @param accessName : String : Locator value
	 */
	public void enterText(String accessType,String text,String accessName)
	{
        driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	/** Method to clear text of text field
	@param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	@param accessName : String : Locator value
	*/
	public void clearText(String accessType, String accessName)
	{
		driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		driver.findElement(getelementbytype(accessType, accessName)).clear();
	}
	

}
