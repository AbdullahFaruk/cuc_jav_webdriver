package runsupport;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
		glue = { "classpath:steps", "classpath:runsupport" },
		tags = {"@hobbes"}
		)
public class RunCukesTest{
	
}