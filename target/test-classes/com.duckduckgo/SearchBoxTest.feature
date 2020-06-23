Feature: DuckDuckGo search testing

  Scenario: Validation of Search in DuckDuckGo
    Given the user goes to the duckduckgo
    When  the user send the key Selenium keyword
    Then the user click search button
    And the user validate title contains the selenium keyword
    And the user validate url  contains the selenium keyword
    * the user validate all results contain the selenium keyword

    #create new scenario to test the search function with different value
  #use the parameter in steps

@smoke @techtorial1 @tech
  Scenario: Validation of Search with TestNG
    Given the user goes to the duckduckgo
    When the user search with "TestNG"
    Then the user click search button
    And the user validate title contains "TestNG"
    And the user validate all result contains "TestNG"
    And  the user validate number of result is 10



@smoke @techtorial2 @test
  Scenario: Validation of Search with Docker
    Given the user goes to the duckduckgo
    When the user search with "Docker"
    Then the user click search button
    And the user validate title contains "Docker"
    And the user validate all result contains "Docker"
    And  the user validate number of result is 10
