package com.dailysong.api.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailySongsList extends SongsList {

	@JsonIgnore
	private List<Video> videos = null;

	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("__v")
	private Integer v;

	
    @JsonAnyGetter
	public List<Video> getVideos() {
		return videos;
	}

    @JsonAnySetter
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@JsonProperty("date_created")
	public String getDateCreated() {
		return dateCreated;
	}

	@JsonProperty("date_created")
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty("__v")
	public Integer getV() {
		return v;
	}

	@JsonProperty("__v")
	public void setV(Integer v) {
		this.v = v;
	}
}