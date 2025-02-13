// 2342. Max Sum of a Pair With Equal Sum of Digits
// Difficulty: Medium
// Link: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

// DSAs
// Methods & Approaches
// Runtime: 37ms (13/02/2025 | 10pm - GMT+7)

// Complexity Analysis
// + Time: O(log(n) where n is the maximum number in the input array.
// + Space: O(n) where n is the number of elements in the input array.

class Solution {
    public int maximumSum(int[] nums) {
        // Map to store the maximum number for each digit sum
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize the maximum pair sum as -1 (default if no valid pair is found)
        int max = -1;

        // Iterate over each number in the array
        for (int num : nums) {
            int sum = 0; // This will hold the sum of the digits of the current number
            int n = num; // Copy of num to compute its digit sum without modifying num

            // Compute the digit sum of 'num'
            while (n > 0) {
                sum += n % 10; // Add the last digit to 'sum'
                n /= 10; // Remove the last digit from 'n'
            }

            // If there is already a number with the same digit sum in the map,
            // then a valid pair is found; update the max sum accordingly.
            if (map.containsKey(sum)) {
                // The pair's sum is the current number 'num' plus the largest number with the
                // same digit sum.
                max = Math.max(max, map.get(sum) + num);
            }

            // Update the map for this digit sum:
            // We store the maximum number encountered so far for this digit sum.
            map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
        }

        // Return the maximum pair sum found, or -1 if no such pair exists.
        return max;
    }
}
