package tests;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetRequestDummy {
	@Test
	public void getRequest() {

Response res =
 	given()
		.baseUri("https://api.mydummyapi.com/")
		.header("content-Type","application/json")
		.when()
		.get("users/1")
		.then()
	//	.statusCode(200)
		.time(lessThan(5000L))
	
		.extract().response();
	//	Assert.assertEquals(res.getStatusCode(), 404);
		int statuscode = res.getStatusCode();
 System.out.println(res.asPrettyString());
 System.out.println(statuscode);
		
	}

}
                                                                      