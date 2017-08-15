package com.dailysong.api.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "videos" })
public class PatchRequest {

	@JsonProperty("videos")
	private List<PatchRequestInformation> patchRequestBody = null;

	@JsonProperty("videos")
	public List<PatchRequestInformation> getPatchRequestBody() {
		return patchRequestBody;
	}

	@JsonProperty("videos")
	public void setPatchRequestBody(List<PatchRequestInformation> patchRequestBody) {
		this.patchRequestBody = patchRequestBody;
	}

}