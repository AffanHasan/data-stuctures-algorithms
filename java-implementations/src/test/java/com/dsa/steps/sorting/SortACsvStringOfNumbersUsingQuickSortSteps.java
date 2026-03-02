package com.dsa.steps.sorting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

/**
 * Step definitions for scenario: Sort an array of integers using quick sort algorithm
 */
public class SortACsvStringOfNumbersUsingQuickSortSteps {

    private List<Integer> integers;
    private String sortedIntegers;

    @Given("a list of unsorted integers {string}")
    public void a_list_of_unsorted_integers(String csvString) {
      this.integers = Arrays.stream(csvString.split(","))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    }

    @When("quick sort is performed on the list")
    public void quick_sort_is_performed_on_the_list() {
      final List<Integer> sortedIntegersArray = quickSortIntArray(this.integers);
      this.sortedIntegers = sortedIntegersArray.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
    }

    @Then("the list should be sorted as {string}")
    public void the_list_should_be_sorted_as(String expectedCsvString) {
      assert expectedCsvString.equals(this.sortedIntegers);
    }

    private List<Integer> quickSortIntArray(final List<Integer> intArray) {
      // base case
      if (intArray.size() < 2) {
        return intArray;
      } else {
        int pivotIndex = RandomGenerator.getDefault()
          .nextInt(0, intArray.size());
        final List<Integer> arr1 = new ArrayList<>();
        final List<Integer> arr2 = new ArrayList<>();
        final List<Integer> pivotList = new ArrayList<>();
        intArray.stream()
          .forEach(x -> {
            if (x < intArray.get(pivotIndex)) {
              arr1.add(x);
            } else if (x > intArray.get(pivotIndex)) {
              arr2.add(x);
            } else {
              pivotList.add(x);
            }
          });
        return Stream.concat(Stream.concat(quickSortIntArray(arr1).stream(), pivotList.stream()), quickSortIntArray(arr2).stream())
          .collect(Collectors.toList());
      } 
    }
}
