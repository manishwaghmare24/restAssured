package tests;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;

import base.ExtentManager;
public class TokenAuthUsername {
	String token;
@BeforeSuite
public void startReport() {
	ExtentManager.intiReports();
} 
	
  @Test
	public void getToken() {
		ExtentManager.createTest("Get Token");
		String payload = "{\"username\":\"emilys\", \"password\":\"emilyspass\"}";
		
		Response res = given()
				.baseUri("https://dummyjson.com/auth")
				.header("content-Type","application/Json")
				.body(payload)
				.when()
				.post("/login")
				.then()
.extract().response();
		
		   token = res.jsonPath().getString("accessToken");
		
      String body = res.asPrettyString();
		System.out.println(body);
		
	}
	
	@Test(dependsOnMethods = "getToken")
	public void responseToken() {
		
		ExtentManager.createTest("Response Token");
      
		
	 Response res =  given()
	  .baseUri("https://dummyjson.com")
	  .header("content-Type", "application/Json")
	  .header("Authorization","Bearer" + token)
	  .when()
	  .post("/users")
	  .then()
	  .extract().response();
	 String getToken = token;
	// String tokenrespone = res.jsonPath().getString(token);
	 System.out.println(getToken);
	 
	} 
	@Test
	public void auth() {
		ExtentManager.createTest("Auth Checking");
		Response res = given()
				.baseUri("https://dummyjson.com/auth/")
				.header("content-Type", "application/Json")
				.auth().basic("michaelw","michaelwpass")
				.when()
				.post("login")
				.then()
				.extract().response();
		
		String info = res.asPrettyString();
		System.out.println(info);
				
	}
	@AfterSuite
	public void close() {
		ExtentManager.flushreport();
	}
	
}
