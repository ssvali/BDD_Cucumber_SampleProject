package testRunner;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings({"unused", "rawtypes"})
public class CucumberSuite {

    GregorianCalendar gcal = new GregorianCalendar();

    private WebDriver driver;

    /**
     * Before_Scenario method will be triggered before each and every scenarios.
     * Mainly a place for choosing the browser and the server
     */

    @Before
    public void before_scenario() throws Exception {
        try {

        } catch (Exception e) {

            throw e;
        }
    }

    /**
     * After_Scenario method will be triggered after each and every scenarios.
     * Mainly a place for taking screenshot and quitting the browser
     */

    @After
    public void after_scenario(Scenario scenario) throws Exception {
        try {
            String TCNum = scenario.getName().substring(scenario.getName().length()-8);
            if(scenario.getName().equalsIgnoreCase("Verify changing asset icon size on the floor using icon zoom slider on the tool bar - CAR-404")){

            }
            if(scenario.getStatus().equalsIgnoreCase("failed"))	{

                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshotBytes, "image/png");
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("screenshot\\screenshot_Failed"+TCNum+"_"+gcal.get(Calendar.YEAR)+"_"+gcal.get(Calendar.MONTH)+"_"+gcal.get(Calendar.DATE)+"_"+gcal.get(Calendar.HOUR)+"_"+gcal.get(Calendar.MINUTE)+"_"+gcal.get(Calendar.SECOND)+".png"));
            }
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshot\\screenshot_"+TCNum+"_"+gcal.get(Calendar.YEAR)+"_"+gcal.get(Calendar.MONTH)+"_"+gcal.get(Calendar.DATE)+"_"+gcal.get(Calendar.HOUR)+"_"+gcal.get(Calendar.MINUTE)+"_"+gcal.get(Calendar.SECOND)+".png"));

            driver.quit();


        }
        catch(Exception e){

            throw e;
        }
    }
}