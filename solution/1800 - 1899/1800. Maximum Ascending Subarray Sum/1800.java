// 1800. Maximum Ascending Subarray Sum
// Difficulty: Easy

// Single Pass
// Runtime: 0ms (04/02/2025 | 11am - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];
            }
        }
        return Math.max(maxSum, currentSum);
    }
}
