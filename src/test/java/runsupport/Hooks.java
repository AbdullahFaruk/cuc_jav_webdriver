package runsupport;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
    public WebDriver driver;
    protected static Logger log;
    
    public Hooks() {
    	log = Logger.getLogger(Hooks.class);
    }
    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests. Maximize the browser window and
     * set the selenium implicit wait.
     */
    public void openBrowser() throws MalformedURLException {
    	DriverFactory driveFact = new DriverFactory();
    	driver = driveFact.getDriver();
    	log.info("@Before hook will run before the actual scenario");
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driveFact.setImplicitWait(60); // Default value for rest of run
    	driver.manage().timeouts().implicitlyWait(driveFact.getImplicitWait(), TimeUnit.SECONDS);
    }

     
    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        try {
	    	if(scenario.isFailed()) {
		        try {
		        	scenario.write("Current Page URL is " + driver.getCurrentUrl());
		            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		            scenario.embed(screenshot, "image/png");
		        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
		        	log.error(somePlatformsDontSupportScreenshots.getMessage());
//		            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		        } catch (ClassCastException cce) {
		            cce.printStackTrace();
		        }
	    	}
        } finally {
        	new DriverFactory().destroyDriver();
        	log.info("@After hook will run after the scenario is finished, even if the scenario failed");
        }
    }
    
}