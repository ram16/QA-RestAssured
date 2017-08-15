package restAssured_TestNG;

import static io.restassured.RestAssured.when;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class SingleVideo {

	public static Response response;
	public static String jsonAsString;

	@BeforeClass
	public static void setupURL() {

		RestAssured.baseURI = "http://turing.niallbunting.com:3001";
		RestAssured.basePath = "/api";
	}

	@Test
	public void SingleVideo1() {

		Response Res =

				when().get("/video/596cac389f0525001db52244").then().contentType(ContentType.JSON).extract().response();

		String jsonAsString = Res.asString();

		JsonPath jp = new JsonPath(jsonAsString);
		assertEquals("596cac389f0525001db52244", jp.get("_id"));

		

	}
}
