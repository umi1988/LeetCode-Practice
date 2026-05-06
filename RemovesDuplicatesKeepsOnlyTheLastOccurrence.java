package org.example.learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * removes duplicates and keeps only the last occurrence of each element in the order they appear last.
 *       i/p -   arr = {11, 20, 13, 4, 5, 11, 4};
 *       o/p - arr = {20, 13, 5, 11, 4}
 */
public class RemovesDuplicatesKeepsOnlyTheLastOccurrence  {
    public static void main(String[] args) {
        int [] arr = {11, 20, 13, 4, 5, 11, 4};
        ArrayList<Integer> list = Arrays.stream(arr).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Original list: " + list);

        // Map each value to its last index
        Map<Integer, Integer> lastIndexMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            lastIndexMap.put(arr[i], i);
        }

      // Sort entries by last index and collect keys
        List<Integer> result = lastIndexMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("final list: " + result);

       // Convert to array if needed
        // int[] output = result.stream().mapToInt(Integer::intValue).toArray();
       // System.out.println(Arrays.toString(output));
        // Output: [20, 13, 5, 11, 4]




    }
}
