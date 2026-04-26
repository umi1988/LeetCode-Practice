package org.example.learn;

public class MaximunSubArray2 {
    public int[] maxSubArray(int[] nums) {
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

        return new int[]{maxStart, maxEnd}; // Return the indices of the maximum subarray
    }

    public static void main(String[] args) {
        MaximunSubArray2 solver = new MaximunSubArray2();

        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] res1 = solver.maxSubArray(test1);
        System.out.println("Test 1: Start index = " + res1[0] + ", End index = " + res1[1]); // Expected: Start index = 3, End index = 6

        int[] test2 = {1};
        int[] res2 = solver.maxSubArray(test2);
        System.out.println("Test 2: Start index = " + res2[0] + ", End index = " + res2[1]); // Expected: Start index = 0, End index = 0

        int[] test3 = {5, 4, -1, 7, 8};
        int[] res3 = solver.maxSubArray(test3);
        System.out.println("Test 3: Start index = " + res3[0] + ", End index = " + res3[1]); // Expected: Start index = 0, End index = 4
    }
}
