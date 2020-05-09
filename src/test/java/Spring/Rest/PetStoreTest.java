package Spring.Rest;

import java.util.List;

import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Shared;

public class PetStoreTest {
	
	public static String petId = "20";
	
	@BeforeSuite
	public void before()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void myDependentTest()
	{
		RequestSpecification httpRequest = RestAssured.given().contentType(io.restassured.http.ContentType.JSON)
				.body("{\r\n" + 
						"   \"id\":28,\r\n" + 
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

		//httpRequest.log().all();

		Response response = httpRequest.post("/pet");

		//response.prettyPrint();

		Assert.assertEquals(200, response.getStatusCode());
		
		petId = response.jsonPath().get("id").toString();
		
		List<String> objects = response.jsonPath().getList("tags.name");
		response.prettyPrint();
	
		
	    for(String test : objects)
	    {
	    	System.out.println(test);
	    }
	}
	
	@Test
	public void myFifthTest() {

		RequestSpecification httpRequest = RestAssured.given().pathParam("id", petId);

		httpRequest.log().all();

		Response response = httpRequest.get("/pet/{id}");

		response.prettyPrint();

		Assert.assertEquals(200, response.getStatusCode());
		
		
		
		Assert.assertEquals(response.jsonPath().get("category.name"),"tummy");

		Assert.assertEquals(response.jsonPath().get("photoUrls[2]"),"www.scientiabusiness.com");
		Assert.assertEquals(response.jsonPath().get("tags[0].name"),"testing");
		Assert.assertEquals(response.jsonPath().get("tags[2].name"),"rest");
		PetPOJO res = response.getBody().as(PetPOJO.class);
		
		System.out.println(res.getTags()[0].getId());
		System.out.println(res.getPhotoUrls()[0]);
		System.out.println(res.getCategory().name);
		
		
	}

}
