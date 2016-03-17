package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.PropertyReader;

public class DriverFactory {
	
	protected static WebDriver driver;
	
	public DriverFactory() {
		initialize();
	}
	
	public void initialize() {
		if (driver == null)
			createNewDriverInstance();
	}
	
	private void createNewDriverInstance() {
		PropertyReader propReader = new PropertyReader();
		String browser = propReader.readProperty("browser");
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:/SeleniumWebdrivers/chromedriver.exe");
	    	driver = new ChromeDriver();
		} else {
			System.out.println(propReader.propertyNotValidMsg("browser", browser));
		}
		Assert.assertNotNull("Driver failed initialization", driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void destroyDriver() {
		driver.quit();
		driver = null;
	}
}
