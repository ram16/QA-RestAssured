package restAssured_TestNG;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.delete;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class DeleteVideo {

	public static Response response;
	public static String jsonAsString;


@BeforeClass
public static void setupURL() {
    
	RestAssured.baseURI = "http://turing.niallbunting.com:3001";
	RestAssured.basePath = "/api";
}

@Test
public void PatchVideo2() {

	
    Response Res= 
	
	         given().
	         when()
	         .contentType (ContentType.JSON)
	         

			.delete("/video/596cbda86ed7c10011a68b24").then().assertThat().statusCode(204).and().extract().response();
                  String ExpectedResponse = Res.asString();
	         System.out.println("ExpectedResponse -------"+ ExpectedResponse);

}}


	

