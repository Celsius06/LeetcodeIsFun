---
Difficulty: Hard
Potential Data Structures & Algorithms:
    - Queue
    - Array
    - Binary Search
    - Prefix Sum
    - Sliding Window
    - Monotonic Queue
    - Heap (Priority Queue)
---

<!-- problem:start -->
# [862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k)

## Description
<!-- description:start -->
<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the length of the shortest non-empty <strong>subarray</strong> of </em><code>nums</code><em> with a sum of at least </em><code>k</code>. If there is no such <strong>subarray</strong>, return <code>-1</code>.</p>
<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> 1
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2], k = 4
<strong>Output:</strong> -1
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [2,-1,2], k = 3
<strong>Output:</strong> 3
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

<!-- description:end -->

<p>&nbsp;</p>

## Solutions

<!-- solution:start -->

### Solution 1

#### Java

```java
// 862. Shortest Subarray with Sum at Least K

// Queue, Array, Binary Search, Prefix Sum, Sliding Window, Monotonic Queue, Heap (Priority Queue)
// Runtime: 39ms

// Complexity
// + Time: O(n * |k|)
// + Space: O(n)

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; ++i) {
            while (!q.isEmpty() && s[i] - s[q.peek()] >= k) {
                ans = Math.min(ans, i - q.poll());
            }
            while (!q.isEmpty() && s[q.peekLast()] >= s[i]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return ans > n ? -1 : ans;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
