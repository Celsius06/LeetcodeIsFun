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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for (int n = q.size(); n > 0; --n) {
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans += f(t);
        }
        return ans;
    }

    private int f(List<Integer> t) {
        int n = t.size();
        List<Integer> alls = new ArrayList<>(t);
        alls.sort((a, b) -> a - b);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            m.put(alls.get(i), i);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = m.get(t.get(i));
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            while (arr[i] != i) {
                swap(arr, i, arr[i]);
                ++ans;
            }
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
