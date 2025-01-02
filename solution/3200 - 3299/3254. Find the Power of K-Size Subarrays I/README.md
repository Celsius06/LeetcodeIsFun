---
Difficulty: Medium
Involved Data Structures & Algorithms:
    - Array
    - Sliding Window
---

<!-- problem:start -->

# [3254. Find the Power of K-Size Subarrays I](https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i)

## Description

<!-- description:start -->

<p>You are given an array of integers <code>nums</code> of length <code>n</code> and a <em>positive</em> integer <code>k</code>.</p>

<p>The <strong>power</strong> of an array is defined as:</p>

<ul>
	<li>Its <strong>maximum</strong> element if <em>all</em> of its elements are <strong>consecutive</strong> and <strong>sorted</strong> in <strong>ascending</strong> order.</li>
	<li>-1 otherwise.</li>
</ul>

<p>You need to find the <strong>power</strong> of all <span data-keyword="subarray-nonempty">subarrays</span> of <code>nums</code> of size <code>k</code>.</p>

<p>Return an integer array <code>results</code> of size <code>n - k + 1</code>, where <code>results[i]</code> is the <em>power</em> of <code>nums[i..(i + k - 1)]</code>.</p>

<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4,3,2,5], k = 3</span></p>

<p><strong>Output:</strong> [3,4,-1,-1,-1]</p>

<p><strong>Explanation:</strong></p>

<p>There are 5 subarrays of <code>nums</code> of size 3:</p>

<ul>
	<li><code>[1, 2, 3]</code> with the maximum element 3.</li>
	<li><code>[2, 3, 4]</code> with the maximum element 4.</li>
	<li><code>[3, 4, 3]</code> whose elements are <strong>not</strong> consecutive.</li>
	<li><code>[4, 3, 2]</code> whose elements are <strong>not</strong> sorted.</li>
	<li><code>[3, 2, 5]</code> whose elements are <strong>not</strong> consecutive.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2,2,2,2], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">[-1,-1]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,2,3,2,3,2], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[-1,3,-1,3,-1]</span></p>
</div>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

<!-- description:end -->

<p>&nbsp;</p>

## Solutions

<!-- solution:start -->
<!-- tabs:start -->

#### Java

```java
// 3254. Find the Power of K-Size Subarrays I
// Brute Force
// Runtime: 2ms

// Complexity
// + Time: O(n * k)
// + Space: O(n - k + 1)

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            boolean isConsecutive = true;
            int prev = nums[i] - 1;
            
            for (int j = i; j < i + k; j++) {
                if (nums[j] != prev + 1) {
                    isConsecutive = false;
                    break;
                }
                max = Math.max(max, nums[j]);
                prev = nums[j];
            }
            
            results[i] = isConsecutive ? max : -1;
        }
        
        return results;
    }
}
```

#### Complexity 
- Time: $O(n \times k)$
- Space: $O(n - k + 1)$

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
