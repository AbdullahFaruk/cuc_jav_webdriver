package runsupport;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json"},
		glue = { "classpath:steps", "classpath:runsupport" },
		tags = {"@search"}
		)
public class RunCukesTest{
	
}