package env;

import java.util.concurrent.TimeUnit;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by suchita on 09/11/17.
 */
public class DriverUtil {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;
	protected static NgWebDriver ngWebDriver;


	public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}

		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

		DesiredCapabilities capabilities = null;
		capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);

		return driver;
    }

    /**
     * By default to web driver will be firefox
     *
     * Override it by passing -DWebDriver=Chrome to the command line arguments
     * @param capabilities
     * @return
     */
    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
		String preferredDriver = System.getProperty("browser", "Firefox");
		boolean headless = System.getProperty("Headless", "true").equals("true");
		
		switch (preferredDriver.toLowerCase()) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				if (headless) {
					chromeOptions.addArguments("--headless");
					chromeOptions.addArguments("no-sandbox");
				}
				capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				chromeOptions.addArguments("disable-infobars");
				ChromeDriver chromeDriver= new ChromeDriver(chromeOptions);
				return chromeDriver;
			default:
				//return new PhantomJSDriver(capabilities);
				FirefoxOptions options = new FirefoxOptions();
				//capabilities.s
				if (headless) {
					options.addArguments("-headless", "-safe-mode");
				}
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
				final FirefoxDriver firefox = new FirefoxDriver();
				return firefox;
		}
    }



	public static void closeDriver() {
		if (driver != null) {
			try {
				driver.close();
				driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			driver = null;
		}
	}
}
