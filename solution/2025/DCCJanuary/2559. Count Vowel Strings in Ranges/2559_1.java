// 2559. Count Vowel Strings in Ranges

// 1st Approach
// Prefix Sum Array, Range Query Handling
// Runtime: 6ms

// Complexity:
// + Time: O(n + m)
// + Space: O(n + m)

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] valid = new int[n];
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                valid[i] = 1;
            } else {
                valid[i] = 0;
            }
        }

        // Prefix sum array
        int[] prefix = new int[n];
        prefix[0] = valid[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + valid[i];
        }

        // Answer queries
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int li = queries[q][0], ri = queries[q][1];
            result[q] = prefix[ri] - (li > 0 ? prefix[li - 1] : 0);
        }
        return result;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
