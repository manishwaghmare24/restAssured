package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreateUsertest {
	@Test
	public void createUser() {
		String payload = "{\"name\" :  \"John\", \"job\" : \"engineer\"}";
		given()
		.baseUri("https://reqres.in/api")
		.contentType("application/Json")
		.header("x-api-key","reqres-free-v1")
		.body(payload)
		.when()
		.post("/users");
		
	//	.statusCode(201)
//		.body("name", equalTo("John")) 
		//.log().all();
	}

}
