package stepsDefinations;

import static org.junit.Assert.assertNotNull;

import java.net.ResponseCache;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dailysong.api.DailySongAPI;
import com.dailysong.api.beans.DailySong;
import com.dailysong.api.beans.DailySongsList;
import com.dailysong.api.beans.SongsList;
import com.dailysong.api.test.BaseTest;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestServices<Json> extends BaseTest {

	private static String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static long uniqueValue = System.currentTimeMillis();
	private static String uniqueString = String.valueOf(uniqueValue).substring(String.valueOf(uniqueValue).length() - 4,
			String.valueOf(uniqueValue).length());
	private static String id;
	private static DailySongsList commonList;
	private static DailySong commonSong;
	private DailySongAPI dsAPI;
	private Response response;
	private ValidatableResponse json;

	public RestServices() {
		dsAPI = new DailySongAPI();
	}

	@SuppressWarnings("unchecked")
	@When("^user sends a GET request for list of videos InSongs with \"([^\"]*)\"$")
	public void user_sends_a_GET_request_for_list_of_videos_InSongs_with(String getAllvideosongsURL) throws Throwable {

		//
		// Video dailySong1 = new Video();
		// dailySong1.setArtist("Poker");
		// dailySong1.setSong("Lady " + uniqueString);
		// dailySong1.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong1.setV(0);
		// dailySong1.setDateCreated(convertDateToString(dateFormat, new
		// Date()));
		//
		//
		// Video dailySong2 = new Video();
		// dailySong2.setArtist("Poker");
		// dailySong2.setSong("Lady " + uniqueString);
		// dailySong2.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong2.setV(0);
		// dailySong2.setDateCreated(convertDateToString(dateFormat, new
		// Date()));
		//
		//
		// Video dailySong3 = new Video();
		// dailySong3.setArtist("Poker");
		// dailySong3.setSong("Lady " + uniqueString);
		// dailySong3.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong3.setV(0);
		// dailySong3.setDateCreated(convertDateToString(dateFormat, new
		// Date()));

		// POST the data first BEFORE calling get method
		// Response responser=dsAPI.postVideoList(DailySongsList);
		SongsList list = new SongsList();

		// List<Video> videos = new ArrayList<Video>();
		//
		// videos.add(dailySong1);
		// videos.add(dailySong2);
		// videos.add(dailySong3);

		list.setTitle("Latest List of Songs " + uniqueString);
		list.setDesc("Love Songs");
		// list.setV(0);
		// list.setVideos(videos);
		// list.setDateCreated(convertDateToString(dateFormat, new Date()));
		// list.setV(0);
		// list.setVideos(videos);
		// list.setDateCreated(convertDateToString(dateFormat, new Date()));

		response = dsAPI.postVideoList(list);

		logger.info("Response body:" + commonList.getId());

		throw new PendingException();
	}

	@Then("^Response should be list of videos \"([^\"]*)\"$")
	public void response_should_be_list_of_videos() throws Throwable {

		commonList = (jsonTransformer.convertToDailySongsListObject(response.getBody().asString()));
		logger.info("Response body:" + commonList.getId());

		throw new PendingException();
	}

	@When("^user sends a POST request for Create  video \"([^\"]*)\"$")
	public void user_sends_a_POST_request_for_Create_video(String postVideo) throws Throwable {

		response = dsAPI.postVideo(null);

		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^with following details$")
	public void with_following_details(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<List<String>> asList = arg1.raw();

		for (List<String> row : asList) {

			Object[] dailySong = row.toArray();

			DailySong dailySong1 = new DailySong();
			dailySong1.setArtist("Poker Face");
			dailySong1.setSong("Lady Gaga" + uniqueString);
			dailySong1.setDateCreated(convertDateToString(dateFormat, new Date()));

			throw new PendingException();
		}
	}

	@When("^user sends a GET request for single video \"([^\"]*)\"$")
	public void user_sends_a_GET_request_for_single_video(String getVideoSongById) throws Throwable {

		DailySong dailySong = new DailySong();
		dailySong.setArtist("Ed Sheeran");
		dailySong.setSong("Galway Girl" + uniqueString);
		dailySong.setPublishDate(convertDateToString(dateFormat, new Date()));
		dailySong.setV(0);
		dailySong.setDateCreated(convertDateToString(dateFormat, new Date()));

		response = dsAPI.postVideo(dailySong);
	}

	@Then("^Response should be \"([^\"]*)\"$")
	public void response_should_be() throws Throwable {

		DailySong song = jsonTransformer.convertToDailySongObject(response.getBody().asString());

		song = jsonTransformer.convertToDailySongObject(dsAPI.getVideoSongById(song.getId()).asString());
		assertNotNull(song);

		throw new PendingException();

	}

	@When("^user sends a PATCH request for update a video \"([^\"]*)\"$")
	public void user_sends_a_PATCH_request_for_update_a_video(String patchVideoById) throws Throwable {

		dsAPI.patchVideoById(id);

	}

	@Then("^Response should be NOT implemented_ \"([^\"]*)\"$")
	public void response_should_be_NOT_implemented_(String String) throws Throwable {

		DailySong song = jsonTransformer.convertToDailySongObject(response.getContentType());
		;
		String Ouput = response.asString();
		Assert.assertSame(String, Ouput);

		// String ExpectedResponse = Res.asString();
		// System.out.println("ExpectedResponse -------" + song);

		// logger.info("Post status of Videos List:" +
		// response.getStatusCode());

		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^user sends DELETE a video request \"([^\"]*)\"$")
	public void user_sends_DELETE_a_video_request(String deleteVideoById) throws Throwable {

		dsAPI.deleteVideoById(id);

		throw new PendingException();
	}

	@When("^user sends a GET request for list of Playlist \"([^\"]*)\"$")
	public void user_sends_a_GET_request_for_list_of_Playlist(String getAllPlaylistSongs) throws Throwable {

		//
		// Video dailySong1 = new Video();
		// dailySong1.setArtist("Poker");
		// dailySong1.setSong("Lady " + uniqueString);
		// dailySong1.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong1.setV(0);
		// dailySong1.setDateCreated(convertDateToString(dateFormat, new
		// Date()));
		// dailySong1.setHidden("false");
		//
		// Video dailySong2 = new Video();
		// dailySong2.setArtist("Poker");
		// dailySong2.setSong("Lady " + uniqueString);
		// dailySong2.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong2.setV(0);
		// dailySong2.setDateCreated(convertDateToString(dateFormat, new
		// Date()));
		// dailySong2.setHidden("false");
		//
		// Video dailySong3 = new Video();
		// dailySong3.setArtist("Poker");
		// dailySong3.setSong("Lady " + uniqueString);
		// dailySong3.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong3.setV(0);
		// dailySong3.setDateCreated(convertDateToString(dateFormat, new
		// Date()));
		// dailySong3.setHidden("false");

		SongsList list = new SongsList();

		// List<Video> videos = new ArrayList<Video>();
		//
		// videos.add(dailySong1);
		// videos.add(dailySong2);
		// videos.add(dailySong3);

		list.setTitle("Latest List of Songs " + uniqueString);
		list.setDesc("Love Songs");
		// list.setV(0);
		// list.setVideos(videos);
		// list.setDateCreated(convertDateToString(dateFormat, new Date()));

		dsAPI.getAllPlaylistSongs(list);

		/*
		 * logger.info("Post status of Videos List:" +
		 * response.getStatusCode()); commonList =
		 * (jsonTransformer.convertToDailySongsListObject(response.getBody().
		 * asString())); logger.info("Response body:" + commonList.getId());
		 */

		throw new PendingException();
	}

	@When("^user sends a GET request for single Playlist \"([^\"]*)\"$")
	public void user_sends_a_GET_request_for_single_Playlist(String getPlaylistVideoSongById) throws Throwable {

		// DailySong dailySong = new DailySong();
		// dailySong.setArtist("Ed Sheeran");
		// dailySong.setSong("Galway Girl" + uniqueString);
		// dailySong.setPublishDate(convertDateToString(dateFormat, new
		// Date()));
		// dailySong.setV(0);
		// dailySong.setDateCreated(convertDateToString(dateFormat, new
		// Date()));

		// dsAPI.postVideoInSong(dailySong);

		dsAPI.getPlaylistVideoSongById(id);
		//
		// DailySong song =
		// jsonTransformer.convertToDailySongObject(response.getBody().asString());
		// song.getId();
		// assertNotNull(song);
		//

		throw new PendingException();
	}

	@Then("^status code should be_(\\d+)$")
	public void status_code_should_be_(int arg1) throws Throwable {
		json = response.then().statusCode(arg1);
		logger.info("Post status of Videos List:" + response.getStatusCode());
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	

	@When("^user sends a POST request for Create Playlist \"([^\"]*)\"$")
	public void user_sends_a_POST_request_for_Create_Playlist(String postVideoList) throws Throwable {
		
		@SuppressWarnings("unused")
		Response response = dsAPI.postVideoList(null);
		
		throw new PendingException();
	}

	@When("^with following$")
	public void with_following(DataTable arg1) throws Throwable {
		List<List<String>> asList = arg1.raw();

		for (List<String> row : asList) {

			@SuppressWarnings("unused")
			Object[] dailySong = row.toArray();
			
			SongsList dailySong1 = new SongsList();
			dailySong1.setDesc("My first playlist.");
			dailySong1.setTitle("My List");

			throw new PendingException();
		}
		throw new PendingException();
	}

}