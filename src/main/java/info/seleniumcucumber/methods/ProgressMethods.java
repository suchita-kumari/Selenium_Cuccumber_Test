package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProgressMethods extends SelectElementByType implements BaseTest
{
	/** Method to wait 
	 * @param time : String : Time to wait
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public void wait(String time) throws NumberFormatException, InterruptedException
	{
		//sleep method takes parameter in milliseconds
		Thread.sleep(Integer.parseInt(time)*1000);
	}
	
	/**Method to Explicitly wait for element to be displayed
	 * @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	 * @param accessName : String : Locator value
	 * @param duration : String : Time to wait for element to be displayed
	 */
	public void waitForElementToDisplay(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		driver=DriverUtil.getDefaultDriver();
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byEle));
	}
		
	/** Method to Explicitly wait for element to be enabled=click
	 * @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	 * @param accessName : String : Locator value
	 * @param duration : String : Time to wait for element to be clickable
	 */
	public void waitForElementToClick(String accessType,String accessName,String duration)
	{
		By byEle = getelementbytype(accessType, accessName);
		driver = DriverUtil.getDefaultDriver();
		WebDriverWait wait = (new WebDriverWait(driver,Integer.parseInt(duration)*1000));
		wait.until(ExpectedConditions.elementToBeClickable(byEle));
	}

	public  void waitForAngularLoad() {
		WebDriverWait wait = new WebDriverWait(driver,15);

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;

		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		//Wait for ANGULAR to load

		ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
				.executeScript(angularReadyScript).toString());

		//Get Angular is Ready
		boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

		//Wait ANGULAR until it is Ready!
		if(!angularReady) {
			System.out.println("ANGULAR is NOT Ready!");
			//Wait for Angular to load
			wait.until(angularLoad);
		} else {
			System.out.println("ANGULAR is Ready!");
		}
	}
	
}
