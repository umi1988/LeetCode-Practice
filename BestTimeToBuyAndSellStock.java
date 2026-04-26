package org.example.learn;

public class BestTimeToBuyAndSellStock {
    /**
     * Finds the maximum profit from a single buy and sell of stock given daily prices.
     * Uses a single pass to track the minimum price and calculate potential profits.
     *
     * Complexity:
     *  - Time: O(n) where n = prices.length
     *  - Space: O(1) for constant extra space
     *
     * @param prices array of daily stock prices
     * @return maximum profit achievable, or 0 if no profit is possible
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // No profit possible with less than 2 prices
        }

        int minPrice = Integer.MAX_VALUE; // Track the lowest price seen so far
        int maxProfit = 0; // Track the maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update minimum price
            } else {
                int profit = price - minPrice; // Calculate potential profit
                if (profit > maxProfit) {
                    maxProfit = profit; // Update maximum profit if this is better
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        int[] test1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + solver.maxProfit(test1)); // Expected: 5

//        int[] test2 = {7, 6, 4, 3, 1};
//        System.out.println("Test 2: " + solver.maxProfit(test2)); // Expected: 0
//
//        int[] test3 = {1, 2, 3, 4, 5};
//        System.out.println("Test 3: " + solver.maxProfit(test3)); // Expected: 4
    }
}
