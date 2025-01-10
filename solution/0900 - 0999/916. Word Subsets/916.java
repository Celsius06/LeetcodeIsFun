// 916. Word Subsets

// Frequency Counting
// Runtime: 15ms

// Complexity:
// + Time: O(m * n)
// + Space: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] targetFreq = new int[26];
        
        // Compute the maximum frequency of each character across all words in words2
        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
                targetFreq[c - 'a'] = Math.max(targetFreq[c - 'a'], freq[c - 'a']);
            }
        }

        List<String> result = new ArrayList<>();
        for (String a : words1) {
            if (isUniversal(a, targetFreq)) {
                result.add(a);
            }
        }

        return result;
    }

    private boolean isUniversal(String a, int[] targetFreq) {
        int[] freq = new int[26];
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] < targetFreq[i]) {
                return false;
            }
        }

        return true;
    }
}
