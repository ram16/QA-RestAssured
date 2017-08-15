package com.dailysong.api;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailysong.api.beans.DailySong;
import com.dailysong.api.beans.DailySongsList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransformer {

	protected static Log logger = LogFactory.getLog(JsonTransformer.class);

	private ObjectMapper om;

	public JsonTransformer() {
		om = new ObjectMapper();
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public String convertToJsonString(Object obj) {
		String str = null;
		try {
			str = om.writeValueAsString(obj);
		} catch (IOException e) {
			logger.error("Unable to convert java object into json string value:" + e.getMessage());
		}
		return str;
	}

	/**
	 * 
	 * @param json
	 * @return
	 */
	public DailySong convertToDailySongObject(String json) {
		DailySong obj = null;
		try {
			obj = om.readValue(json, DailySong.class);
		} catch (Exception e) {
			logger.error("Unable to convert java object into json string value:" + e.getMessage());
		}
		return obj;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	public DailySongsList convertToDailySongsListObject(String json) {
		DailySongsList obj = null;
		try {
			obj = om.readValue(json, DailySongsList.class);
		} catch (Exception e) {
			logger.error("Unable to convert java object into json string value:" + e.getMessage());
		}
		return obj;
	}

}
