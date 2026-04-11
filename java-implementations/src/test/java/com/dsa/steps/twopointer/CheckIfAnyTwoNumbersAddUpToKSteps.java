package com.dsa.steps.twopointer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;

/**
 * Step definitions for Google Interview Problem:
 * Check if any two numbers from the list add up to k.
 *
 * Bonus: Can you do this in one pass?
 */
public class CheckIfAnyTwoNumbersAddUpToKSteps {

    private int[] numbers;
    private int targetK;
    private boolean result;

    @Given("a list of numbers {string} and target k {string}")
    public void a_list_of_numbers_and_target_k(String numbersStr, String targetStr) {
      if (numbersStr.length() == 0) {
        this.numbers = new int[0];
      } else {
        this.numbers = Arrays.stream(numbersStr.split(","))
          .mapToInt(Integer::parseInt)
          .sorted()
          .toArray();
      }
      this.targetK = Integer.parseInt(targetStr);
    }

    @When("the two sum check algorithm is applied")
    public void the_two_sum_check_algorithm_is_applied() {
        this.result = hasPairWithSum(numbers, targetK);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
      assert this.result == Boolean.valueOf(expectedResult);
    }

    /**
     * Checks if any two distinct numbers in the array sum to the target value.
     *
     * Bonus challenge: Can you do this in one pass?
     * Hint: Use a HashSet to track seen numbers as you iterate
     *
     * @param numbers the array of integers (may be unsorted)
     * @param k       the target sum
     * @return true if any two distinct numbers sum to k, false otherwise
     */
    private boolean hasPairWithSum(int[] numbers, int k) {
      int ff, lf;
      if (numbers.length == 1 || numbers.length == 0) {
        return false;
      } else {
        ff = 0;
        lf = numbers.length - 1;
      }
      for (int c=0; c < numbers.length; c++) {
        final int sum = numbers[ff] + numbers[lf];

        if (sum == k) {
          return true;
        } else if (sum > k) {
          lf--;
        } else if (sum < k) {
          ff++;
        }
        if (ff == lf) {
          return false;
        }
      }
      return false;
    }
}
