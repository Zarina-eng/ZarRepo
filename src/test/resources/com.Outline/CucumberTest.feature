@smoke @regression
Feature: Cucumber first test

  Scenario: First  steps
    Given the user school name
    When the user print the name
    Then the user print last name
    And the user print the city
    * the user print the state
    #for cucumber we need to use Gherkin language
  #Feature file starts with Feature:keyword
  #for every test cases we create the Scenario
  # we need to write the Java code Inside StepDefinitions