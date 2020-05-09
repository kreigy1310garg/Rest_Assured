package Spring.Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemaValidatorTest {
	
	@Test
	public void testingSchema()
	{
		Response res = RestAssured.given().log().all().get("https://gist.githubusercontent.com/hanikhan/88bcdf4cd0ee668a4f147efc7cc487d0/raw/61541503cbb2b3c4b57717a398aad216a86450a7/gistfile1.txt");
				
		res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema("{\r\n" + 
				"   \"$schema\": \"http://json-schema.org/draft-07/schema\",\r\n" + 
				"   \"type\":\"array\",\r\n" + 
				"   \"items\":{\r\n" + 
				"      \"$ref\":\"#/definitions/rest\"\r\n" + 
				"   },\r\n" + 
				"   \"definitions\":{\r\n" + 
				"      \"rest\":{\r\n" + 
				"         \"type\":\"object\",\r\n" + 
				"         \"required\":[\r\n" + 
				"            \"web_pages\",\r\n" + 
				"            \"name\",\r\n" + 
				"            \"alpha_two_code\",\r\n" + 
				"            \"state-province\",\r\n" + 
				"            \"domains\",\r\n" + 
				"            \"country\"\r\n" + 
				"         ],\r\n" + 
				"         \"properties\":{\r\n" + 
				"            \"web_pages\":{\r\n" + 
				"               \"type\":\"array\",\r\n" + 
				"               \"items\":{\r\n" + 
				"                  \"type\":\"string\"\r\n" + 
				"               }\r\n" + 
				"            },\r\n" + 
				"            \"name\":{\r\n" + 
				"               \"type\":\"string\",\r\n" + 
				"               \"description\":\"this is the name\"\r\n" + 
				"            },\r\n" + 
				"            \"alpha_two_code\":{\r\n" + 
				"               \"type\":[\r\n" + 
				"                  \"null\",\r\n" + 
				"                  \"string\"\r\n" + 
				"               ],\r\n" + 
				"               \"description\":\"this is the state\"\r\n" + 
				"            },\r\n" + 
				"            \"state-province\":{\r\n" + 
				"               \"type\":[\r\n" + 
				"                  \"null\",\r\n" + 
				"                  \"string\"\r\n" + 
				"               ],\r\n" + 
				"               \"description\":\"this is the state-provinace\"\r\n" + 
				"            },\r\n" + 
				"            \"domains\":{\r\n" + 
				"               \"type\":\"array\",\r\n" + 
				"               \"items\":{\r\n" + 
				"                  \"type\":\"string\"\r\n" + 
				"               }\r\n" + 
				"            },\r\n" + 
				"            \"country\":{\r\n" + 
				"               \"type\":[\r\n" + 
				"                  \"null\",\r\n" + 
				"                  \"string\"\r\n" + 
				"               ],\r\n" + 
				"               \"description\":\"this is the country\"\r\n" + 
				"            }\r\n" + 
				"         }\r\n" + 
				"      }\r\n" + 
				"   }\r\n" + 
				"}"));
	}

}
