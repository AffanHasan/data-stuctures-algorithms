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

  # Google Interview Problem: Check if any two numbers add up to k
  # This works on unsorted arrays and returns boolean
  Scenario: Check if any two numbers add up to target k - valid pair exists
    Given a list of numbers "10,15,3,7" and target k "17"
    When the two sum check algorithm is applied
    Then the result should be "true"

  Scenario: Check if any two numbers add up to target k - no valid pair
    Given a list of numbers "10,15,3,8" and target k "17"
    When the two sum check algorithm is applied
    Then the result should be "false"

  Scenario: Check if any two numbers add up to target k - empty array
    Given a list of numbers "" and target k "5"
    When the two sum check algorithm is applied
    Then the result should be "false"

  Scenario: Check if any two numbers add up to target k - single element
    Given a list of numbers "10" and target k "10"
    When the two sum check algorithm is applied
    Then the result should be "false"

  Scenario: Check if any two numbers add up to target k - same number used twice
    Given a list of numbers "8,3,5" and target k "10"
    When the two sum check algorithm is applied
    Then the result should be "false"

  Scenario: Check if any two numbers add up to target k - with duplicates
    Given a list of numbers "5,5,3" and target k "10"
    When the two sum check algorithm is applied
    Then the result should be "true"
