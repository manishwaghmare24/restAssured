package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.POJOGETTERSETTER;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class postRequest {
	


	@DataProvider(name="test")
	public Object[][] getQuotes(){
		
		return new Object[][] {
			{"your hear is with","manish waghmare"},
			{"your hear is me","sushma waghmare"}
			
		};
	}
	
	@Test(dataProvider = "test")
	public void getPost(String quote, String author) {
		
		
		
	  POJOGETTERSETTER pj = new POJOGETTERSETTER(quote, author);
		
	Response res =	given()
		.baseUri("https://dummyjson.com/")
		.header("content-Type","application/Json")
		.body(pj)
		.when()
		.post("quotes")
		.then()
		.extract().response();
		
		;
		
		int statuscode = res.getStatusCode();
		System.out.println(statuscode);
		
	}

}
