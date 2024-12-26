// 494. Target Sum

// Dynamic Programming, Recursion
// Runtime: 2ms

// Complexity:
// + Time: O(n * target)
// + Space: O(target)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If target + sum is odd or target is not reachable
        if ((target + sum) % 2 != 0 || target > sum || target < -sum) {
            return 0;
        }

        int subsetSum = (target + sum) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: 1 way to make sum 0

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
