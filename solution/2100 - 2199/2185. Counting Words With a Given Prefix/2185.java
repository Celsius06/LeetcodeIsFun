// 2185. Counting Words With a Given Prefix

// Brute Force
// Runtime: 0ms (9/1/2025)

// Complexity:
// + Time: O(n * p), n: number of words; p: prefix length
// + Space: O(1)

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}