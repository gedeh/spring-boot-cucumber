Feature: Emptying the bag

  Scenario: Empty the bag
    Given the bag is not empty
    When I empty the bag
    Then the bag is empty
