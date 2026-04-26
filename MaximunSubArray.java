package org.example.learn;

/**
 * For Kadane’s Algorithm, we have to maintain two variables:
 *
 * max_sum: This variable will keep adding the individual elements in the array and hold the sum till that point in the array. Since we discuessed that subarray with negative sum will be discarded, is max_sum becomes negative, we will set it to 0.
 * max_store: This variable will store the maximum value stored in max_sum at any point of time. This will basically help us evaluate what the the maximum sum calculated till any point.
 *
 * Step By Step Algorithm
 *
 * Initialize max_sum to 0 and max_store to Integer.MIN_VALUE
 * Parse through the length of the array nums[]
 * Keep on adding the individual elements in num[] to max_sum like max_sum = max_sum + nums[i]
 * If at any point we find that the max_sum has become greater than the maximum sum previously stored in max_store, we will update max_store with the value in max_sum
 * if(max_sum > max_store) max_store = max_sum
 * If max_sum becomes negative, we will revert it back to 0
 * After the array is fully parsed, return the value in max_store.
 *
 * Time Complexity: O(n). Since we are parsing the array only once
 *
 * Space Complexity: O(1)
 * This is an efficient algorithm for finding the maximum subarray sum. It works well even when the array contains negative numbers, as it resets the current sum to zero whenever it becomes negative, ensuring that we only consider positive contributions to the sum.
 */
public class MaximunSubArray {
    public int maxSubArray(int[] nums) {
        //kadane's algorithm
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum; // Update max sum if current sum is greater
            }
            if (currentSum < 0) {
                currentSum = 0; // Reset current sum if it drops below 0
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximunSubArray solver = new MaximunSubArray();

        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + solver.maxSubArray(test1)); // Expected: 6 (subarray [4,-1,2,1])

        int[] test2 = {1};
        System.out.println("Test 2: " + solver.maxSubArray(test2)); // Expected: 1

        int[] test3 = {5, 4, -1, 7, 8};
        System.out.println("Test 3: " + solver.maxSubArray(test3)); // Expected: 23 (subarray [5,4,-1,7,8])
    }
}
