package Spring.Rest;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class PetSteps {
	
	@Step
	public RequestSpecification getRequest()
	{
		return RestAssured.given().log().all().contentType(ContentType.JSON)
				.body("{\r\n" + 
						"   \"id\":22,\r\n" + 
						"   \"category\":{\r\n" + 
						"      \"id\":10,\r\n" + 
						"      \"name\":\"tummy\",\r\n" + 
						"      \"breed\":\"german\"\r\n" + 
						"   },\r\n" + 
						"   \"name\":\"catter\",\r\n" + 
						"   \"photoUrls\":[\r\n" + 
						"      \"www.google.com\",\r\n" + 
						"      \"www.test.com\",\r\n" + 
						"      \"www.scientiabusiness.com\"\r\n" + 
						"   ],\r\n" + 
						"   \"tags\":[\r\n" + 
						"      {\r\n" + 
						"         \"id\":0,\r\n" + 
						"         \"name\":\"testing\"\r\n" + 
						"      },\r\n" + 
						"      {\r\n" + 
						"         \"id\":1,\r\n" + 
						"         \"name\":\"training\"\r\n" + 
						"      },\r\n" + 
						"      {\r\n" + 
						"         \"id\":2,\r\n" + 
						"         \"name\":\"rest\"\r\n" + 
						"      }\r\n" + 
						"   ],\r\n" + 
						"   \"status\":\"available\"\r\n" + 
						"}");
	}
	
	@Step
	public Response postRequestToEndPoint(RequestSpecification request, String endPoint)
	{
		return request.post(endPoint);
	}

}
