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

    @Given("a list of numbers {string}")
    public void a_list_of_numbers(String numbers) {
      this.numbers = numbers;
    }

    @When("the recursive sum algorithm is applied")
    public void the_recursive_sum_algorithm_is_applied() {
      final int[] numbers = Arrays.stream(this.numbers.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
      sum = recursiveSum(numbers);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expectedResult) {
      assert sum == Integer.parseInt(expectedResult);
    }

    private int recursiveSum(int[] numbers) {
      // base case
      if (numbers.length == 1) {
        return numbers[0];
      }
      // recursive case
      else if (numbers.length > 1) {
        return numbers[0] + recursiveSum(Arrays.copyOfRange(numbers, 1, numbers.length));
      } else {
        return 0;
      }
    }
}
