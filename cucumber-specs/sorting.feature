Feature: Sorting Algorithms
  As a developer
  I want to verify sorting algorithms
  So that I can ensure they sort data correctly

  Scenario: Sort a CSV string of numbers in numerical order using selection sort
    Given an unsorted CSV string "343,44,67677,3,4,7,9,22,55,1,30,20,101"
    When the selection sort algorithm is applied
    Then the sorted CSV string should be "1,3,4,7,9,20,22,30,44,55,101,343,67677"

  Scenario: Sort an array of integers using quick sort algorithm
    Given a list of unsorted integers "50,23,9,18,23,32,12,5,50,9"
    When quick sort is performed on the list
    Then the list should be sorted as "5,9,9,12,18,23,23,32,50,50"
