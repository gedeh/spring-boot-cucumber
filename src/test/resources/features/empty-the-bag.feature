Feature: Emptying the bag

  Scenario: Empty the bag
    Given the bag is not empty
    When I empty the bag
    Then the bag is empty

  Scenario: Add items then empty the bag
    Given the bag is empty
    When I put these items in the bag
      | Name     | Amount |
      | cucumber | 2      |
      | potato   | 1      |
      | broccoli | 1      |
    Then the bag should contain 1 potato
    And the bag should contain 1 broccoli
    And the bag should contain 2 cucumber