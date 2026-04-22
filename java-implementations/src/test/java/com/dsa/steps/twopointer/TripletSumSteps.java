package com.dsa.steps.twopointer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Step definitions for Triplet Sum (3Sum) Problem
 *
 * Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0.
 * The solution must not contain duplicate triplets.
 * Each triplet can be arranged in any order, and the output can be returned in any order.
 *
 * Example:
 * Input: nums = [0, -1, 2, -3, 1]
 * Output: [[-3, 1, 2], [-1, 0, 1]]
 */
public class TripletSumSteps {

    private int[] inputArray;
    private List<List<Integer>> resultTriplets;

    @Given("a triplet sum array of integers {string}")
    public void a_triplet_sum_array_of_integers(String arrayStr) {
        // Parse the input string to int array
        // If arrayStr is empty, inputArray should be an empty array
        // Otherwise, split by comma and parse each element as int
        if (arrayStr.length() == 0) {
            this.inputArray = new int[0];
        } else {
            this.inputArray = Arrays.stream(arrayStr.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        }
    }

    @When("the triplet sum algorithm is applied")
    public void the_triplet_sum_algorithm_is_applied() {
        // TODO: Implement the triplet sum algorithm
        // Hint: Sort the array first, then use a loop + two-pointer approach
        // Skip duplicates to ensure unique triplets
        this.resultTriplets = findTriplets(inputArray);
    }

    @Then("the result should be empty")
    public void the_result_should_be_empty() {
        // TODO: Assert that resultTriplets is empty
        assert this.resultTriplets.size() == 0;
    }

    @Then("the result should contain the following triplets:")
    public void the_result_should_contain_the_following_triplets(DataTable dataTable) {
        // Parse expected triplets from DataTable
        List<String> expectedTripletStrings = dataTable.asMaps().stream()
            .map(row -> row.get("Triplet"))
            .collect(Collectors.toList());
        
        // Convert expected triplets to sorted lists for comparison
        List<List<Integer>> expectedTriplets = expectedTripletStrings.stream()
            .map(this::parseAndSortTriplet)
            .sorted((a, b) -> {
                // Compare lists lexicographically for consistent ordering
                for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(a.size(), b.size());
            })
            .collect(Collectors.toList());
        
        // Normalize actual result - sort each triplet internally, then sort the list of triplets
        List<List<Integer>> actualTriplets = resultTriplets.stream()
            .map(triplet -> triplet.stream().sorted().collect(Collectors.toList()))
            .sorted((a, b) -> {
                for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(a.size(), b.size());
            })
            .collect(Collectors.toList());
        
        // Assert sizes match
        assert expectedTriplets.size() == actualTriplets.size() 
            : String.format("Expected %d triplets but found %d", expectedTriplets.size(), actualTriplets.size());
        
        // Assert each triplet matches
        for (int i = 0; i < expectedTriplets.size(); i++) {
            List<Integer> expected = expectedTriplets.get(i);
            List<Integer> actual = actualTriplets.get(i);
            assert expected.equals(actual) 
                : String.format("Expected triplet %s but found %s at position %d", expected, actual, i);
        }
    }

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * Approach using Sorting + Two Pointers:
     * 1. Sort the input array
     * 2. Iterate through the array with index i
     * 3. For each i, use two pointers (left = i+1, right = n-1) to find pairs
     *    that sum to -nums[i]
     * 4. Skip duplicates to avoid duplicate triplets:
     *    - Skip if nums[i] == nums[i-1] (same first element)
     *    - Skip duplicates when moving left/right pointers
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1) excluding output
     *
     * Alternative Approach using HashSet:
     * - Fix first element, use HashSet to find pairs
     * - More complex to avoid duplicates
     *
     * @param nums the input array of integers
     * @return a list of unique triplets where each triplet sums to zero
     */

    private List<List<Integer>> findTriplets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) return result;

        Arrays.sort(nums);  // Already sorted in @Given, but good practice

        for (int c = 0; c < nums.length - 2; c++) {
            // Skip duplicate first elements
            if (c > 0 && nums[c] == nums[c - 1]) continue;

            int il = c + 1;           // Left pointer
            int ir = nums.length - 1; // Right pointer

            while (il < ir) {
                int sum = nums[c] + nums[il] + nums[ir];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[c], nums[il], nums[ir]));

                    // Skip duplicates
                    while (il < ir && nums[il] == nums[il + 1]) il++;
                    while (il < ir && nums[ir] == nums[ir - 1]) ir--;

                    il++;
                    ir--;
                } else if (sum < 0) {
                    il++;
                } else {
                    ir--;
                }
            }
        }
        return result;
    }

    /**
     * Helper method to convert a triplet string to a sorted list of integers.
     * Useful for comparing triplets regardless of internal order.
     *
     * @param tripletStr a string like "-3,1,2"
     * @return a sorted list of integers
     */
    private List<Integer> parseAndSortTriplet(String tripletStr) {
        return Arrays.stream(tripletStr.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
    }
}
