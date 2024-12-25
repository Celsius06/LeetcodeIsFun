---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Tree
    - Depth-First Search
    - Breadth-First Search
    - Binary Tree
---



<!-- problem:start -->
# [515. Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row)
## Description
<!-- description:start -->
<p>Given the <code>root</code> of a binary tree, return <em>an array of the largest value in each row</em> of the tree <strong>(0-indexed)</strong>.</p>

### Examples
<p><strong class="example">1.</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0515.Find%20Largest%20Value%20in%20Each%20Tree%20Row/images/largest_e1.jpg" style="width: 300px; height: 172px;" />
<pre>
<strong>Input:</strong> root = [1,3,2,5,3,null,9]
<strong>Output:</strong> [1,3,9]
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> [1,3]
</pre>

### Constraints
<ul>
	<li>The number of nodes in the tree will be in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
<!-- description:end -->




<p>&nbsp;</p>




## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
// 515. Find Largest Value in Each Tree Row

// BFS
// Runtime: 2ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int t = Integer.MIN_VALUE;
            for (int i = q.size(); i > 0; --i) {
                TreeNode node = q.poll();
                t = Math.max(t, node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
