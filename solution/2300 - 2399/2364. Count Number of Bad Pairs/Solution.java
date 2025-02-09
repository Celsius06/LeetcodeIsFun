// 2364. Count Number of Bad Pairs
// Difficulty: Medium

// Hash Map
// Counting
// Runtime: 39ms (09/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        Map<Long, Long> freqCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long diff = (long) nums[i] - i;
            freqCount.put(diff, freqCount.getOrDefault(diff, 0L) + 1);
        }

        long goodPairs = 0;
        for (long value : freqCount.values()) {
            goodPairs += value * (value - 1) / 2;
        }

        long badPairs = totalPairs - goodPairs;
        return badPairs;
    }
}
