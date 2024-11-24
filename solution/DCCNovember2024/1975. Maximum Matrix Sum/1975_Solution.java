// 1975. Maximum Matrix Sum

// Array, Matrix
// Runtime: 5ms

// Complexity:
// + Time: O(n^2)
// + Space: O(1)

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                int absValue = Math.abs(value);

                totalSum += absValue;
                if (value < 0)
                    negativeCount++;
                if (absValue < minAbsValue)
                    minAbsValue = absValue;
            }
        }

        if ((negativeCount & 1) == 1) {
            totalSum -= 2L * minAbsValue;
        }

        return totalSum;
    }
}
