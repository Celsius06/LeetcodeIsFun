// 1760. Minimum Limit of Balls in a Bag

// Binary Search
// Runtime: 27ms

// Complexity:
// + Time:
// + Space:

class Solution {
    // Helper method to check feasibility of a given penalty
    private boolean canDistribute(int[] nums, int maxOperations, int penalty) {
        int operations = 0;
        for (int balls : nums) {
            if (balls > penalty) {
                operations += (balls - 1) / penalty; // Calculate required splits
            }
            if (operations > maxOperations) {
                return false; // Exceeds allowed operations
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        // Binary search for the minimum penalty
        int left = 1, right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(right, num); // Find the maximum value in nums
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(nums, maxOperations, mid)) {
                right = mid; // Try smaller penalty
            } else {
                left = mid + 1; // Increase penalty
            }
        }
        return left; // Minimum penalty found
    }
}
