package com.dailysong.api.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dailysong.api.JsonTransformer;

public class BaseTest {

	protected JsonTransformer jsonTransformer;

	public BaseTest() {
		jsonTransformer = new JsonTransformer();
	}

	protected static Log logger = LogFactory.getLog(BaseTest.class);

	protected String convertDateToString(String format, Date date) {
		return new SimpleDateFormat(format).format(date);
	}
}
