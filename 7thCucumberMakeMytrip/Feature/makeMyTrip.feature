Feature: Flight Search on MakeMyTrip

  Scenario: MakeMyTrip RoundTrip
    Given User launch Chrome Browser and enter URL "URL"
    And User clicks on Flights module and Select RoundTrip option
    When User Enter From location with "<HYD>" and "<To location>"
    And Select DEPARTURE Date and RETRUN Date
    And Click on Search Button
    Then Verify the Search page is displayed as expected
