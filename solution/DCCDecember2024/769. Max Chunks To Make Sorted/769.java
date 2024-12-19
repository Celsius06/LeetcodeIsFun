// 769. Max Chunks To Make Sorted

// Normal Iteration
// Runtime: 1ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
