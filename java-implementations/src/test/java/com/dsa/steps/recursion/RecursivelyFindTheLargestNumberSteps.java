package com.dsa.steps.recursion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;

/**
 * Step definitions for scenario: Recursively find the largest number in an array
 */
public class RecursivelyFindTheLargestNumberSteps {

    private int[] numbers;
    private int max;

    @Given("an array of integers {string} to find max")
    public void an_array_of_integers_to_find_max(String numbers) {
      this.numbers = Arrays.stream(numbers.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    }

    @When("the recursive max algorithm is applied")
    public void the_recursive_max_algorithm_is_applied() {
        this.max = findMaxInt(this.numbers, 0);
    }

    @Then("the largest number should be {string}")
    public void the_largest_number_should_be(String expectedResult) {
      assert this.max == Integer.parseInt(expectedResult);
    }

    private int findMaxInt(final int[] numbers, final int index) {
      //base case
      if (index == numbers.length - 1) {
        return numbers[index];
      } else {
        final int result = findMaxInt(numbers, index + 1);
        return numbers[index] > result ? numbers[index] : result;
      }
    }
}
