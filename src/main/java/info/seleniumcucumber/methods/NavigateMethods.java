package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigateMethods extends SelectElementByType implements BaseTest
{
	
	private WebElement element=null;
	ProgressMethods progressMethods =new ProgressMethods();
	/** Method to open link
	 * @param url : String : URL for navigation
	 */

	public void navigateTo(String url) 
	{
        driver = DriverUtil.getDefaultDriver();
        driver.get(url);
	}
	
	/** Method to navigate back & forward
	 * @param direction : String : Navigate to forward or backward
	 */
	public void navigate(String direction)
	{
		if (direction.equals("back"))
			driver.navigate().back();
		else
			driver.navigate().forward();
	}

	/** Method to scroll page to top or end
	 * @param to : String : Scroll page to Top or End
	 * @throws Exception
	 */
	public void scrollPage(String to) throws Exception
	{
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
			executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}


    /** Method to scroll page to top or end
     * @throws Exception
     */
    public void scrollPagetoBottom() throws Exception
    {
        driver =DriverUtil.getDefaultDriver();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /** Method to quite webdriver instance */




	public void closeDriver() throws InterruptedException {
       driver.quit();

	}

	/** Method to resize browser
	 * @param width : int : Width for browser resize
	 * @param height : int : Height for browser resize
	 */
	public void resizeBrowser(int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width,height));
	}
	
	/** Method to maximize browser	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/** Method to hover on element
	 * @param accessType : String : Locator type (id, name, class, xpath, css,model,buttonText,repeater)
	 * @param accessName : String : Locator value
	 */
	public void hoverOverElement(String accessType, String accessName)
	{
		driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		action.moveToElement(element).perform();
	}

	public void hoverOverElementandclick(String accessType, String accessName)
	{
		driver = DriverUtil.getDefaultDriver();
		wait = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		action.moveToElement(element).click().perform();
	}
	

	

	

}
