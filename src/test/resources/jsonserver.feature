Feature: Test JSON-Server API

  Scenario:
  Get all profiles
    Given Endpoint to Profiles
    When I send a request with GET Method to all profiles
    Then I should get all profiles

  Scenario Outline:
  Get one profiles
    Given Endpoint to Profiles
    When I send a request with GET Method to one profile with "<postId>"
    Then I should get one profile with "<postId>" and "<name>"
    Examples:
      | postId | name   |
      | 13     | George |

  Scenario Outline:
  Create one profile with given name and postId
    Given Endpoint to Profiles
    When I send a request with POST Method with given "<name>" and "<postId>"
    Then I should have profile with "<name>" and "<postId>" created

    Examples:
      | postId | name   |
      | 12     | Murat  |
      | 13     | George |
