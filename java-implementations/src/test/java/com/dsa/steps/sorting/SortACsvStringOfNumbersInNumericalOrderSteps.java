package com.dsa.steps.sorting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;

/**
 * Step definitions for scenario: Sort a CSV string of numbers in numerical order
 */
public class SortACsvStringOfNumbersInNumericalOrderSteps {

    private LinkedList<Integer> numbers;
    private int[] sorted;

    @Given("an unsorted CSV string {string}")
    public void an_unsorted_csv_string(String csvString) {
      this.numbers = Arrays.stream(csvString.split(","))
                            .map(Integer::valueOf)
                            .collect(Collectors.toCollection(LinkedList::new));
    }

    @When("the selection sort algorithm is applied")
    public void the_sorting_algorithm_is_applied() {
      this.sorted = new int[numbers.size()];
      selectionSort(numbers, sorted);
    }

    @Then("the sorted CSV string should be {string}")
    public void the_sorted_csv_string_should_be(String expectedCsvString) {
      final var sortedString = Arrays.stream(sorted)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
      assert sortedString.equals(expectedCsvString);
    }

    record SmallestItem(int index, int value) {}

    private void selectionSort(LinkedList<Integer> original, int[] sorted) {
      final int numbersSize = numbers.size();
      for (int c = 0; c < numbersSize; c++) {
        SmallestItem si = findSmallestInLinkedList(original);
        sorted[c] = si.value;
        original.remove(si.index);
      }
    }

    private SmallestItem findSmallestInLinkedList(LinkedList ll) {
      SmallestItem si = new SmallestItem(0, (int) ll.get(0));
      for (int c = 0; c < ll.size(); c++) {
        int val = (int) ll.get(c);
        if ( si.value > val ) {
          si = new SmallestItem(c, val);
        }
      }
      return si;
    }
}
