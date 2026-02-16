package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GETRequest {
	@Test
	public void getUser() { 
  given()
  .baseUri("https://reqres.in/api")
  .when()
  .get("/users?page=2")
  .then()
  .statusCode(200);

	}

}
