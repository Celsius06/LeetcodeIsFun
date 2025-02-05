// 1790. Check if One String Swap Can Make Strings Equal
// Difficulty: Easy

// DSAs
// Methods & Approaches
// Runtime: _ms (05/02/2025 | 8pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int first = -1, second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    // More than two differences
                    return false;
                }
            }
        }
        // Check cases based on number of differences
        if (first == -1) {
            // No differences
            return true;
        } else if (second == -1) {
            // Exactly one difference (can't swap)
            return false;
        } else {
            // Check if swapping makes them equal
            return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
        }
    }
}
