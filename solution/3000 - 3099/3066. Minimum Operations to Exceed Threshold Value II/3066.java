// 3066. Minimum Operations to Exceed Threshold Value II
// Difficulty: Medium
// Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

// DSAs
// Methods & Approaches
// Runtime: 148ms (13/02/2025 | 11pm - GMT+7)

// Complexity Analysis
// + Time: O(n * log(n)) where n is the number of elements in the input array.
// + Space: O(n) where n is the number of elements in the input array.

class Solution {
    public int minOperations(int[] nums, int k) {
        // PriorityQueue to store the numbers in ascending order.
        // Using Long to avoid potential overflow when computing (x * 2 + y).
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : nums) {
            // Add each number as a long value into the priority queue.
            pq.offer((long) x);
        }

        int ans = 0; // Counter for the number of operations performed.

        // Continue performing operations while:
        // - There are at least two elements in the queue, and
        // - The smallest element in the queue is less than k.
        for (; pq.size() > 1 && pq.peek() < k; ++ans) {
            // Remove the two smallest elements.
            long x = pq.poll(), y = pq.poll();
            // According to the problem's operation:
            // new value = 2 * x + y (since x <= y due to the min-heap property).
            pq.offer(x * 2 + y);
        }

        // Return the total number of operations performed.
        return ans;
    }
}
