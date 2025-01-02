// 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

// Split & Iterate
// Runtime: 0ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
