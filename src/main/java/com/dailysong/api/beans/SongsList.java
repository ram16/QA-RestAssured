package com.dailysong.api.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongsList {
	@JsonProperty("_id")
	private String id;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("title")
	private String title;

	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("desc")
	public String getDesc() {
		return desc;
	}

	@JsonProperty("desc")
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
}
