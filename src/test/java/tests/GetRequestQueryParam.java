package tests;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class GetRequestQueryParam {

	String url = "https://api.mydummyapi.com/";
	//verify the API behviour to check the page from 1 to 10 is exist or not 
	@Test
	public void getQueryUsingLoop() {
		for(int i=1; i<=5; i++) {
Response res =
			given()
	      .baseUri("https://api.mydummyapi.com/")
		.queryParam("page", i)
		.header("content-Type","application/Json")
		.queryParam("page", i)
		
		.when()
		.post("/posts/")
		.then()
		//.statusCode(200)
		.extract().response();
		int responsecode = res.getStatusCode();
	
	
	//System.out.println(res.asPrettyString());
		System.out.println("Page \t" + i + " " + responsecode);
		
		}
		
		
		
	
	}
	@Test
	public void getQueryPage() {

		Response res = given()
				.baseUri(url)
				.header("content-Type", "application/json")
				.queryParam("start", 101)
				.queryParam("second page", 2)
				.when()
				.get("/posts/")
				.then()
				.extract().response();
		
	int code = res.getStatusCode();
	
	System.out.println(code);
	}
	
}
