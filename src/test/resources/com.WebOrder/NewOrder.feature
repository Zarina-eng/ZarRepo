Feature: New order validation

  Scenario: Validate new order in WebOrder page
    Given the demoUser enters  username "Tester"
    When the demoUser enters password "test"
    Then the user enter product  info "MyMoney" and "10"
    And the user enter address info "David", "2200 E devon", "Des Plaines", "Illinois", "60656"
    * the user enter payment info "Visa", "2341223111221212", "05/24"
    Then the user validate  success message



