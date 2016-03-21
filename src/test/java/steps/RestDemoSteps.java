package steps;

import org.apache.log4j.Logger;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import cucumber.api.java.en.*;  // Given, When, Then
import runsupport.DriverFactory;

public class RestDemoSteps extends DriverFactory {
	
	private RequestSpecification requestSpec;
	private Response response;
	protected static Logger log = Logger.getLogger(RestDemoSteps.class);;

	@Given("^I set the JSON validation string to:$")
	public void i_set_the_JSON_validation_string_to(String aPotentialJSONString) throws Throwable {
		requestSpec = RestAssured.with();
	    requestSpec.given().parameter("json", aPotentialJSONString);
	}

	@When("^I validate the string by invoking end point:$")
	public void i_validate_the_string_by_invoking_end_point(String targetRestUrl) throws Throwable {
		log.info("URL=" + targetRestUrl);
	    response = requestSpec.when().get(targetRestUrl);
	    
	}

	@Then("^the result is \"([^\"]*)\"$")
	public void the_result_is(String arg1) throws Throwable {
	    log.info("Response=" + response.print());
		response.then().
			body("object_or_array", equalTo("object")).and().
			body("empty", is(false)).and().
			body("validate", is(true));
	}
}
