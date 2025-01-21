// 2017. Grid Game
// Difficulty: Medium

// Greedy, Prefix Sum
// Runtime: 5ms (21/01/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] topPrefix = new long[n + 1];
        long[] bottomPrefix = new long[n + 1];
        
        for (int j = 1; j <= n; ++j) {
            topPrefix[j] = topPrefix[j - 1] + grid[0][j - 1];
            bottomPrefix[j] = bottomPrefix[j - 1] + grid[1][j - 1];
        }
        
        long ans = Long.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            long s1 = topPrefix[n] - topPrefix[j + 1]; // Remaining top
            long s2 = bottomPrefix[j];                 // Covered bottom
            ans = Math.min(ans, Math.max(s1, s2));
        }
        return ans;
    }
}

