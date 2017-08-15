package restAssured_TestNG;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


import io.restassured.response.Response;
public class PatchAVideo {

	public static Response response;
	public static String jsonAsString;


@BeforeClass
public static void setupURL() {

	RestAssured.baseURI = "http://turing.niallbunting.com:3001";
	RestAssured.basePath = "/api";
}

@Test
public void PatchVideo() {

	
    Response Res= 
	
	         when()

			.patch("/video/").then().assertThat().statusCode(501).and().extract().response();

	         String ExpectedResponse = Res.asString();
	         System.out.println("ExpectedResponse -------"+ ExpectedResponse);

}}


	

