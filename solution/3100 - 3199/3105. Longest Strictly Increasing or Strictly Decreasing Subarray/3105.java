// 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
// Difficulty: Easy

// DP Arrays
// Runtime: 0ms (03/02/2025 | 4pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = 1;
        dec[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
            if (nums[i] < nums[i - 1]) {
                dec[i] = dec[i - 1] + 1;
            } else {
                dec[i] = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc[i], dec[i]));
        }
        return maxLen;
    }
}
