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
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1);   // Initially, all cells are unvisited
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    deque.offer(new int[]{i, j});
                    height[i][j] = 0; 
                }
            }
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Propagation for BFS
        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;
                    deque.offer(new int[]{nx, ny});
                }
            }
        }
        return height;
    }
}

