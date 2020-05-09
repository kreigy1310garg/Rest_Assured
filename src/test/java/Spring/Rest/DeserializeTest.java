package Spring.Rest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeserializeTest {

	@BeforeSuite
	public void india() {
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

	}

	//@Test
	public void myFirstTest() {
		// Set the base url

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.pathParam("cityName", "hyderabad");

		httpRequest.log().all();

		Response response = httpRequest.get("/{cityName}");
		
		Weather res = response.getBody().as(Weather.class);
		

		response.prettyPrint();
		
		Assert.assertEquals(res.City,"Hyderabad");

		Assert.assertEquals(200, response.getStatusCode());
		

	}
	
	@Test
	public void mySecondTest() {
		// Set the base url
		
		User tester = new User(1,"amantestgarg","27387387","garg","aman","aman@test.com","test1234",2);

		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).body(tester);
		
		httpRequest.log().all();

		Response response = httpRequest.post("/user");
//		
//		User res = response.getBody().as(User.class);
		

		response.prettyPrint();
		

		Assert.assertEquals(200, response.getStatusCode());
		

	}
}
