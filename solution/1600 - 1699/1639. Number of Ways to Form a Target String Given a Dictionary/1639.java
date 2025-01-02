// 1639. Number of Ways to Form a Target String Given a Dictionary

// 2D Array
// Dynamic Programming
// Runtime: 37ms (31/12/2024)

// Complexity:
// + Time: O(k * n + m * n)
// + Space: O(m * n)

import java.util.Arrays;

class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[m + 1][n + 1];
        Arrays.fill(f[0], 1);
        int[][] cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i][j - 1] + f[i - 1][j - 1] * cnt[j - 1][target.charAt(i - 1) - 'a'];
                f[i][j] %= mod;
            }
        }
        return (int) f[m][n];
    }
}

