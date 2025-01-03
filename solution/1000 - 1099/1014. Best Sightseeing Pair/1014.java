// 1014. Best Sightseeing Pair

// Enumeration
// Runtime: 4ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = 0;
        for (int j = 0; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        
        return ans;
    }
}
