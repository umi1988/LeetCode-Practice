package org.example.learn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    /**
     * Find two indices such that nums[i] + nums[j] == target.
     * Uses a single-pass hash map to achieve O(n) time and O(n) extra space.
     *
     * Complexity:
     *  - Time: O(n) where n = nums.length
     *  - Space: O(n) for the hash map
     *
     * @param nums input array
     * @param target target sum
     * @return array of two indices [i, j]
     * @throws IllegalArgumentException if input is null, has fewer than 2 elements, or there is no solution
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input must contain at least two numbers");
        }

        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            // store the current value and its index
            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] res1 = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Test 1: " + res1[0] + ", " + res1[1]); // Expected: 0, 1

//        int[] res2 = solver.twoSum(new int[]{3, 2, 4}, 6);
//        System.out.println("Test 2: " + res2[0] + ", " + res2[1]); // Expected: 1, 2
//
//        int[] res3 = solver.twoSum(new int[]{3, 3}, 6);
//        System.out.println("Test 3: " + res3[0] + ", " + res3[1]); // Expected: 0, 1
    }
}
