// 2558. Take Gifts From the Richest Pile

// Max-Heap Priority Queue
// Runtime: 6ms

// Complexity:
// + Time: O(k * log(n) + n)
// + Space: O(n)

import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();
            maxHeap.offer((int) Math.floor(Math.sqrt(largest)));
        }

        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}

