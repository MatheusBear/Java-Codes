/**
 * Challenge By: Leetcode
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Used a HashMap to decrease the Time Complexity from O(n^2) to O(n)
 * 
 * Time: 1 ms
 */

package Challenge;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                result[0] = numToIndex.get(complement);
                result[1] = i;
                return result;
            }
            numToIndex.put(nums[i], i);
        }

        return result;
    }
}