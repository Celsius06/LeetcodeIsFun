---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Tree
    - Depth-First Search
    - Breadth-First Search
    - Binary Tree
---

<!-- problem:start -->

# [2415. Reverse Odd Levels of Binary Tree](https://leetcode.com/problems/reverse-odd-levels-of-binary-tree)
## Description
<!-- description:start -->
<p>Given the <code>root</code> of a <strong>perfect</strong> binary tree, reverse the node values at each <strong>odd</strong> level of the tree.</p>
<ul>
	<li>For example, suppose the node values at level 3 are <code>[2,1,3,4,7,11,29,18]</code>, then it should become <code>[18,29,11,7,4,3,1,2]</code>.</li>
</ul>
<p>Return <em>the root of the reversed tree</em>.</p>
<p>A binary tree is <strong>perfect</strong> if all parent nodes have two children and all leaves are on the same level.</p>
<p>The <strong>level</strong> of a node is the number of edges along the path between it and the root node.</p>

### Examples
<p><strong class="example">1.</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2415.Reverse%20Odd%20Levels%20of%20Binary%20Tree/images/first_case1.png" style="width: 626px; height: 191px;" />
<pre>
<strong>Input:</strong> root = [2,3,5,8,13,21,34]
<strong>Output:</strong> [2,5,3,8,13,21,34]
<strong>Explanation:</strong> 
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
</pre>

<p><strong class="example">2.</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2415.Reverse%20Odd%20Levels%20of%20Binary%20Tree/images/second_case3.png" style="width: 591px; height: 111px;" />
<pre>
<strong>Input:</strong> root = [7,13,11]
<strong>Output:</strong> [7,11,13]
<strong>Explanation:</strong> 
The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
</pre>

<p><strong class="example">3.</strong></p>
<pre>
<strong>Input:</strong> root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
<strong>Output:</strong> [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
<strong>Explanation:</strong> 
The odd levels have non-zero values.
The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
</pre>

### Constraints
<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 2<sup>14</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>root</code> is a <strong>perfect</strong> binary tree.</li>
</ul>
<!-- description:end -->


<p>&nbsp;</p>


## Solutions
<!-- solution:start -->
#### Java
```java
// 2415. Reverse Odd Levels of Binary Tree

// BFS, Array
// Iterative Level-Order Traversal
// Runtime: 7ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.LinkedList;
import java.util.Queue;

abstract class TreeNode {
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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOddLevel = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] levelNodes = new TreeNode[size];
            int index = 0;

            // Collect nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes[index++] = node;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Reverse values of nodes if the level is odd
            if (isOddLevel) {
                int left = 0, right = levelNodes.length - 1;
                while (left < right) {
                    int temp = levelNodes[left].val;
                    levelNodes[left].val = levelNodes[right].val;
                    levelNodes[right].val = temp;
                    left++;
                    right--;
                }
            }

            isOddLevel = !isOddLevel;
        }

        return root;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
