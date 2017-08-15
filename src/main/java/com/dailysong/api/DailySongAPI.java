package com.dailysong.api;

import com.dailysong.api.beans.DailySong;
import com.dailysong.api.beans.SongsList;
import com.jayway.restassured.response.Response;

public class DailySongAPI extends BasePage {

	private static String getAllvideosongsURL = "/api/video";
	private static String getVideoSongById = "/api/video/id";
	private static String postVideo = "/api/video/";
	private static String patchVideoById = "/api/video/id";
	private static String deleteVideoById = "/api/video/id";
	
	private static String getAllPlaylistSongs = "/api/playlist";
	private static String getPlaylistVideoSongById = "/api/playlist/id";
	private static String postVideoList = "/api/playlist";
	private static String deletePlaylistById = "/api/playlist/id";
	private static String patchPlaylistById = "/api/playlist/id";
	
	public Response postVideo(DailySong dailySong) {
		return post(dailySong, getURL() + postVideo);
	}

	public Response postVideoList(SongsList Songlist) {
		return post(Songlist, getURL() + postVideoList);
	}
	
	public <Json> Response getAllVideoSongs() {
		return get(getURL() + getAllvideosongsURL);
	}
	public Response getAllPlaylistSongs( SongsList list) {
		return get(getURL() + getAllPlaylistSongs);
	}

	public Response getVideoSongById(String id) {
		return get(getURL() + getVideoSongById + "(" + id + ")");
	}

	//public Response getVideoList() {
		//return get(getURL() + playListURL);
		
	
	public Response getPlaylistVideoSongById(String id) {
		return get(getURL() + getPlaylistVideoSongById + "(" + id + ")");
	}
	

	public Response deletePlaylistById(String id) {
		return get(getURL() + deletePlaylistById + "(" + id + ")");
	}
	
	public Response patchVideoById(String id) {
		return get(getURL() + patchVideoById + "(" + id + ")");
	}
	
	public Response deleteVideoById(String id) {
		return get(getURL() + deleteVideoById + "(" + id + ")");
	}
	
	public Response patchPlaylistById(String id) {
		return get(getURL() + patchPlaylistById + "(" + id + ")");
	}
}
