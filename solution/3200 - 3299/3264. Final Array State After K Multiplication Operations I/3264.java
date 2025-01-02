// 3264. Final Array State After K Multiplication Operations I

// Simple Iteration
// Runtime: 1ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}

