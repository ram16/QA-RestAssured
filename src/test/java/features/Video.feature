Feature: Songs API Test 
	In order to test rest services Song And Playlist
As a Register user 
I want to specify the rest services test conditions

	# GET Request - Returns list of videos in Songs
Scenario: 

	When  user sends a GET request for list of videos InSongs with "getAllvideosongsURL" 
	Then  status code should be_200 
	And   Response should be list of videos "Json" 
	
	# GET Request - Returns data about a single video in Songs
Scenario: Get Request with VideoID 
	 
	When  user sends a GET request for single video "getVideoSongById " 
	Then  status code should be_201
	And   Response should be "Json" 
	
	# POST Request - Create a video in Songs
Scenario: Post Request 
	 
	When  user sends a POST request for Create  video "postVideo" 
	And with following details
		|key|value|
		|artist|Lady Gaga|
		|song|Poker face||
		|publishDate|2017-09-01|
	Then status code should be_201 
	And  Response should be "Json" 
	
	# PATCH Request - Will update video in song
Scenario: Patch Request 
	 
	When  user sends a PATCH request for update a video "patchVideoById" 
	Then  status code should be_501 
	And   Response should be NOT implemented_ "Not Implemented" 
	
	# DELETE Request - Will delete video in song
Scenario: Delete Request 
	 
	When  user sends DELETE a video request "deleteVideoById" 
	Then  status code should be_204 
	And  Response should be NOT implemented_ "Not Implemented" 
	
	
	# GET Request - Returns list of videos in Playlist
Scenario: 
	 
	When  user sends a GET request for list of Playlist "getAllPlaylistSongs" 
	Then  status code should be_200 
	And   Response should be list of videos "Json" 
	
	# GET Request - Returns data about a single video in Playlist
Scenario: Get Request with PlaylistID 
	
	When  user sends a GET request for single Playlist "getPlaylistVideoSongById" 
	Then  Response should be list of videos_date_hidden_conditions_ "Json"
	Then  status code should be_200 
	And   Response should be list of videos "Json" 
	
	# POST Request - Create a Playlist in Songs
Scenario: Post Request 
	 
	When  user sends a POST request for Create Playlist "postVideoList" 
	And with following 
		|key|value|
		|desc|My first playlist.|
		|title|My List|
	Then status code should be_201 
	And  Response should be "Json" 
	
	# PATCH Request - Will Changes in Playlist
Scenario: Patch Request 
	
	When  user sends a PATCH request values Operations by id's "patchPlaylistById" 
	Then  status code should be_501 
	And   Response should be NOT implemented_ "Not Implemented" 
	
	# DELETE Request - Will delete video in Playlist
Scenario: Delete Request 
	 
	When  user sends DELETE a video request "deletePlaylistById" 
	Then  status code should be_204 
	And   Response should be NOT implemented_ "Not Implemented"