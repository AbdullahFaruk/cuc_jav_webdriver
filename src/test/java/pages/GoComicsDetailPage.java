package pages;

import helpers.HelpWithJavascriptLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.ElapsedTime;

public class GoComicsDetailPage {
	
	public WebDriver driver;
	
	public GoComicsDetailPage(WebDriver driver) { // Class constructor
		this.driver = driver;
		
		ElapsedTime etime = new ElapsedTime();
		etime.start();
		new HelpWithJavascriptLibraries().waitForJSandJQueryToLoad(this.driver, 60L);
		etime.stop();
		System.out.println("Elapsed time waiting for 'GoComicsDetail' page to load is " 
				+ etime.getElapsedTimeSeconds() + " Seconds");
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean PageUrlIsFor(String comicName){
		if (comicName.equalsIgnoreCase("Calvin and Hobbes")) {
			return driver.getCurrentUrl().equals("http://www.gocomics.com/calvinandhobbes");
		}
		return false;
	}

}
