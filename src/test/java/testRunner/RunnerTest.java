package testRunner;


import com.cucumber.listener.ExtentCucumberFormatter;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.CucumberOptions;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

@CucumberOptions(
		features = {"src//test//java//features"}, glue = {"steps"},
		tags = {"@Smoke"}, format = {"json:testResult/cucumber.json", "pretty", "html:testResult/report"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
		)


/**
 * RunnerTest runs with ExtendedCucumberRunner class
 * and this is the starting point of the test suite
 */

@RunWith(CucumberRunner.class)
public class RunnerTest {

	@BeforeClass
	public static void setUp(){
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("testResult/cucumber_detailed_result/report.html"),true);
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

		Map systemInfo = new HashMap();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Environment", "QA");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}

	@AfterSuite
	public static void tearDown() throws Exception {
		try {

			//Creates the Detailed Result
			CucumberDetailedResults results = new CucumberDetailedResults();
			results.setOutputDirectory("testResult\\cucumber_detailed_result\\");
	        results.setOutputName("cucumber-results");
	        results.setSourceFile("testResult\\cucumber.json");
	        results.executeDetailedResultsReport(false, false);
	        //Creates the Overview Result involves chart representation
			CucumberResultsOverview result = new CucumberResultsOverview();
			result.setOutputDirectory("testResult\\cucumber_result_overview\\");
			result.setOutputName("cucumber-results");
			result.setSourceFile("testResult\\cucumber.json");
			result.executeFeaturesOverviewReport();


		}
		catch(Exception e) {

			throw e;
		}
	}


}
