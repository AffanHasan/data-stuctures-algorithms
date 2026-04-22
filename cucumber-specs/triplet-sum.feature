Feature: Triplet Sum (3Sum)
  As a developer
  I want to find all unique triplets in an array that sum to zero
  So that I can practice two-pointer and hashing techniques

  # Triplet Sum Problem: Find all unique triplets [a, b, c] such that a + b + c = 0
  # Solution must not contain duplicate triplets

  Scenario: Find triplets with multiple valid combinations
    Given a triplet sum array of integers "0,-1,2,-3,1"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | -3,1,2    |
      | -1,0,1    |

  Scenario: Find triplets with all positive numbers
    Given a triplet sum array of integers "1,2,3,4,5"
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets with all negative numbers
    Given a triplet sum array of integers "-1,-2,-3,-4,-5"
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets in an empty array
    Given a triplet sum array of integers ""
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets with less than three elements
    Given a triplet sum array of integers "-1,1"
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets with exactly three elements summing to zero
    Given a triplet sum array of integers "-1,0,1"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | -1,0,1    |

  Scenario: Find triplets with exactly three elements not summing to zero
    Given a triplet sum array of integers "1,2,3"
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets with all zeros
    Given a triplet sum array of integers "0,0,0,0"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | 0,0,0     |https://macystech.atlassian.net/browse/ENTDEVOPS-16340https://macystech.atlassian.net/browse/ENTDEVOPS-16340

  Scenario: Find triplets with duplicate input values
    Given a triplet sum array of integers "-1,0,1,2,-1,-4"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | -1,-1,2   |
      | -1,0,1    |

  Scenario: Find triplets with large array
    Given a triplet sum array of integers "-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | -4,-2,6   |
      | -4,0,4    |
      | -4,1,3    |
      | -4,2,2    |
      | -2,-2,4   |
      | -2,0,2    |

  Scenario: Find triplets with multiple duplicates
    Given a triplet sum array of integers "-2,0,1,1,2"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | -2,0,2    |
      | -2,1,1    |

  Scenario: Find triplets with same positive number repeated
    Given a triplet sum array of integers "0,0,0"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet   |
      | 0,0,0     |

  Scenario: Find triplets with two zeros and a non-zero
    Given a triplet sum array of integers "0,0,1"
    When the triplet sum algorithm is applied
    Then the result should be empty

  Scenario: Find triplets with large positive and negative numbers
    Given a triplet sum array of integers "-1000,500,500,0"
    When the triplet sum algorithm is applied
    Then the result should contain the following triplets:
      | Triplet     |
      | -1000,500,500 |
