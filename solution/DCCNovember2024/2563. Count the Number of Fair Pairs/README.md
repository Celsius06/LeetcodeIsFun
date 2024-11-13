---
Difficulty: Medium
Involved Data Structures & Algorithms:
    - Array
    - Two Pointers
    - Binary Search
    - Sorting
---

<!-- problem:start -->

# [2563. Count the Number of Fair Pairs](https://leetcode.com/problems/count-the-number-of-fair-pairs)

## 1/ Problem Description

<!-- description:start -->

<p>Given a <strong>0-indexed</strong> integer array <code>nums</code> of size <code>n</code> and two integers <code>lower</code> and <code>upper</code>, return <em>the number of fair pairs</em>.</p>

<p>A pair <code>(i, j)</code> is <b>fair </b>if:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; n</code>, and</li>
	<li><code>lower &lt;= nums[i] + nums[j] &lt;= upper</code></li>
</ul>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,7,4,4,5], lower = 3, upper = 6
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,7,9,2,5], lower = 11, upper = 11
<strong>Output:</strong> 1
<strong>Explanation:</strong> There is a single fair pair: (2,3).
</pre>

<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n</code></li>
	<li><code><font face="monospace">-10<sup>9</sup></font>&nbsp;&lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code><font face="monospace">-10<sup>9</sup>&nbsp;&lt;= lower &lt;= upper &lt;= 10<sup>9</sup></font></code></li>
</ul>

<!-- description:end -->

<p>&nbsp;</p>

## 2/ Solution

<!-- solution:start -->

#### Java

```java

// Sorting and Two-Pointer Technique
// Runtime: 62ms

// import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = lower - nums[i];
            int right = upper - nums[i];

            // Use binary search to find the valid range of j
            int jStart = findFirstIndex(nums, left, i + 1, n);
            int jEnd = findFirstIndex(nums, right + 1, i + 1, n);

            count += jEnd - jStart; // count valid pairs
        }

        return count;
    }

    private int findFirstIndex(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // this will be the first index >= target
    }
}

```

#### Complexity 
- Time: $O(n \times \log n)$, with `n` is the length of the `nums` array
- Space: $O(1)$

<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
