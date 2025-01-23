// 1267. Count Servers that Communicate
// Difficulty: Medium

// Count Row and Column Frequencies
// Runtime: 2ms (23/01/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O(m * n)
// + Space: O(m + n)

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m]; // Counts of servers in each row
        int[] colCount = new int[n]; // Counts of servers in each column

        // First pass: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;

        // Second pass: Check if each server can communicate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}


