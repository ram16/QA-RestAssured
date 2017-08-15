package restAssured_TestNG;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.dailysong.api.DailySongAPI;
import com.dailysong.api.beans.DailySong;
import com.dailysong.api.beans.DailySongsList;
import com.dailysong.api.beans.SongsList;
import com.dailysong.api.test.BaseTest;
import com.jayway.restassured.response.Response;

public class DailySongAPITest extends BaseTest {

	private static String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static long uniqueValue = System.currentTimeMillis();
	private static String uniqueString = String.valueOf(uniqueValue).substring(String.valueOf(uniqueValue).length() - 4,
			String.valueOf(uniqueValue).length());
	private static String id;
	private static DailySongsList commonList;
	private static DailySong commonSong;
	private DailySongAPI dsAPI;
	
	public DailySongAPITest() {
		dsAPI = new DailySongAPI();
	}

	@Test
	public void testPost() {
		logger.info("New Record inserted with :" + uniqueString);

		DailySong dailySong = new DailySong();
		dailySong.setArtist("Poker Face");
		dailySong.setSong("Lady Gaga" + uniqueString);
		dailySong.setPublishDate(convertDateToString(dateFormat, new Date()));
		dailySong.setV(0);
		dailySong.setDateCreated(convertDateToString(dateFormat, new Date()));

		Response response = dsAPI.postVideo(dailySong);
		
		DailySong song = jsonTransformer.convertToDailySongObject(response.getBody().asString());

		logger.info("Post status of video song id :" + id);
	}

	@Test
	public void testPostVideoList() {
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

		Response response = dsAPI.postVideoList(list);
		logger.info("Post status of Videos List:" + response.getStatusCode());
		commonList = (jsonTransformer.convertToDailySongsListObject(response.getBody().asString()));
		logger.info("Response body:" + commonList.getId());
	}

	@Test
	public void testGet() {
		
		DailySong dailySong = new DailySong();
		dailySong.setArtist("Poker Face");
		dailySong.setSong("Lady Gaga" + uniqueString);
		dailySong.setPublishDate(convertDateToString(dateFormat, new Date()));
		dailySong.setV(0);
		dailySong.setDateCreated(convertDateToString(dateFormat, new Date()));

		Response response = dsAPI.postVideo(dailySong);
		
		DailySong song = jsonTransformer.convertToDailySongObject(response.getBody().asString());
		
		song  = jsonTransformer.convertToDailySongObject(dsAPI.getVideoSongById(song.getId()).asString());
		assertNotNull(song);
	}
}
