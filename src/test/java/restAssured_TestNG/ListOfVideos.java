package restAssured_TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.when;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ListOfVideos {

	public static Response response;
	public static String jsonAsString;

	@BeforeClass
	public static void setupURL() {

		RestAssured.baseURI = "http://turing.niallbunting.com:3001";
		RestAssured.basePath = "/api";
	}

	@Test
	public void  ListOfVideos1() {

		Response Res =

				when().get("/video/").then().contentType(ContentType.JSON).and().assertThat().statusCode(201).extract()
						.response();
		String jsonAsString = Res.asString();
		System.out.println(jsonAsString);


	}
}