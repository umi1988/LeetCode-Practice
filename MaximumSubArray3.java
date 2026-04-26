package org.example.learn;

/**
 * Need to find out the subarray with the largest sum, and return the subarray.
 * The subarray must contain at least one element.
 */
public class MaximumSubArray3 {
    public int[] maxSubArray(int[] nums){
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxSum = Integer.MIN_VALUE; // Initialize to the smallest integer
        int currentSum = 0;
        int start = 0; // Start index of the current subarray
        int maxStart = 0; // Start index of the maximum subarray
        int maxEnd = 0; // End index of the maximum subarray

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = i;
            }

            if (currentSum < 0) {
                currentSum = 0; // Reset current sum and move start index
                start = i + 1;
            }
        }

        // Return the maximum subarray using the recorded indices
        int[] result = new int[maxEnd - maxStart + 1];
        System.arraycopy(nums, maxStart, result, 0, result.length);
        return result;
    }

    public static void main(String[] args) {
        MaximumSubArray3 solver = new MaximumSubArray3();

        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] res1 = solver.maxSubArray(test1);
        System.out.print("Test 1: ");
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 4 -1 2 1

        int[] test2 = {1};
        int[] res2 = solver.maxSubArray(test2);
        System.out.print("Test 2: ");
        for (int num : res2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 1

        int[] test3 = {5, 4, -1, 7, 8};
        int[] res3 = solver.maxSubArray(test3);
        System.out.print("Test 3: ");
        for (int num : res3) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 5 4 -1 7 8
    }
}
