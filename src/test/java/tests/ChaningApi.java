package tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ChaningApi {
	String token;
@Test(priority = 0)
	public void loginApi() {
		Response res = given()
				.baseUri("https://reqres.in/api")
				.contentType("application/Json")
				.header("x-api-key","reqres-free-v1")
				.body("{\"email\" : \"test@gmail.com\", \"password\": \"Test123\"}")
				.when()
				.post("/login");
	token = res.jsonPath().getString("token");
		System.out.println("Token:" +token);
	}
	@Test(priority = 1)

	public void getUserPage() {
		given()
		.baseUri("https://reqres.in/api")
		.contentType("application/Json")
		.header("x-api-key","reqres-free-v1")
		.header("Authorization", "Bearer" + token)
		.when()
		.get("/users")
		.then()
		.statusCode(200);
		
	}

}
