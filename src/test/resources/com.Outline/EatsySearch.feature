Feature: Validate search in Etsy
  Background: it will run before each scenario
    Given  the user goes tio the Etsy
 @etsy @tt
    Scenario: Validation  of search in etsy
      When the user search int etsy  with "winter hat"
      Then the user validate title "Winter hat | Etsy" and url" winter"

  @etsy
  Scenario: Validation  of search in etsy 2
    When the user search int etsy  with "hat"
    Then the user validate title "Hat | Etsy" and url "hat"

  @etsy @tt
  Scenario: Validation  of search in etsy 3
    When the user search int etsy with "winter soldier"
    Then the user validate title "Winter soldier | Etsy" and url "soldier"

