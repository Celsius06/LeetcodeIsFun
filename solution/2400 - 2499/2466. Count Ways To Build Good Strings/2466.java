// 2466. Count Ways To Build Good Strings

// Dynamic Programming
// Runtime: 7ms

// Complexity:
// + Time: O(high)
// + Space: O(high)

class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1; // Base case: one way to form an empty string
        int count = 0;

        for (int i = 0; i <= high; i++) {
            if (dp[i] > 0) {
                if (i + zero <= high) {
                    dp[i + zero] = (dp[i + zero] + dp[i]) % MOD;
                }
                if (i + one <= high) {
                    dp[i + one] = (dp[i + one] + dp[i]) % MOD;
                }
            }
            if (i >= low) {
                count = (count + dp[i]) % MOD;
            }
        }

        return count;
    }
}


