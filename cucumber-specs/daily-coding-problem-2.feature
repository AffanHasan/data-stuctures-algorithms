Feature: Daily Coding Problem 2 - Product of Array Except Self
  As a developer
  I want to solve the product of array except self problem
  So that I can practice array manipulation algorithms

  # Uber Interview Problem
  # Given an array of integers, return a new array such that each element at index i
  # of the new array is the product of all the numbers in the original array except the one at i.

  Scenario: Product of array except self with positive numbers
    Given an array of integers "1,2,3,4,5"
    When the product of array except self algorithm is applied
    Then the resulting array should be "120,60,40,30,24"

  Scenario: Product of array except self with smaller array
    Given an array of integers "3,2,1"
    When the product of array except self algorithm is applied
    Then the resulting array should be "2,3,6"

  Scenario: Product of array except self with two elements
    Given an array of integers "4,5"
    When the product of array except self algorithm is applied
    Then the resulting array should be "5,4"

  Scenario: Product of array except self with negative numbers
    Given an array of integers "-1,2,3"
    When the product of array except self algorithm is applied
    Then the resulting array should be "6,-3,-2"

  Scenario: Product of array except self with all negative numbers
    Given an array of integers "-1,-2,-3"
    When the product of array except self algorithm is applied
    Then the resulting array should be "6,3,2"

  # Follow-up: What if you can't use division?
  Scenario: Product of array except self without using division
    Given an array of integers "1,2,3,4,5"
    When the product of array except self without division algorithm is applied
    Then the resulting array should be "120,60,40,30,24"

  Scenario: Product of array except self without division with zero
    Given an array of integers "1,0,2"
    When the product of array except self without division algorithm is applied
    Then the resulting array should be "0,2,0"

  Scenario: Product of array except self without division with large array
    Given an array of integers "2,3,4,5"
    When the product of array except self without division algorithm is applied
    Then the resulting array should be "60,40,30,24"
