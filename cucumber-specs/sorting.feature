Feature: Sorting Algorithms
  As a developer
  I want to verify sorting algorithms
  So that I can ensure they sort data correctly

  Scenario: Sort a CSV string of numbers in numerical order
    Given an unsorted CSV string "343,44,67677,3,4,7,9,22,55,1,30,20,101"
    When the sorting algorithm is applied
    Then the sorted CSV string should be "1,3,4,7,9,20,22,30,44,55,101,343,67677"
