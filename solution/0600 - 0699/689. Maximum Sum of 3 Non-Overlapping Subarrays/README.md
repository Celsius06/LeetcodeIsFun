---
Difficulty: Hard
Utilizable DSAs/Methods/Approaches:
    - Array
    - Dynamic Programming
---

<!-- problem:start -->
# [689. Maximum Sum of 3 Non-Overlapping Subarrays](https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays)
## Description
<!-- description:start -->
<p>Given an integer array <code>nums</code> and an integer <code>k</code>, find three non-overlapping subarrays of length <code>k</code> with maximum sum and return them.</p>
<p>Return the result as a list of indices representing the starting position of each interval (<strong>0-indexed</strong>). If there are multiple answers, return the lexicographically smallest one.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> nums = [1,2,1,2,6,7,5,1], k = 2
<strong>Output:</strong> [0,3,5]
<strong>Explanation:</strong> Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> nums = [1,2,1,2,1,2,1,2,1], k = 2
<strong>Output:</strong> [0,2,4]
</pre>


### Constraints
<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;&nbsp;2<sup>16</sup></code></li>
	<li><code>1 &lt;= k &lt;= floor(nums.length / 3)</code></li>
</ul>

<!-- description:end -->



<p>&nbsp;</p>




## Solutions
<!-- solution:start -->
### Solution 1: Sliding Window
We use a sliding window to enumerate the position of the third subarray, while maintaining the maximum sum and its position of the first two non-overlapping subarrays.
The time complexity is $O(n)$, where $n$ is the length of the array $nums$. The space complexity is $O(1)$.
<!-- tabs:start -->
#### Java
```java
// 689. Maximum Sum of 3 Non-Overlapping Subarrays

// Fixed-size Sliding Windows
// Runtime: 7ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int s = 0, s1 = 0, s2 = 0, s3 = 0;
        int mx1 = 0, mx12 = 0;
        int idx1 = 0, idx121 = 0, idx122 = 0;
        for (int i = k * 2; i < nums.length; ++i) {
            s1 += nums[i - k * 2];
            s2 += nums[i - k];
            s3 += nums[i];
            if (i >= k * 3 - 1) {
                if (s1 > mx1) {
                    mx1 = s1;
                    idx1 = i - k * 3 + 1;
                }
                if (mx1 + s2 > mx12) {
                    mx12 = mx1 + s2;
                    idx121 = idx1;
                    idx122 = i - k * 2 + 1;
                }
                if (mx12 + s3 > s) {
                    s = mx12 + s3;
                    ans = new int[] {idx121, idx122, i - k + 1};
                }
                s1 -= nums[i - k * 3 + 1];
                s2 -= nums[i - k * 2 + 1];
                s3 -= nums[i - k + 1];
            }
        }
        return ans;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
