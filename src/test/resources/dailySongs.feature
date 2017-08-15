@test
Feature: Posts CRUD operations

	
  Scenario Outline: Creating a Post
    Given User is haviNew song details "<userId>" "<id>" "<title>" "<body>"
    When Add new post details
    Then Post added successfully
    Examples: 
      | userId | id  | title    | body      |
      | 122    | 224 | football | excellent |

  Scenario Outline: Retrieving an existing Post
    Given Post Identifier as "<id>"
    When Get the post details
    Then Verify the retrieved post details with id
    Examples: 
      | id  |
      | 224 |

  Scenario Outline: Updating a Post
    Given Post Id "<id>" to update "<userId>" "<title>" "<body>"
    When Update the post details
    Then Get the post details as modified "<userId>" "<id>" "<title>" "<body>"
    Examples:
    | userId | id  | title    | body      |
    | 122    | 224 | football | very good | 
     
  Scenario Outline: Deleting a Post
    Given Post Identifier as "<id>"
    When Delete the post details
    Then Post deleted successfully
    Examples: 
      | id  |
      | 224 |