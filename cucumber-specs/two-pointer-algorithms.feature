Feature: Two Pointer Algorithms
  As a developer
  I want to verify two pointer algorithms
  So that I can ensure they correctly solve problems using two pointer techniques

  Scenario: Find pair sum in a sorted array with valid pair
    Given a sorted array of integers "-5,-2,3,4,6" and target "7"
    When the pair sum algorithm is applied
    Then the result indexes should be "[2, 3]"

  Scenario: Find pair sum in an empty array
    Given a sorted array of integers "" and target "0"
    When the pair sum algorithm is applied
    Then the result indexes should be "[]"

  Scenario: Find pair sum in a single element array
    Given a sorted array of integers "1" and target "1"
    When the pair sum algorithm is applied
    Then the result indexes should be "[]"

  Scenario: Find pair sum in a two element array with valid pair
    Given a sorted array of integers "2,3" and target "5"
    When the pair sum algorithm is applied
    Then the result indexes should be "[0, 1]"

  Scenario: Find pair sum in a two element array with no valid pair
    Given a sorted array of integers "2,4" and target "5"
    When the pair sum algorithm is applied
    Then the result indexes should be "[]"

  Scenario: Find pair sum with duplicate values that sum to target
    Given a sorted array of integers "2,2,3" and target "5"
    When the pair sum algorithm is applied
    Then the result indexes should be "[0, 2]"

  Scenario: Find pair sum with negative number in the target pair
    Given a sorted array of integers "-1,2,3" and target "2"
    When the pair sum algorithm is applied
    Then the result indexes should be "[0, 2]"

  Scenario: Find pair sum with both numbers being negative
    Given a sorted array of integers "-3,-2,-1" and target "-5"
    When the pair sum algorithm is applied
    Then the result indexes should be "[0, 1]"
