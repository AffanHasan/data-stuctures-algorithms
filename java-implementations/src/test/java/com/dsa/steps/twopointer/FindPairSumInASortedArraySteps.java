package com.dsa.steps.twopointer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

/**
 * Step definitions for scenario: Find pair sum in a sorted array
 */
public class FindPairSumInASortedArraySteps {

    private int[] nums;
    private int target;
    private int[] result;

    @Given("a sorted array of integers {string} and target {string}")
    public void a_sorted_array_of_integers_and_target(String arrayStr, String targetStr) {
      if (arrayStr.length() == 0) {
        this.nums = new int[0];
      } else {
        this.target = Integer.parseInt(targetStr);
        this.nums =  arrayStr.length() == 0 ? new int[0] : Arrays.stream(arrayStr.split(","))
          .mapToInt(Integer::parseInt) // int stream
          .toArray();
      }
    }

    @When("the pair sum algorithm is applied")
    public void the_pair_sum_algorithm_is_applied() {
        // TODO: Implement the two-pointer pair sum algorithm
        // Hint: Use left and right pointers starting at beginning and end
        // Move pointers inward based on sum comparison with target
        this.result = pairSumSorted(nums, target);
    }

    @Then("the result indexes should be {string}")
    public void the_result_indexes_should_be(String expectedResult) {
        // TODO: Compare the result array with expected output
        // Format expectedResult (e.g., "[2, 3]" or "[]") and compare with this.result
        final Pattern pattern1 = Pattern.compile("\\[(?<first>\\d), (?<second>\\d)\\]");
        final Pattern pattern2 = Pattern.compile("\\[\\]");
        final Matcher matcher1 = pattern1.matcher(expectedResult);
        final Matcher matcher2 = pattern2.matcher(expectedResult);
        if (matcher1.matches()) {
          assert this.result[0] == Integer.parseInt(matcher1.group("first"));
          assert this.result[1] == Integer.parseInt(matcher1.group("second"));
        } else if (matcher2.matches()) {
          assert this.result.length == 0;
        }

    }

    /**
     * Finds a pair of indices in a sorted array whose values sum to the target.
     * Uses the two-pointer technique for O(n) time complexity.
     *
     * @param nums   the sorted array of integers
     * @param target the target sum
     * @return an array of two indices, or empty array if no pair found
     */
    private int[] pairSumSorted(int[] nums, int target) {
        // TODO: Implement the two-pointer algorithm
        // 1. Initialize left = 0, right = nums.length - 1
        // 2. While left < right:
        //    - Calculate sum = nums[left] + nums[right]
        //    - If sum == target, return [left, right]
        //    - If sum < target, increment left (need larger sum)
        //    - If sum > target, decrement right (need smaller sum)
        // 3. Return empty array if no pair found
        return this.recursiveSolution(nums, target, 0, nums.length - 1);
    }

    private int[] recursiveSolution(int[] nums, int target, int fixedLeftIndex, int fixedRightIndex) {
      if ((fixedRightIndex == fixedLeftIndex) || nums.length == 0) {
        return new int[0];
      } else {
        final int sum = nums[fixedLeftIndex] + nums[fixedRightIndex];
        if (sum > target) { // decrement right most index
          return recursiveSolution(nums, target, (fixedLeftIndex), (--fixedRightIndex));
        } else if (sum < target) {// increment left most index
          return recursiveSolution(nums, target, (++fixedLeftIndex), (fixedRightIndex));
        } else { // base case
          return new int[]{fixedLeftIndex, fixedRightIndex};
        }
      }
    }
}
