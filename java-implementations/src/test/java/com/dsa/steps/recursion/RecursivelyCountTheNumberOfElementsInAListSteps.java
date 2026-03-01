package com.dsa.steps.recursion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;

/**
 * Step definitions for scenario: Recursively count the number of elements in a list
 */
public class RecursivelyCountTheNumberOfElementsInAListSteps {

    private int[] items;
    private int count;

    @Given("a list of items {string} to count")
    public void a_list_of_numbers(String numbers) {
      this.items = Arrays.stream(numbers.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
    }

    @When("the recursive count algorithm is applied")
    public void the_recursive_count_algorithm_is_applied() {
      this.count = countNumberOfElements(this.items, 0);
    }

    @Then("the element count should be {string}")
    public void the_result_should_be(String expectedResult) {
      assert this.count == Integer.parseInt(expectedResult);
    }

    private int countNumberOfElements(final int[] items, final int index) {
      // base case
      if (index == items.length - 1) {
        return 1;
      } else {
        return 1 + countNumberOfElements(items, index + 1);
      }
    }
}
