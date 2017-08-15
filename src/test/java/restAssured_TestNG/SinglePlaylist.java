
	
package restAssured_TestNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.when;



public class SinglePlaylist {

	public static void main(String[] args) {
	
		RestAssured.baseURI = "turing.niallbunting.com:3001/";
		           when()
	              .get("playlist/(id)")
	              .then().
	              assertThat().statusCode(200);
	
		
		
	}

}
