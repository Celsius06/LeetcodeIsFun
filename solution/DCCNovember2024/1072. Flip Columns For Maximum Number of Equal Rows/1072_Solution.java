// 1072. Flip Columns For Maximum Number of Equal Rows

// Pattern Matching with BitMask
// Runtime: 23ms

// Complexity:
// + Time: O(m * n), with m is the number of rows and n is the number of columns in the matrix
// + Space: O(m * n), m and n have the same meaning to the time complex.

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patterns = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            StringBuilder pattern = new StringBuilder();
            int firstBit = matrix[i][0];

            for (int j = 0; j < n; j++) {
                pattern.append(matrix[i][j] ^ firstBit);
            }

            String key = pattern.toString();
            patterns.put(key, patterns.getOrDefault(key, 0) + 1);
        }

        int maxRows = 0;
        for (int count : patterns.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}