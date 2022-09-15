package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.plugin.Plugin;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions", "appHooks"},
		plugin = {"pretty",
				"com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)

public class myTestRunner {

}
