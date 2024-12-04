// 2825. Make String a Subsequence Using Cyclic Increments

// Two-Pointer Greedy Matching
// Runtime: 6ms

// Complexity:
// + Time: O(n + m)
// + Space: O(1)

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0; // Pointers for str1 and str2
        
        while (i < str1.length() && j < str2.length()) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            // Check if c1 matches c2 or can be incremented cyclically to match
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                j++; // Match found for str2[j]
            }
            i++; // Move to the next character in str1
        }
        
        return j == str2.length();
    }
}
