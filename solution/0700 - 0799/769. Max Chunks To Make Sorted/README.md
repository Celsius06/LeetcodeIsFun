---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Stack
    - Greedy
    - Array
    - Sorting
    - Monotonic Stack
---

<!-- problem:start -->
# [769. Max Chunks To Make Sorted](https://leetcode.com/problems/max-chunks-to-make-sorted)
## Description
<!-- description:start -->
<p>You are given an integer array <code>arr</code> of length <code>n</code> that represents a permutation of the integers in the range <code>[0, n - 1]</code>.</p>
<p>We split <code>arr</code> into some number of <strong>chunks</strong> (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.</p>
<p>Return <em>the largest number of chunks we can make to sort the array</em>.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> arr = [4,3,2,1,0]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn&#39;t sorted.
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> arr = [1,0,2,3,4]
<strong>Output:</strong> 4
<strong>Explanation:</strong>
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
</pre>

### Constraints
<ul>
	<li><code>n == arr.length</code></li>
	<li><code>1 &lt;= n &lt;= 10</code></li>
	<li><code>0 &lt;= arr[i] &lt; n</code></li>
	<li>All the elements of <code>arr</code> are <strong>unique</strong>.</li>
</ul>
<!-- description:end -->


<p>&nbsp;</p>


## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
// 769. Max Chunks To Make Sorted

// Normal Iteration
// Runtime: 1ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
