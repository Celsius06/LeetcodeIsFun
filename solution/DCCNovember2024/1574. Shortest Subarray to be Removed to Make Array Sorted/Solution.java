// 1574. Shortest Subarray to be Removed to Make Array Sorted

// Two-pointer
// Runtime: 1ms

// Complexity:
// + Time: O(n), with n is the array length
// + Space: O(1)

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;

        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) return 0;

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        int minLength = Math.min(right, n - left - 1);
        for (int i = 0; i <= left; i++) {
            while (right < n && arr[i] > arr[right]) {
                right++;
            }
            minLength = Math.min(minLength, right - i - 1);
        }

        return minLength;
    }
}