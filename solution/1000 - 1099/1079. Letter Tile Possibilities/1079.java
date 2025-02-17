// 1079. Letter Tile Possibilities | Medium
// https://leetcode.com/problems/letter-tile-possibilities/

// DSAs | Methods & Approaches
// Methods & Approaches
// Runtime: _ms (17/02/2025 | __am/pm - GMT+7)

// Complexity:
// + Time: O()
// + Space: O()

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
                freq[i]--;
                count += backtrack(freq);
                freq[i]++;
            }
        }
        return count;
    }
}