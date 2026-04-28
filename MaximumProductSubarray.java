package org.example.learn;

/**
 * Algorithm: Kadane's Algorithm (Modified for Maximum Product Subarray)
 * This optimized version tracks both maximum and minimum products ending at each position to handle negative numbers efficiently.
 * Steps:
 * Initialize maxProduct, minProduct, and result with first element
 * Iterate through array starting from index 1
 * If current number is negative, swap maxProduct and minProduct (since negative × negative = positive)
 * Update maxProduct as the maximum of current number or product with previous max
 * Update minProduct as the minimum of current number or product with previous min
 * Track the overall maximum result
 *
 *
 * Complexity Analysis:
 * Aspect
 * Complexity
 * Time
 * O(n)
 * Space
 * O(1)
 * Time O(n): Single pass through array, each iteration performs constant-time operations (comparison, multiplication, swap)
 * Space O(1): Only uses fixed variables regardless of input size
 * Why this approach?
 * Handles negative numbers by swapping max/min (a negative can multiply a negative product to create a large positive)
 * More efficient than brute force O(n²) that checks all subarrays
 * Better than DP approaches that require O(n) extra space
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                // Swap max and min when current number is negative
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solver = new MaximumProductSubarray();

        int[] test1 = {2, 3, -2, 4};
        System.out.println("Test 1: " + solver.maxProduct(test1)); // Expected: 6

        int[] test2 = {-2, 0, -1};
        System.out.println("Test 2: " + solver.maxProduct(test2)); // Expected: 0

        int[] test3 = {-2, 3, -4};
        System.out.println("Test 3: " + solver.maxProduct(test3)); // Expected: 24
    }
}
