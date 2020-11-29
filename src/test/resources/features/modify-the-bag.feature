Feature: Modify item in bag

  As a user
  I want to remove item from my bag
  so that I can change items in my bag

  @wip
  Scenario: Remove one thing in the bag
    Given the bag is empty
    When I put 1 potato in the bag
    And I remove 1 potato from the bag
    Then the bag is empty

  @wip
  Scenario: Remove few things from the bag
    Given the bag is empty
    When I put 1 potato in the bag
    And I put 2 cucumber in the bag
    When I remove 1 potato from the bag
    When I remove 1 cucumber from the bag
    And the bag should contain 1 cucumber