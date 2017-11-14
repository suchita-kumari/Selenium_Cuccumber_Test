package info.seleniumcucumber.methods;

import env.DriverUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JavascriptHandlingMethods implements BaseTest {
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	/**Method to handle alert
	 * @param decision : String : Accept or dismiss alert
	 */
	public void handleAlert(String decision)
	{
		driver = DriverUtil.getDefaultDriver();
        if(decision.equals("accept"))
        try{
            //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }


        if(decision.equals("accept"))
            try{
                //Wait 10 seconds till alert is present
                WebDriverWait wait = new WebDriverWait(driver, 10);
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                //Accepting alert.
                alert.dismiss();
                System.out.println("dismiss the alert successfully.");
            }catch(Throwable e){
                System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
            }
        if(decision.equals("text"))
            if(decision.equals("accept"))
                try{
                    //Wait 10 seconds till alert is present
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

                }catch(Throwable e){
                    System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
                }

	}


}
