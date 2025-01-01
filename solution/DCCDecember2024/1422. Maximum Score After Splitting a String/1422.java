// 1422. Maximum Score After Splitting a String

// Single Pass
// Runtime: 1ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int maxScore(String s) {
        int totalOnes = 0, leftZeros = 0, maxScore = 0;

        // Count total '1's
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // Calculate score in a single pass
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') leftZeros++;
            else totalOnes--;

            maxScore = Math.max(maxScore, leftZeros + totalOnes);
        }
        return maxScore;
    }
}
