---
Difficulty: Hard
Utilizable DSAs:
    - Depth-First Search
    - Graph
    - Eulerian Circuit
---

<!-- problem:start -->
# [2097. Valid Arrangement of Pairs](https://leetcode.com/problems/valid-arrangement-of-pairs)
## Description
<!-- description:start -->
<p>You are given a <strong>0-indexed</strong> 2D integer array <code>pairs</code> where <code>pairs[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>. An arrangement of <code>pairs</code> is <strong>valid</strong> if for every index <code>i</code> where <code>1 &lt;= i &lt; pairs.length</code>, we have <code>end<sub>i-1</sub> == start<sub>i</sub></code>.</p>
<p>Return <em><strong>any</strong> valid arrangement of </em><code>pairs</code>.</p>
<p><strong>Note:</strong> The inputs will be generated such that there exists a valid arrangement of <code>pairs</code>.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> pairs = [[5,1],[4,5],[11,9],[9,4]]
<strong>Output:</strong> [[11,9],[9,4],[4,5],[5,1]]
<strong>Explanation:
</strong>This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
end<sub>0</sub> = 9 == 9 = start<sub>1</sub> 
end<sub>1</sub> = 4 == 4 = start<sub>2</sub>
end<sub>2</sub> = 5 == 5 = start<sub>3</sub>
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> pairs = [[1,3],[3,2],[2,1]]
<strong>Output:</strong> [[1,3],[3,2],[2,1]]
<strong>Explanation:</strong>
This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
end<sub>0</sub> = 3 == 3 = start<sub>1</sub>
end<sub>1</sub> = 2 == 2 = start<sub>2</sub>
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
</pre>

<p><strong class="example">3.</strong></p>
<pre>
<strong>Input:</strong> pairs = [[1,2],[1,3],[2,1]]
<strong>Output:</strong> [[1,2],[2,1],[1,3]]
<strong>Explanation:</strong>
This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
end<sub>0</sub> = 2 == 2 = start<sub>1</sub>
end<sub>1</sub> = 1 == 1 = start<sub>2</sub>
</pre>

### Constraints
<ul>
	<li><code>1 &lt;= pairs.length &lt;= 10<sup>5</sup></code></li>
	<li><code>pairs[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub>, end<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>start<sub>i</sub> != end<sub>i</sub></code></li>
	<li>No two pairs are exactly the same.</li>
	<li>There <strong>exists</strong> a valid arrangement of <code>pairs</code>.</li>
</ul>
<!-- description:end -->

<p>&nbsp;</p>

## Solutions
<!-- solution:start -->
### 1/ Hierholzer's Algorithm
<!-- tabs:start -->
#### Java
```java
// 2097. Valid Arrangement of Pairs

// Hierholzer's Algorithm
// Runtime: 169ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build adjacency list and degree maps
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        
        // Step 2: Find the starting node
        int startNode = pairs[0][0]; // Default start
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }
        
        // Step 3: Perform Hierholzer's algorithm
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).pop());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }
        
        // Step 4: Return result
        Collections.reverse(result);
        return result.toArray(new int[0][0]);
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
