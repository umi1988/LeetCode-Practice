package org.example.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * Determines if an array contains any duplicate values.
 * Uses a hash map to track seen numbers for O(n) time and O(n) space complexity.
 *
 *
 * Time Complexity: O(n)
 * The loop iterates through each element in the array once
 * HashMap operations (containsKey and put) average O(1)
 * Overall: n iterations × O(1) per iteration = O(n)
 * Space Complexity: O(n)
 * In the worst case (no duplicates), the HashMap stores all n elements
 * Maximum space used is proportional to the input size
 * This is an efficient approach for detecting duplicates. An alternative using a HashSet would have identical complexity but slightly better space efficiency in practice since you only need to track presence, not count.
 */
public class ContainsDuplicates
{
   public boolean containsDuplicate(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
         for(Integer i : nums){
              if(map.containsKey(i)) {
                  return true;
              }else {
                    map.put(i, 1);
              }
         }
     return false;
   }

    public static void main(String[] args) {
        ContainsDuplicates solver = new ContainsDuplicates();

        System.out.println("Test 1: " + solver.containsDuplicate(new int[]{1, 2, 3, 1})); // Expected: true
        System.out.println("Test 2: " + solver.containsDuplicate(new int[]{1, 2, 3, 4})); // Expected: false
        System.out.println("Test 3: " + solver.containsDuplicate(new int[]{1, 1, 1, 3})); // Expected: true
    }
}
