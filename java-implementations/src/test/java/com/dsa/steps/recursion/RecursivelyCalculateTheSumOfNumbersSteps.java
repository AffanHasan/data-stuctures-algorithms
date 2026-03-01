package com.dsa.steps.recursion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.stream.Stream;
import java.util.Arrays;

/**
 * Step definitions for scenario: Recursively calculate the sum of numbers
 */
public class RecursivelyCalculateTheSumOfNumbersSteps {

    private String numbers = null;
    private int sum;

    @Given("a list of numbers {string} for sum calculation")
    public void a_list_of_numbers(String numbers) {
      this.numbers = numbers;
    }

    @When("the recursive sum algorithm is applied")
    public void the_recursive_sum_algorithm_is_applied() {
      final int[] numbers = Arrays.stream(this.numbers.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
      sum = recursiveSum(numbers, 0);
    }

    @Then("the calculated sum should be {string}")
    public void the_result_should_be(String expectedResult) {
      assert sum == Integer.parseInt(expectedResult);
    }

    private int recursiveSum(int[] numbers, int startIndex) {
      // base case
      if (startIndex + 1 == numbers.length) {
        return numbers[startIndex];
      }
      // recursive case
      else if (startIndex + 1 < numbers.length) {
        return numbers[startIndex] + recursiveSum(numbers, startIndex + 1);
      } else {
        return 0;
      }
    }
}
