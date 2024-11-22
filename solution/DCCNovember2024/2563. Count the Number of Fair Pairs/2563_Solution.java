// Sorting and Two-Pointer Technique
// Runtime: 62ms

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = lower - nums[i];
            int right = upper - nums[i];

            // Use binary search to find the valid range of j
            int jStart = findFirstIndex(nums, left, i + 1, n);
            int jEnd = findFirstIndex(nums, right + 1, i + 1, n);

            count += jEnd - jStart; // count valid pairs
        }

        return count;
    }

    private int findFirstIndex(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // this will be the first index >= target
    }
}