// 3151. Special Array I
// Difficulty: Easy

// Iterative Approach
// Runtime: 0ms (03/02/2025 | 4pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1)
            return true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
