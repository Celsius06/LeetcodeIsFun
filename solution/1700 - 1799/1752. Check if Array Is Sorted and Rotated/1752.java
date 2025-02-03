// 1752. Check if Array Is Sorted and Rotated
// Difficulty: Easy

// Single Pass
// Runtime: 0ms (03/02/2025 | 4pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int countDrops = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                countDrops++;
            }
        }

        return countDrops <= 1;
    }
}
