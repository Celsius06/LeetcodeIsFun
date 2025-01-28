// 2658. Maximum Number of Fish in a Grid
// Difficulty: Medium

// BFS
// Runtime: 5ms (28/01/2025 | 7pm - GMT+7)

// Complexity:
// + Time: O(m * n)
// + Space: O(m * n)

class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxFish = 0;
        int[] dirs = { -1, 0, 1, 0, -1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, bfs(grid, i, j, dirs));
                }
            }
        }
        return maxFish;
    }

    private int bfs(int[][] grid, int i, int j, int[] dirs) {
        int fishCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            if (grid[x][y] > 0) {
                fishCount += grid[x][y];
                grid[x][y] = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dirs[k], ny = y + dirs[k + 1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] > 0) {
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        return fishCount;
    }
}
