package stepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.ScenarioImpl;
import env.DriverUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
	@After
	public final void teardown(Scenario scenario) {
		WebDriver driver = DriverUtil.getDefaultDriver();
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				ScenarioImpl impl = (ScenarioImpl) scenario;
				String name = "Screenshots/" + impl.getId().replaceAll("\\W", "_");
				FileUtils.copyFile(srcFile, new File(name + ".png"));
			} catch (IOException ex) {

			}
		}
	}
}
