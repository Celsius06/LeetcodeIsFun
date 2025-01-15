// 2429. Minimize XOR

// Priority Queue
// Greedy Approach
// Runtime: 2ms (16/1/2025 GMT+7)

// Complexity:
// + Time: O(1)
// + Space: O(1)

import java.util.PriorityQueue;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt = Integer.bitCount(num2);
        PriorityQueue<Integer> bitPositions = new PriorityQueue<>((a, b) -> b - a);

        // Collect all bit positions with `1` in num1
        for (int i = 0; i < 31; ++i) {
            if ((num1 >> i & 1) == 1) {
                bitPositions.add(i);
            }
        }

        int x = 0;
        while (cnt > 0 && !bitPositions.isEmpty()) {
            x |= 1 << bitPositions.poll(); // Set most significant available bit
            --cnt;
        }

        // If more bits are needed, start setting from least significant bit
        for (int i = 0; cnt > 0; ++i) {
            if ((x >> i & 1) == 0) { // If not already set
                x |= 1 << i;
                --cnt;
            }
        }
        return x;
    }
}
