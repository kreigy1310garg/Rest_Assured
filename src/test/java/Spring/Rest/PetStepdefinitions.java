package Spring.Rest;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;

public class PetStepdefinitions {
	
	@Steps
	PetSteps petSteps;
	
	@Shared
	StepData data;
	
	@Given("I have the pet details ready with me.")
	public void readyTestData()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		data.request = petSteps.getRequest();

	}
	
	@When("I posted the requested to the {string} endpoint.")
	public void requestEndPoint(String endpoint)
	{
		data.response =  petSteps.postRequestToEndPoint(data.request, endpoint); 
		data.response.prettyPrint();
		System.out.println("Post Request");
	}

	@Then("Response should be {int}.")
	public void validateStatusCode(int statuscode)
	{
		Assert.assertEquals(data.response.getStatusCode(),statuscode);
		
	}
	
	@Then("Response should have pet breed as german.")
	public void validateBreed()
	{
	Assert.assertTrue(data.response.getBody().asString().contains("tummy"));
	}

}
