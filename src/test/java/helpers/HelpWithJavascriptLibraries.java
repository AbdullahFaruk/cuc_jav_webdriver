package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Manually inspect page source on your webpage as soon as it is loaded and search for 
 * "script" tags containing the keywords "jquery","angular" or "prototpye". Then pick 
 * the corresponding method below.  Call that method in that page's PageObject constructor
 * class to wait for that page to finish loading before continuing with the test. 
 */
public class HelpWithJavascriptLibraries {
	
	/*
	 *  waitForJSandJQueryToLoad assumes that if a loading spinner was implemented that it
	 *  is identifiedby class=spinner.  While a good guess, check that your developers identified 
	 *  the spinner this way.  E.g. they could have used id=spinner instead. Modify this code as 
	 *  appropriate. This code handles the case where a loading spinner hasn't been implemented at all. 
	 */
	
	public boolean waitForJSandJQueryToLoad(WebDriver driver) {
		return waitForJSandJQueryToLoad(driver, 30L);  // Default to 30 seconds
	}
	
	public boolean waitForJSandJQueryToLoad(WebDriver driver, long waitTimeInSeconds) {
	    
	    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds, 2000L);

	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	    	boolean isAjaxFinished = false;
	    	boolean isLoaderSpinning = false;
	    	boolean isPageLoadComplete = false;
	        try {
	          isAjaxFinished = ((Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0;"));
	        } catch (Exception e) {
	        	// no Javascript library not found
	        	isAjaxFinished = true;
	        }
	        try { // Check your page, not everyone uses class=spinner
	        	isLoaderSpinning = driver.findElement(By.className("spinner")).isDisplayed();
	        } catch (Exception f) {
	        	// no loading spinner found
	        	isLoaderSpinning = false;
	        }
	        isPageLoadComplete = ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	    	        .toString().equals("complete");
	        if (!(isAjaxFinished & !(isLoaderSpinning) & isPageLoadComplete))
	        	System.out.println(isAjaxFinished + ", " + !(isLoaderSpinning) +", " + isPageLoadComplete);
	        
	        return isAjaxFinished & !(isLoaderSpinning) & isPageLoadComplete;
	      }
	    };

	  return wait.until(libraryLoad); 
	}
	
	public boolean waitForPrototypeToLoad(WebDriver driver) {
		return waitForPrototypeToLoad(driver, 30);
	}
	
	public boolean waitForPrototypeToLoad(WebDriver driver, int waitTimeInSeconds) {
	
		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds, 2000L);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Boolean)((JavascriptExecutor)driver).executeScript("return Ajax.activeRequestCount == 0;"));
	        }
	        catch (Exception e) {
	        	// Prototype  not found
	        	System.out.println("Not found: " + "return Ajax.activeRequestCount == 0;");
	        	return true;
	        }
	      }
	    };

	    // wait for browser readystate complete; it is arguable if selenium does this all the time
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	        .toString().equals("complete");
	      }
	  };

	  return wait.until(libraryLoad) && wait.until(jsLoad);
		
	}
	
	public boolean waitForAngularToLoad(WebDriver driver) {
		return waitForAngularToLoad(driver, 30);
	}
	
	public boolean waitForAngularToLoad(WebDriver driver, int waitTimeInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds, 2000L);

	    ExpectedCondition<Boolean> libraryLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Boolean)((JavascriptExecutor)driver).executeScript(
	        		  "return angular.element(document.body).injector().get(\'$http\').pendingRequests.length == 0;"
	        		  ));
	        }
	        catch (Exception e) {
	        	// Angular not found
	        	System.out.println("Not found: " + "return angular.element(document.body).injector().get(\'$http\').pendingRequests.length == 0;");
	        	return true;
	        }
	      }
	    };

	    // wait for browser readystate complete; it is arguable if selenium does this all the time
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState;")
	        .toString().equals("complete");
	      }
	  };

	  return wait.until(libraryLoad) && wait.until(jsLoad);
		
	}
}
