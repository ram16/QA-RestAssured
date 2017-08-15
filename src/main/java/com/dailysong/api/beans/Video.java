package com.dailysong.api.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video extends DailySong {

	@JsonProperty("hidden")
	private String hidden;

	@JsonProperty("hidden")
	public String getHidden() {
		return hidden;
	}

	@JsonProperty("hidden")
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
}
