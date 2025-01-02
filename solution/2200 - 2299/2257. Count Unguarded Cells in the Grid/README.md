---
Difficulty: Medium
Utilizable DSAs:
    - Array
    - Matrix
    - Simulation
---

<!-- problem:start -->
# [2257. Count Unguarded Cells in the Grid](https://leetcode.com/problems/count-unguarded-cells-in-the-grid)

## Description
<!-- description:start -->
<p>You are given two integers <code>m</code> and <code>n</code> representing a <strong>0-indexed</strong> <code>m x n</code> grid. You are also given two 2D integer arrays <code>guards</code> and <code>walls</code> where <code>guards[i] = [row<sub>i</sub>, col<sub>i</sub>]</code> and <code>walls[j] = [row<sub>j</sub>, col<sub>j</sub>]</code> represent the positions of the <code>i<sup>th</sup></code> guard and <code>j<sup>th</sup></code> wall respectively.</p>
<p>A guard can see <b>every</b> cell in the four cardinal directions (north, east, south, or west) starting from their position unless <strong>obstructed</strong> by a wall or another guard. A cell is <strong>guarded</strong> if there is <strong>at least</strong> one guard that can see it.</p>
<p>Return<em> the number of unoccupied cells that are <strong>not</strong> <strong>guarded</strong>.</em></p>

<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2257.Count%20Unguarded%20Cells%20in%20the%20Grid/images/example1drawio2.png" style="width: 300px; height: 204px;" />
<pre>
<strong>Input:</strong> m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.
</pre>
<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2257.Count%20Unguarded%20Cells%20in%20the%20Grid/images/example2drawio.png" style="width: 200px; height: 201px;" />
<pre>
<strong>Input:</strong> m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= guards.length, walls.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>2 &lt;= guards.length + walls.length &lt;= m * n</code></li>
	<li><code>guards[i].length == walls[j].length == 2</code></li>
	<li><code>0 &lt;= row<sub>i</sub>, row<sub>j</sub> &lt; m</code></li>
	<li><code>0 &lt;= col<sub>i</sub>, col<sub>j</sub> &lt; n</code></li>
	<li>All the positions in <code>guards</code> and <code>walls</code> are <strong>unique</strong>.</li>
</ul>
<!-- description:end -->


## Solutions
<!-- solution:start -->
<!-- tabs:start -->

#### Java
```java
// 2257. Count Unguarded Cells in the Grid

// 2D Grid Simulation
// Runtime: 25ms

// Complexity:
// + Time: O(m * n + k)
// + Space: O(m * n)

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        // Mark guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        // Directions: up, right, down, left
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        // Mark cells visible to guards
        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int x = guard[0], y = guard[1];
                while (true) {
                    x += dir[0];
                    y += dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 'W' || grid[x][y] == 'G') {
                        break;
                    }
                    if (grid[x][y] == 0) { // Mark only unoccupied cells
                        grid[x][y] = 'X';
                    }
                }
            }
        }

        // Count unoccupied, unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }
        return unguarded;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
