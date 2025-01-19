// 1368. Minimum Cost to Make at Least One Valid Path in a Grid
// Difficulty: Hard

// BFS (0-1)
// Runtime: 15ms (18/01/2025 | 11pm - GMT+7)

// Complexity:
// + Time: O(m * n)
// + Space: O(m * n)

import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        deque.offerFirst(new int[] { 0, 0, 0 });

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0], y = cur[1], cost = cur[2];
            if (x == m - 1 && y == n - 1)
                return cost;
            if (visited[x][y])
                continue;
            visited[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + DIRECTIONS[d][0];
                int ny = y + DIRECTIONS[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (grid[x][y] == d + 1) {
                        deque.offerFirst(new int[] { nx, ny, cost }); // No cost
                    } else {
                        deque.offerLast(new int[] { nx, ny, cost + 1 }); // Cost 1
                    }
                }
            }
        }

        return -1;
    }
}
