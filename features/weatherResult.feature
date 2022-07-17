Feature: Weather

  Scenario Outline: Weather Result Service

    Given user is launching the weather service page
    When user navigate to weather service page
    And user searches the city for weather "Bournemouth, Bournemouth"
    And user clicks on the search button to search for the city
    And user clicks to open temparature
    Then User verify that tomorrows high temperature is greater than tomorrows low temperature "17"

Examples:
    |City|temp|
    |Bournemouth, Bournemouth|17|