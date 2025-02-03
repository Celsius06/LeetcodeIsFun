// 827. Making A Large Island
// Difficulty: Hard

// DSAs
// Methods & Approaches
// Runtime: 73ms (03/02/2025 | 4pm - GMT+7)

// Complexity:
// + Time: O(n^2)
// + Space: O(n^2)

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // Map island id -> area
        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2; // start labeling islands from 2

        // Step 1: Label each island and compute its area.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        // If there is no 0, return entire grid area.
        if (areaMap.size() == 0)
            return 1;

        int maxArea = 0;
        // Consider every cell, if it is 0 then try to flip it.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int potentialArea = 1;
                    // Use a set to avoid counting the same island twice.
                    Set<Integer> seen = new HashSet<>();
                    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                    for (int[] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            int id = grid[x][y];
                            if (id > 1 && seen.add(id)) {
                                potentialArea += areaMap.get(id);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, potentialArea);
                }
            }
        }
        // If maxArea remains 0, then grid was all 1's.
        return maxArea == 0 ? n * n : maxArea;
    }

    // DFS helper that labels the island with islandId and returns its area.
    private int dfs(int[][] grid, int i, int j, int islandId) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1)
            return 0;
        grid[i][j] = islandId;
        int area = 1;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dirs) {
            area += dfs(grid, i + d[0], j + d[1], islandId);
        }
        return area;
    }
}
