// 1980. Find Unique Binary String | Difficulty: Medium
// https://leetcode.com/problems/find-unique-binary-string/

// String | Diagonal Flipping
// Runtime: 0ms (20/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char c = nums[i].charAt(i); // Get i-th bit of i-th string
            sb.append(c == '0' ? '1' : '0'); // Flip it
        }
        return sb.toString();
    }
}