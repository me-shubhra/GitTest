package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.driverFactory;
import Utils.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class applicationHooks {
	
	private driverFactory driverfactory;
	private WebDriver driver;
	private configReader configreader;
	Properties prop;
	
	@Before(order=0)
	public void readConfigProperties() {
		configreader = new configReader();
		prop = configreader.init_props();
		
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		driverfactory = new driverFactory();
		driver = driverfactory.init_driver(browserName);
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		
	}
	
	@After(order = 1)
	public void takeScreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			String scenarioName = scenario.getName().replace(" ", "_");
			byte[] screenshotsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotsource, "image/png", scenarioName);
		}
		
	}
	

}
