// 2762. Continuous Subarrays

// Sliding Window with Deques
// Runtime: 20ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        long count = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                left++;
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }

            count += (right - left + 1);
        }

        return count;
    }
}


