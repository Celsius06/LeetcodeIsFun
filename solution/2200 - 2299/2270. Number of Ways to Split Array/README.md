<!-- problem:start -->
# [2270. Number of Ways to Split Array](https://leetcode.com/problems/number-of-ways-to-split-array)
## Solutions
<!-- solution:start -->
#### 1/ Prefix and Suffix Sum
<!-- tabs:start -->
##### Java
```java
// 2270. Number of Ways to Split Array

// Prefix and Suffix Sum
// Runtime: 4ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0, prefixSum = 0;
        int validSplits = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate to find valid splits
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            long rightSum = totalSum - prefixSum;
            if (prefixSum >= rightSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
