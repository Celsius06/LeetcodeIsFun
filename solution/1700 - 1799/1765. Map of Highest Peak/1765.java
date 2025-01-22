// 1765. Map of Highest Peak
// Difficulty: Medium

// BFS
// Runtime: 45ms (22/01/2025 | 8pm - GMT+7)

// Complexity:
// + Time: O(m * n)
// + Space: O(m * n)

import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length; // Dimensions of the grid
        int[][] height = new int[m][n]; // Resultant height matrix

        // Initialize height matrix with -1 to mark unvisited cells
        for (int[] row : height) {
            Arrays.fill(row, -1);
        }

        Deque<int[]> deque = new ArrayDeque<>(); // Queue for BFS traversal

        // Step 1: Add all water cells to the queue and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) { // If the cell is water
                    deque.offer(new int[] { i, j }); // Add to queue
                    height[i][j] = 0; // Set height to 0
                }
            }
        }

        // Directions array for moving to adjacent cells (North, South, East, West)
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // Step 2: Perform BFS to propagate heights
        while (!deque.isEmpty()) {
            int[] cell = deque.poll(); // Get the current cell from the queue
            int x = cell[0], y = cell[1]; // Current cell coordinates

            // Check all 4 possible directions
            for (int[] dir : directions) {
                int nx = x + dir[0]; // New x-coordinate
                int ny = y + dir[1]; // New y-coordinate

                // If the new cell is within bounds and unvisited
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1; // Set the new cell's height
                    deque.offer(new int[] { nx, ny }); // Add the new cell to the queue
                }
            }
        }

        // Step 3: Return the resultant height matrix
        return height;
    }
}
