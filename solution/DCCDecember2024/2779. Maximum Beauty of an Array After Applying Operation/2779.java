// 2779. Maximum Beauty of an Array After Applying Operation

// Sorting and Sliding Window
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
