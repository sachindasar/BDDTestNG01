package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\feature\\",
		glue = "stepdefs",
		monochrome = true,//to get readable console
		publish = true,
		dryRun = false,//it will check for all steps the definitions are define or not
		plugin = {"pretty",
				"html:target/reports/htmlReports.html",
				"rerun:target/failed_Scenarios.txt"})

public class TestNG extends AbstractTestNGCucumberTests
{
	
//	@DataProvider(parallel = true)
//	public Object[][] scenarios()
//	{
//		return super.scenarios();
//	}
}
