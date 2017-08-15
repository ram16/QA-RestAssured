package com.dailysong.api;

import static com.jayway.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jayway.restassured.response.Response;

public class BasePage {
	protected static Log logger = LogFactory.getLog(DailySongAPI.class);

	private static Properties prop;
	private Response response;
	protected JsonTransformer jsonTransformer;

	public BasePage() {
		response = null;
		jsonTransformer = new JsonTransformer();
	}

	static {
		InputStream is = null;
		try {
			prop = new Properties();
			is = ClassLoader.class.getResourceAsStream("/application.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getURL() {
		return prop.getProperty("url");
	}

	protected Response post(Object obj, String appURL) {
		try {
			response = given().contentType("application/json").body(jsonTransformer.convertToJsonString(obj)).when()
					.post(appURL);

		} catch (Exception e) {
			logger.error("Error in adding new daily video song/list:" + e.getMessage());
		}

		return response;
	}
	

	protected Response get(String appURL) {
		try {
			response = given().contentType("application/json").when()
					.get(appURL);

		} catch (Exception e) {
			logger.error("Error in reading new daily video song/list:" + e.getMessage());
		}

		return response;
	}

	protected Response patch(Object obj, String appURL) {
		try {
			response = given().contentType("application/json").body(jsonTransformer.convertToJsonString(obj)).when()
					.patch(appURL);

		} catch (Exception e) {
			logger.error("Error in adding new daily video song/list:" + e.getMessage());
		}

		return response;
	}
	

	protected Response delete(String appURL) {
		try {
			response = given().contentType("application/json").when()
					.delete(appURL);

		} catch (Exception e) {
			logger.error("Error in reading new daily video song/list:" + e.getMessage());
		}

		return response;
	}

}
