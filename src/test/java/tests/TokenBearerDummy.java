      package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TokenBearerDummy {
	
	
	public static String getTotken() {
		String payload = "{\"username\":\"emilys\", \"password\":\"emilyspass\"}";
		
		Response res = given()
			.baseUri("https://dummyjson.com/")
			.header("content-Type", "application/json")
			.body(payload)
			.when()
			.post("/auth/login")
			.then()
			//.statusCode(201)
			.extract().response();
		
		String token = res.jsonPath().getString("accessToken");
	//	System.out.println(token);
		System.out.println(res.asPrettyString());
		String username = res.jsonPath().getString("username");
		System.out.println(username);
		return token;
				
	}
	@Test (priority = 2)
	public void verifyGetRequest() {
		
		String token = getTotken();
		
		System.out.println("toekn id:" + token);
		
	}

}
