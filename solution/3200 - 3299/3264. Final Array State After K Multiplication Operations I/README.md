---
difficulty: Easy
Utilizable DSAs/Methods/Approaches:
    - Array
    - Math
    - Simulation
    - Heap (Priority Queue)
---


<!-- problem:start -->
# [3264. Final Array State After K Multiplication Operations I](https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i)
## Description
<!-- description:start -->
<p>You are given an integer array <code>nums</code>, an integer <code>k</code>, and an integer <code>multiplier</code>.</p>
<p>You need to perform <code>k</code> operations on <code>nums</code>. In each operation:</p>
<ul>
	<li>Find the <strong>minimum</strong> value <code>x</code> in <code>nums</code>. If there are multiple occurrences of the minimum value, select the one that appears <strong>first</strong>.</li>
	<li>Replace the selected minimum value <code>x</code> with <code>x * multiplier</code>.</li>
</ul>
<p>Return an integer array denoting the <em>final state</em> of <code>nums</code> after performing all <code>k</code> operations.</p>

### Examples
<p><strong class="example">1.</strong></p>
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,1,3,5,6], k = 5, multiplier = 2</span></p>
<p><strong>Output:</strong> <span class="example-io">[8,4,6,5,6]</span></p>
<p><strong>Explanation:</strong></p>

<table>
	<tbody>
		<tr>
			<th>Operation</th>
			<th>Result</th>
		</tr>
		<tr>
			<td>After operation 1</td>
			<td>[2, 2, 3, 5, 6]</td>
		</tr>
		<tr>
			<td>After operation 2</td>
			<td>[4, 2, 3, 5, 6]</td>
		</tr>
		<tr>
			<td>After operation 3</td>
			<td>[4, 4, 3, 5, 6]</td>
		</tr>
		<tr>
			<td>After operation 4</td>
			<td>[4, 4, 6, 5, 6]</td>
		</tr>
		<tr>
			<td>After operation 5</td>
			<td>[8, 4, 6, 5, 6]</td>
		</tr>
	</tbody>
</table>
</div>

<p><strong class="example">2.</strong></p>
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2], k = 3, multiplier = 4</span></p>
<p><strong>Output:</strong> <span class="example-io">[16,8]</span></p>
<p><strong>Explanation:</strong></p>
<table>
	<tbody>
		<tr>
			<th>Operation</th>
			<th>Result</th>
		</tr>
		<tr>
			<td>After operation 1</td>
			<td>[4, 2]</td>
		</tr>
		<tr>
			<td>After operation 2</td>
			<td>[4, 8]</td>
		</tr>
		<tr>
			<td>After operation 3</td>
			<td>[16, 8]</td>
		</tr>
	</tbody>
</table>
</div>

### Constraints
<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 10</code></li>
	<li><code>1 &lt;= multiplier &lt;= 5</code></li>
</ul>
<!-- description:end -->


<p>&nbsp;</p>


## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq
            = new PriorityQueue<>((i, j) -> nums[i] - nums[j] == 0 ? i - j : nums[i] - nums[j]);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(i);
        }
        while (k-- > 0) {
            int i = pq.poll();
            nums[i] *= multiplier;
            pq.offer(i);
        }
        return nums;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
