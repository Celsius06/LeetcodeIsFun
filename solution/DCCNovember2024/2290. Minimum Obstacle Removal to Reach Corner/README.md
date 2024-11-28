---
Difficulty: Hard
Utilizable DSAs:
    - Breadth-First Search
    - Graph
    - Array
    - Matrix
    - Shortest Path
    - Heap (Priority Queue)
---

<!-- problem:start -->
# [2290. Minimum Obstacle Removal to Reach Corner](https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner)
## Description
<!-- description:start -->
<p>You are given a <strong>0-indexed</strong> 2D integer array <code>grid</code> of size <code>m x n</code>. Each cell has one of two values:</p>
<ul>
	<li><code>0</code> represents an <strong>empty</strong> cell,</li>
	<li><code>1</code> represents an <strong>obstacle</strong> that may be removed.</li>
</ul>
<p>You can move up, down, left, or right from and to an empty cell.</p>
<p>Return <em>the <strong>minimum</strong> number of <strong>obstacles</strong> to <strong>remove</strong> so you can move from the upper left corner </em><code>(0, 0)</code><em> to the lower right corner </em><code>(m - 1, n - 1)</code>.</p>

## Examples
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2290.Minimum%20Obstacle%20Removal%20to%20Reach%20Corner/images/example1drawio-1.png" style="width: 605px; height: 246px;" />
<pre>
<strong>Input:</strong> grid = [[0,1,1],[1,1,0],[1,1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2290.Minimum%20Obstacle%20Removal%20to%20Reach%20Corner/images/example1drawio.png" style="width: 405px; height: 246px;" />
<pre>
<strong>Input:</strong> grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>2 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> <strong>or</strong> <code>1</code>.</li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 0</code></li>
</ul>
<!-- description:end -->


## Solutions
<!-- solution:start -->
#### Java
```java
// 2290. Minimum Obstacle Removal to Reach Corner

// BFS
// Runtime: 51ms

// Complexity:
// + Time: O(m * n)
// + Space: O(m * n)

import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newDist = dist[x][y] + grid[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) {
                            deque.offerFirst(new int[]{nx, ny});
                        } else {
                            deque.offerLast(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
```
<!-- solution:end -->
<!-- problem:end -->
