---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Array
    - Dynamic Programming
    - Backtracking
---

<!-- problem:start -->
# [494. Target Sum](https://leetcode.com/problems/target-sum)
## Description
<!-- description:start -->
<p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>
<p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>&#39;+&#39;</code> and <code>&#39;-&#39;</code> before each integer in nums and then concatenate all the integers.</p>
<ul>
	<li>For example, if <code>nums = [2, 1]</code>, you can add a <code>&#39;+&#39;</code> before <code>2</code> and a <code>&#39;-&#39;</code> before <code>1</code> and concatenate them to build the expression <code>&quot;+2-1&quot;</code>.</li>
</ul>
<p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> nums = [1,1,1,1,1], target = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> nums = [1], target = 1
<strong>Output:</strong> 1
</pre>

### Constraints
<ul>
	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li>
	<li><code>-1000 &lt;= target &lt;= 1000</code></li>
</ul>
<!-- description:end -->



<p>&nbsp;</p>



## Solutions
<!-- solution:start -->
<!-- tabs:start -->
#### Java
```java
// 494. Target Sum

// Dynamic Programming, Recursion
// Runtime: 2ms

// Complexity:
// + Time: O(n * target)
// + Space: O(target)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If target + sum is odd or target is not reachable
        if ((target + sum) % 2 != 0 || target > sum || target < -sum) {
            return 0;
        }

        int subsetSum = (target + sum) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: 1 way to make sum 0

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
