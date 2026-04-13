package com.dsa.steps.dailycoding;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Step definitions for Daily Coding Problem 2 - Product of Array Except Self
 *
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 *
 * Follow-up: what if you can't use division?
 */
public class ProductOfArrayExceptSelfSteps {

    private int[] inputArray;
    private int[] resultArray;

    @Given("an array of integers {string}")
    public void an_array_of_integers(String arrayStr) {
      this.inputArray = Arrays.stream(arrayStr.split(","))
        .mapToInt(Integer::valueOf)
        .toArray();
    }

    @When("the product of array except self algorithm is applied")
    public void the_product_of_array_except_self_algorithm_is_applied() {
        this.resultArray = productExceptSelf(inputArray);
    }

    @When("the product of array except self without division algorithm is applied")
    public void the_product_of_array_except_self_without_division_algorithm_is_applied() {
        this.resultArray = productExceptSelfWithoutDivision(inputArray);
    }

    @Then("the resulting array should be {string}")
    public void the_resulting_array_should_be(String expectedResult) {
        final String result = Arrays.stream(this.resultArray)
          .boxed()
          .map(String::valueOf)
          .collect(Collectors.joining(","));
        assert result.equals(expectedResult);
    }

    /**
     * Calculates the product of array except self using division.
     *
     * Approach:
     * 1. Calculate the total product of all non-zero elements
     * 2. Count the number of zeros
     * 3. Handle different cases based on zero count:
     *    - Zero count = 0: result[i] = totalProduct / input[i]
     *    - Zero count = 1: result[i] = totalProduct if input[i] == 0, else 0
     *    - Zero count > 1: all results are 0
     *
     * @param nums the input array of integers
     * @return an array where each element is the product of all other elements
     */
    private int[] productExceptSelf(int[] nums) {
      int product = 0;
      if (nums.length == 0) {
        return nums;
      } else if (nums.length == 1) {
        return nums;
      } else if (nums.length > 1) {
        product = nums[0] * nums[1];
        for (int c=2; c < nums.length; c++) {
          product = (product) * nums[c];
        }
      }
      final int[] result = new int[nums.length];
      for (int c=0; c < nums.length; c++) {
        if (nums[c] == 0 ) {
          result[c] = 0;
        } else if (product == 0) {
          result[c] = nums[c];
        } else {
        result[c] = product / nums[c];
        }
      }
      return result;
    }

    /**
     * Calculates the product of array except self WITHOUT using division.
     *
     * Follow-up approach using prefix and suffix products:
     * 1. Create a result array
     * 2. First pass (left to right): result[i] stores product of all elements before i
     * 3. Second pass (right to left): multiply result[i] by product of all elements after i
     *
     * Example for [1, 2, 3, 4]:
     * - Prefix products: [1, 1, 2, 6] (product of elements before i)
     * - Suffix products: [24, 12, 4, 1] (product of elements after i)
     * - Result: [24, 12, 8, 6]
     *
     * @param nums the input array of integers
     * @return an array where each element is the product of all other elements
     */
    private int[] productExceptSelfWithoutDivision(int[] nums) {
      int[] result = new int[nums.length];
      if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
        return nums;
      }
      for (int c=0; c < nums.length; c++) {
        if (c == 0) {
          result[0] = Arrays.stream(nums, 1, nums.length)
            .reduce(1, (a, b) -> a*b);
        } else if (c == nums.length - 1) {
          result[c] = Arrays.stream(nums, 0, nums.length - 1)
            .reduce(1, (a, b) -> a*b);
        } else {
          int p1 = Arrays.stream(nums, 0, c)
            .reduce(1, (a,b) -> a*b);
          int p2 = Arrays.stream(nums, c + 1, nums.length)
            .reduce(1, (a,b) -> a*b);
          result[c] = p1 * p2;
        }
      }
      return result;
    }
}
