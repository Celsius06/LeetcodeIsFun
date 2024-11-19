---
Difficulty: Medium
Potential DSAs for this problem:
    - Array
    - Hash Table
    - Sliding Window
---

<!-- problem:start -->

# [2461. Maximum Sum of Distinct Subarrays With Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k)
## Description
<!-- description:start -->
<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. Find the maximum subarray sum of all the subarrays of <code>nums</code> that meet the following conditions:</p>
<ul>
	<li>The length of the subarray is <code>k</code>, and</li>
	<li>All the elements of the subarray are <strong>distinct</strong>.</li>
</ul
<p>Return <em>the maximum subarray sum of all the subarrays that meet the conditions</em><em>.</em> If no subarray meets the conditions, return <code>0</code>.</p>
<p><em>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</em></p>

<p><strong class="example">Example 1:</strong></p>
<pre>
<strong>Input:</strong> nums = [1,5,4,2,9,9,9], k = 3
<strong>Output:</strong> 15
<strong>Explanation:</strong> The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
</pre>

<p><strong class="example">Example 2:</strong></p>
<pre>
<strong>Input:</strong> nums = [4,4,4], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>
<!-- description:end -->


## Solutions
<!-- solution:start -->

### Solution 1: Sliding Window + Hash Table
<!-- tabs:start -->
#### Java
```java
// 2461. Maximum Sum of Distinct Subarrays With Length K

// HashSet, Sliding Window
// Runtime: 33ms

// Complexity
// + Time: O(n), with `n` is the length of array `nums`
// + Space: O(k), for the HashSet storing at most `k` elements.

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        
        int start = 0; // Start of the window
        for (int end = 0; end < nums.length; end++) {
            // Add the current element to the window
            currentSum += nums[end];
            
            // Handle duplicates
            while (uniqueElements.contains(nums[end])) {
                currentSum -= nums[start];
                uniqueElements.remove(nums[start]);
                start++;
            }
            
            uniqueElements.add(nums[end]);
            
            // Check if the window is valid (size k)
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Slide the window by removing the leftmost element
                currentSum -= nums[start];
                uniqueElements.remove(nums[start]);
                start++;
            }
        }
        
        return maxSum;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
