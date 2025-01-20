// 2661. First Completely Painted Row or Column
// Difficulty: Medium

// Runtime: 23ms (20/01/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(m * n)
// + Space: O(m * n)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> idx = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                idx.put(mat[i][j], new int[] { i, j });
            }
        }
        int[] row = new int[m];
        int[] col = new int[n];
        for (int k = 0;; ++k) {
            int[] x = idx.get(arr[k]);
            int i = x[0], j = x[1];
            ++row[i];
            ++col[j];
            if (row[i] == n || col[j] == m) {
                return k;
            }
        }
    }
}
