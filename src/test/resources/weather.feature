Feature: Test Weather API
  Test Weather API
  Scenario:
    Given I have Open Weather Map Url
    When I call API with city name "London"
    Then I should get weather info for "London"

  Scenario Outline:   Test Weather API
    Given I have Open Weather Map Url
    When I call API with city name "<city>"
    Then I should get weather info for "<city>"

    Examples:
      | city      |
      |    London |
      |    Bishkek|
      |Washington |