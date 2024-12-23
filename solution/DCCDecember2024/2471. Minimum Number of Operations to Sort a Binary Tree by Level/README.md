---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Tree
    - Breadth-First Search
    - Binary Tree
---

<!-- problem:start -->
# [2471. Minimum Number of Operations to Sort a Binary Tree by Level](https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level)
## Description
<!-- description:start -->
<p>You are given the <code>root</code> of a binary tree with <strong>unique values</strong>.</p>
<p>In one operation, you can choose any two nodes <strong>at the same level</strong> and swap their values.</p>
<p>Return <em>the minimum number of operations needed to make the values at each level sorted in a <strong>strictly increasing order</strong></em>.</p>
<p>The <strong>level</strong> of a node is the number of edges along the path between it and the root node<em>.</em></p>

### Examples
<p><strong class="example">1.</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2471.Minimum%20Number%20of%20Operations%20to%20Sort%20a%20Binary%20Tree%20by%20Level/images/image-20220918174006-2.png" style="width: 500px; height: 324px;" />
<pre>
<strong>Input:</strong> root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
- Swap 4 and 3. The 2<sup>nd</sup> level becomes [3,4].
- Swap 7 and 5. The 3<sup>rd</sup> level becomes [5,6,8,7].
- Swap 8 and 7. The 3<sup>rd</sup> level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
</pre>

<p><strong class="example">2.</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2471.Minimum%20Number%20of%20Operations%20to%20Sort%20a%20Binary%20Tree%20by%20Level/images/image-20220918174026-3.png" style="width: 400px; height: 303px;" />
<pre>
<strong>Input:</strong> root = [1,3,2,7,6,5,4]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
- Swap 3 and 2. The 2<sup>nd</sup> level becomes [2,3].
- Swap 7 and 4. The 3<sup>rd</sup> level becomes [4,6,5,7].
- Swap 6 and 5. The 3<sup>rd</sup> level becomes [4,5,6,7].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
</pre>

<p><strong class="example">3.</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2471.Minimum%20Number%20of%20Operations%20to%20Sort%20a%20Binary%20Tree%20by%20Level/images/image-20220918174052-4.png" style="width: 400px; height: 274px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Each level is already sorted in increasing order so return 0.
</pre>

### Constraints
<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>All the values of the tree are <strong>unique</strong>.</li>
</ul>

<!-- description:end -->





<p>&nbsp;</p>






## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
// 2471. Minimum Number of Operations to Sort a Binary Tree by Level

// BFS, Queue, ArrayList, Map
// Runtime: 71ms

// Complexity:
// + Time: O(n log(n))
// + Space: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalOperations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Collect all node values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Calculate minimum swaps for the current level
            totalOperations += calculateMinimumSwaps(level);
        }

        return totalOperations;
    }

    private int calculateMinimumSwaps(List<Integer> level) {
        int n = level.size();
        int[] arr = level.stream().mapToInt(i -> i).toArray();

        // Map values to their sorted indices
        Map<Integer, Integer> indexMap = new LinkedHashMap<>();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        for (int i = 0; i < n; i++) {
            indexMap.put(sortedArr[i], i);
        }

        // Replace array values with their sorted indices
        for (int i = 0; i < n; i++) {
            arr[i] = indexMap.get(level.get(i));
        }

        // Count cycles for minimum swaps
        boolean[] visited = new boolean[n];
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == i)
                continue;

            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j];
                cycleLength++;
            }

            swapCount += (cycleLength - 1);
        }

        return swapCount;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
