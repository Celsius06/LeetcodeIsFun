---
Difficulty: Hard
Utilizable DSAs:
    - Breadth-First Search
    - Array
    - Matrix
---

<!-- problem:start -->
# [773. Sliding Puzzle](https://leetcode.com/problems/sliding-puzzle)

## Description
<!-- description:start -->
<p>On an <code>2 x 3</code> board, there are five tiles labeled from <code>1</code> to <code>5</code>, and an empty square represented by <code>0</code>. A <strong>move</strong> consists of choosing <code>0</code> and a 4-directionally adjacent number and swapping it.</p>
<p>The state of the board is solved if and only if the board is <code>[[1,2,3],[4,5,0]]</code>.</p>
<p>Given the puzzle board <code>board</code>, return <em>the least number of moves required so that the state of the board is solved</em>. If it is impossible for the state of the board to be solved, return <code>-1</code>.</p>

<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0700-0799/0773.Sliding%20Puzzle/images/slide1-grid.jpg" style="width: 244px; height: 165px;" />
<pre>
<strong>Input:</strong> board = [[1,2,3],[4,0,5]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Swap the 0 and the 5 in one move.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0700-0799/0773.Sliding%20Puzzle/images/slide2-grid.jpg" style="width: 244px; height: 165px;" />
<pre>
<strong>Input:</strong> board = [[1,2,3],[5,4,0]]
<strong>Output:</strong> -1
<strong>Explanation:</strong> No number of moves will make the board solved.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0700-0799/0773.Sliding%20Puzzle/images/slide3-grid.jpg" style="width: 244px; height: 165px;" />
<pre>
<strong>Input:</strong> board = [[4,1,2],[5,0,3]]
<strong>Output:</strong> 5
<strong>Explanation:</strong> 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>board.length == 2</code></li>
	<li><code>board[i].length == 3</code></li>
	<li><code>0 &lt;= board[i][j] &lt;= 5</code></li>
	<li>Each value <code>board[i][j]</code> is <strong>unique</strong>.</li>
</ul>

<!-- description:end -->


## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
// 773. Sliding Puzzle

// Breadth-First Search, Array, Matrix
// Runtime: 12ms

// Complexity:
// + Time: O(720)
// + Space: O(720)


class Solution {
    private String[] t = new String[6];
    private int[][] board;

    public int slidingPuzzle(int[][] board) {
        this.board = board;
        String start = gets();
        String end = "123450";
        if (end.equals(start)) {
            return 0;
        }
        Set<String> vis = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer(start);
        vis.add(start);
        int ans = 0;
        while (!q.isEmpty()) {
            ++ans;
            for (int n = q.size(); n > 0; --n) {
                String x = q.poll();
                setb(x);
                for (String y : next()) {
                    if (y.equals(end)) {
                        return ans;
                    }
                    if (!vis.contains(y)) {
                        vis.add(y);
                        q.offer(y);
                    }
                }
            }
        }
        return -1;
    }

    private String gets() {
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                t[i * 3 + j] = String.valueOf(board[i][j]);
            }
        }
        return String.join("", t);
    }

    private void setb(String s) {
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = s.charAt(i * 3 + j) - '0';
            }
        }
    }

    private int[] find0() {
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }

    private List<String> next() {
        int[] p = find0();
        int i = p[0], j = p[1];
        int[] dirs = {-1, 0, 1, 0, -1};
        List<String> res = new ArrayList<>();
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < 2 && y >= 0 && y < 3) {
                swap(i, j, x, y);
                res.add(gets());
                swap(i, j, x, y);
            }
        }
        return res;
    }

    private void swap(int i, int j, int x, int y) {
        int t = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = t;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
