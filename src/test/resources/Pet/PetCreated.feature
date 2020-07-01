@api
Feature: Pet Create Practice
  Scenario: Posting
When user creates a pet with 424, "Rex", "do not touch"
Then the status code is  "OK"
And pet with 424, "Rex", status is created

