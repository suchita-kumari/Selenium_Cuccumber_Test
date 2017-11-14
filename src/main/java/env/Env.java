package env;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Env 
{
	static WebDriver driver = null;
	static String browserName = null;
	static String currentPath = System.getProperty("user.dir");
	static Properties prop = new Properties();

	public static WebDriver CreateWebDriver(String browser)
	{
			System.out.println("Browser: " + browser);

			switch (browser.toLowerCase()) {

                case "firefox":
					driver = new FirefoxDriver();
				break;

                case "chrome":
					 driver = new ChromeDriver();
				break;

				case "safari":
				    driver = new SafariDriver();
				break ;

			    default:
				     System.out.println("Invalid browser name "+browser);
				    System.exit(0);
					break;	
			}//switch
				
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			return driver;
        }
	}
