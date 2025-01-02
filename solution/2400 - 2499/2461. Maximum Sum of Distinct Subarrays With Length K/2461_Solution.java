// 2461. Maximum Sum of Distinct Subarrays With Length K

// HashSet, Sliding Window
// Runtime: 33ms

// Complexity
// + Time: O(n)
// + Space: O(k)

/* For avoiding errors in code editor */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Set<Integer> uniqueElements = new HashSet<>();

        int start = 0; // Start of the window
        for (int end = 0; end < nums.length; end++) {
            // Add the current element to the window
            currentSum += nums[end];

            // Handle duplicates
            while (uniqueElements.contains(nums[end])) {
                currentSum -= nums[start];
                uniqueElements.remove(nums[start]);
                start++;
            }

            uniqueElements.add(nums[end]);

            // Check if the window is valid (size k)
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Slide the window by removing the leftmost element
                currentSum -= nums[start];
                uniqueElements.remove(nums[start]);
                start++;
            }
        }

        return maxSum;
    }
}
