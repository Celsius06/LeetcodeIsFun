class Solution {
    public int numTilePossibilities(String tiles) {
        // Frequency array for 26 uppercase letters, initialized to zero.
        int[] freq = new int[26];

        // Populate the frequency array based on the input string.
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }

        // Start the backtracking process to count valid sequences.
        return backtrack(freq);
    }

    // Helper method: returns the count of valid sequences that can be formed
    // given the current frequency of letters.
    private int backtrack(int[] freq) {
        int count = 0;

        // Try each letter from 'A' to 'Z'.
        for (int i = 0; i < 26; i++) {
            // Check if the current letter is available to use.
            if (freq[i] > 0) {
                // Use letter i: count this as one valid sequence.
                count++;
                // Choose letter i by decrementing its count.
                freq[i]--;

                // Recurse to form longer sequences with the remaining letters.
                count += backtrack(freq);

                // Backtrack: restore the count for letter i to explore other combinations.
                freq[i]++;
            }
        }

        // Return the total count of valid sequences found.
        return count;
    }
}