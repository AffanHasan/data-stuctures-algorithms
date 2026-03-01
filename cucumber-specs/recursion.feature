Feature: Recursion Algorithms
  As a developer
  I want to verify recursion algorithms
  So that I can ensure they correctly solve problems using recursive approaches

  Scenario: Recursively calculate the sum of numbers
    Given a list of numbers "1,2,3,4,5,6,7,8,9,10" for sum calculation
    When the recursive sum algorithm is applied
    Then the calculated sum should be "55"

  Scenario: Recursively count the number of elements in a list
    Given a list of items "5,10,15,20,25,30" to count
    When the recursive count algorithm is applied
    Then the element count should be "6"
