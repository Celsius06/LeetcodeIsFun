// 2182. Construct String With Repeat Limit

// Priority Queue (Max-Heap)
// Runtime: 32ms

// Complexity:
// + Time: O(k * log(n))
// + Space: O(n)

import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (char i = 'a'; i <= 'z'; i++) {
            if (freq[i - 'a'] > 0) {
                maxHeap.offer(new int[]{i, freq[i - 'a']});
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            char ch = (char) current[0];
            int count = Math.min(current[1], repeatLimit);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }

            if (current[1] > repeatLimit) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                result.append((char) next[0]);
                next[1]--;

                if (next[1] > 0) {
                    maxHeap.offer(next);
                }

                maxHeap.offer(new int[]{ch, current[1] - repeatLimit});
            }
        }

        return result.toString();
    }
}


