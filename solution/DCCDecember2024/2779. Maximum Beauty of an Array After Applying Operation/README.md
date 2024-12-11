---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Array
    - Binary Search
    - Sorting
    - Sliding Window
---


<!-- problem:start -->
# [2779. Maximum Beauty of an Array After Applying Operation](https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation)
## Description
<!-- description:start -->
<p>You are given a <strong>0-indexed</strong> array <code>nums</code> and a <strong>non-negative</strong> integer <code>k</code>.</p>
<p>In one operation, you can do the following:</p>
<ul>
	<li>Choose an index <code>i</code> that <strong>hasn&#39;t been chosen before</strong> from the range <code>[0, nums.length - 1]</code>.</li>
	<li>Replace <code>nums[i]</code> with any integer from the range <code>[nums[i] - k, nums[i] + k]</code>.</li>
</ul>
<p>The <strong>beauty</strong> of the array is the length of the longest subsequence consisting of equal elements.</p>
<p>Return <em>the <strong>maximum</strong> possible beauty of the array </em><code>nums</code><em> after applying the operation any number of times.</em></p>
<p><strong>Note</strong> that you can apply the operation to each index <strong>only once</strong>.</p>
<p>A&nbsp;<strong>subsequence</strong> of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the order of the remaining elements.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> nums = [4,6,1,2], k = 2
<strong>Output:</strong> 3
<strong>Explanation:</strong> In this example, we apply the following operations:
- Choose index 1, replace it with 4 (from range [4,8]), nums = [4,4,1,2].
- Choose index 3, replace it with 4 (from range [0,4]), nums = [4,4,1,4].
After the applied operations, the beauty of the array nums is 3 (subsequence consisting of indices 0, 1, and 3).
It can be proven that 3 is the maximum possible length we can achieve.
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> nums = [1,1,1,1], k = 10
<strong>Output:</strong> 4
<strong>Explanation:</strong> In this example we don&#39;t have to apply any operations.
The beauty of the array nums is 4 (whole array).
</pre>

### Constraints
<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i], k &lt;= 10<sup>5</sup></code></li>
</ul>
<!-- description:end -->


<p>&nbsp;</p>


## Solutions
<!-- solution:start -->
### 1. Sorting and Sliding Window
<!-- tabs:start -->
#### Java
```java
// Runtime: 39ms

// Complexity:
// + Time: O(n log(n))
// + Space: O(1)

import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }
        return maxBeauty;
    }
}
```

### 2. Frequency Map
<!-- tabs:start -->
#### Java
```java
// This solution is not recommended due to the large runtime. For references only.

// Runtime: 389ms

// Complexity:
// + Time: O(n log(n))
// + Space: O(n)

import java.util.TreeMap;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int maxBeauty = 0;

        for (int num : nums) {
            freq.put(num - k, freq.getOrDefault(num - k, 0) + 1);
            freq.put(num + k + 1, freq.getOrDefault(num + k + 1, 0) - 1);
        }

        int current = 0;
        for (int count : freq.values()) {
            current += count;
            maxBeauty = Math.max(maxBeauty, current);
        }

        return maxBeauty;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
