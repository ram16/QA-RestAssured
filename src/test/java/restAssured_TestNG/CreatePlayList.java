package restAssured_TestNG;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatePlayList {
	
	public static Response response;
	public static String jsonAsString;


@BeforeClass
public static void setupURL() {

	RestAssured.baseURI = "http://turing.niallbunting.com:3001";
	RestAssured.basePath = "/api";
}

@Test
public void CreatePlaylist() {

	Response Res = 
		given().body("{"+
                "\"desc\": \"My first playlist.\","+
                "\"title\":\"My List\"" +
                		 "}").contentType(ContentType.JSON).
		when()

				.post("/video/").then().assertThat().statusCode(201).and().contentType(ContentType.JSON)
				.extract()
				.response(); 
	String jsonAsString = Res.asString();
	System.out.println(jsonAsString);

}
}
