Feature: scenario outline test

  Background: Etsy navigation
    Given the user goes tio the Etsy

    # Scenario Scenario Outline: and Scenario Template:  are same
  #Examples and Scenarios:  are same

  @etsyOutline
  Scenario Outline: Etsy search validation with outline
    When  the user search int etsy  with "<searchValue>"
    Then the user validate title "<title>" and url "<etsyUrl>"
    Examples:
      | searchValue    | title                 | etsyUrl |
      | winter hat     | Winter hat \|Etsy     | winter  |
      | hat            | Hat \| Eaty           | hat     |
      | winter soldier | Winter soldier \|Etsy | soldier |

#@DataProvider
#public object[][] getData(){
