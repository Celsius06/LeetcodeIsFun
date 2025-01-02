---
Difficulty: Medium
Utilizable DSAs:
    - Array
    - Hash Table
    - Matrix
---

<!-- problem:start -->
# [1072. Flip Columns For Maximum Number of Equal Rows](https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows)

## Description
<!-- description:start -->
<p>You are given an <code>m x n</code> binary matrix <code>matrix</code>.</p>
<p>You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from <code>0</code> to <code>1</code> or vice versa).</p>
<p>Return <em>the maximum number of rows that have all values equal after some number of flips</em>.</p>

<p><strong class="example">Example 1:</strong></p>
<pre>
<strong>Input:</strong> matrix = [[0,1],[1,1]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> After flipping no values, 1 row has all values equal.
</pre>

<p><strong class="example">Example 2:</strong></p>
<pre>
<strong>Input:</strong> matrix = [[0,1],[1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> After flipping values in the first column, both rows have equal values.
</pre>

<p><strong class="example">Example 3:</strong></p>
<pre>
<strong>Input:</strong> matrix = [[0,0,0],[0,0,1],[1,1,0]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> After flipping values in the first two columns, the last two rows have equal values.
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>matrix[i][j]</code> is either&nbsp;<code>0</code> or <code>1</code>.</li>
</ul>

<!-- description:end -->

## Solutions
<!-- solution:start -->
<!-- tabs:start -->

#### Java
```java
// 1072. Flip Columns For Maximum Number of Equal Rows

// Pattern Matching with BitMask
// Runtime: 24ms

// Complexity:
// + Time: O(m * n), with m is the number of rows and n is the number of columns in the matrix
// + Space: O(m * n), m and n have the same meaning to the time complexity

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patterns = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            StringBuilder pattern = new StringBuilder();
            int firstBit = matrix[i][0];

            for (int j = 0; j < n; j++) {
                pattern.append(matrix[i][j] ^ firstBit);
            }

            String key = pattern.toString();
            patterns.put(key, patterns.getOrDefault(key, 0) + 1);
        }

        int maxRows = 0;
        for (int count : patterns.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
