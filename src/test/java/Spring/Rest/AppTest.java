package Spring.Rest;



import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest {

//	@BeforeSuite
//	public void india() {
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//
//	}
//
//	 @Test
//	public void myFirstTest() {
//		// Set the base url
//
//		RequestSpecification httpRequest = RestAssured.given();
//		httpRequest.pathParam("cityName", "hyderabad");
//
//		httpRequest.log().all();
//
//		Response response = httpRequest.get("/{cityName}");
//
//		response.prettyPrint();
//
//		Assert.assertEquals(200, response.getStatusCode());
//
//	}
//
//	 @Test
//	public void mySecondTest() {
//
//		RequestSpecification httpRequest = RestAssured.given();
//
//		httpRequest.pathParam("cityName", "mumbai");
//
//		httpRequest.log().all();
//
//		Response response = httpRequest.get("/{cityName}");
//
//		response.prettyPrint();
//
//		Assert.assertEquals(200, response.getStatusCode());
//	}
//
//    @Test
//	public void myThirdTest() {
//
//		RequestSpecification httpRequest = RestAssured.given().baseUri("http://restapi.demoqa.com/customer");
//
//		httpRequest.contentType(ContentType.JSON)
//				.body("{\r\n" + "   \"FirstName\":\"donald\",\r\n" + "   \"LastName\":\"trump\",\r\n"
//						+ "   \"UserName\":\"USATRUMP\",\r\n" + "   \"Password\":\"corona@123\",\r\n"
//						+ "   \"Email\":\"us@corona.com\"\r\n" + "}");
//
//		httpRequest.log().all();
//
//		Response response = httpRequest.post("/register");
//
//		response.prettyPrint();
//
//		Assert.assertEquals(200, response.getStatusCode());
//	}
//
//	 @Test
//	public void myFourthTest() {
//
//		RequestSpecification httpRequest = RestAssured.given().auth().basic("ToolsQA", "TestPassword")
//				.baseUri("http://restapi.demoqa.com/authentication");
//
//		httpRequest.log().all();
//
//		Response response = httpRequest.get("/CheckForAuthentication");
//
//		response.prettyPrint();
//
//		Assert.assertEquals(response.jsonPath().get("FaultId"), "OPERATION_SUCCESS");
//
//		Assert.assertEquals(response.jsonPath().get("Fault"), "Operation completed successfully");
//
//		Assert.assertEquals(200, response.getStatusCode());
//
//		Assert.assertTrue(response.getBody().asString().contains("Operation completed successfully"));
//	}
//	
//	@Test
//	public void uploadTest()
//	{
//		File testUploadFile = new File("C:\\sdclatestworkspace\\Rest\\src\\test\\resources\\test.json");
//		Response res = RestAssured.given().log().all().baseUri("https://petstore.swagger.io/v2/pet/22").formParam("additionalMetadata", "testing").multiPart(testUploadFile).post("/uploadImage");
//		Assert.assertEquals(res.getStatusCode(),200);
//		res.prettyPrint();
//	}
//	
//	@Test
//	public void uploadTest1()
//	{
//		File fileToUpload = new File("C:\\sdclatestworkspace\\Rest\\src\\test\\resources\\test.json");
//		Response res = RestAssured.given().log().all().baseUri("https://petstore.swagger.io/v2").formParam("additionalMetaData", "spring people").multiPart(fileToUpload).pathParam("petId", 22).post("/pet/{petId}/uploadImage");
//	      res.prettyPrint();
//	}
//	
//	@Test
//	public void queryTest()
//	{
//		Response res = RestAssured.given().log().all().baseUri("https://reqres.in/api").queryParam("page", "2").queryParam("id", 5).get("/users");
//		Assert.assertEquals(res.getStatusCode(),200);
//		res.prettyPrint();
//	}
//	
//	@Test
//	public void oAuthTest()
//	{
//		Response res = RestAssured.given().log().all().baseUri("https://api.twitter.com/1.1/statuses").auth().oauth("tpm97q7gPXm4g3EA0oUmtmBCq","UyFugasDCBN9HfaT0uDe9Sbtvs5Vdh6LfznQxAqFhwgUTQACaT","945645824456953856-ZIjXUDRrzQ4dGSKkT294tvqcIZy1GKl","RY0CXsAwTWDmsuPJGV6QOJJ1XwjkSYuTL8pYUNVYk8b4v").queryParam("status","This tweet was created using rest assured 987")
//                .post("/update.json");
//		Assert.assertEquals(res.getStatusCode(),200);
//		res.prettyPrint();
//	}
//	
	//Change your client id and client secret in basic method for paypal account
	//use this url to sign up on paypal 
	//https://developer.paypal.com/classic-home/
	//sign up and provide your info and don't link card  and hit the url again on providing details.
	//create an app and take ur client id and secret
	@Test
	public void oAuth2Test()
	{
		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "v1";
		Response res = RestAssured.given().log().all().param("grant_type","client_credentials").auth().preemptive().basic("ATEPzcyr0rNmEeT50iCAXAHIKoWsJKAUmfu9dlcAhlfR4y8GubV9AY0itswbJsz389XzQvFUz49fXfHy", "ELLB4SiRoIvBDkKiK_KtfPmIzeedNMwU3zh7RhXEQnQBSq2M_dqnh5RiYx-lXtm_5JorZgI28fwiSFsG").post("/oauth2/token");
		res.prettyPrint();
	}
	
	//use accesstoken in oauth2 which you get from previous oauth2test.
	//Change file path to your directory location
	//@Test
	public void paymentTest()
	{
		File file = new File("C:\\sdclatestworkspace\\Rest\\src\\test\\resources\\payment.json");
		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "v1";
		Response res = RestAssured.given().log().all().contentType(ContentType.JSON).auth().oauth2("Your access token from previous test response.").body(file).post("/payments/payment");
		res.prettyPrint();
	}
	
	
}
