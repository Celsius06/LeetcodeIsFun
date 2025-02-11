// 1910. Remove All Occurrences of a Substring
// Difficulty: Medium
// Link: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

// DSAs
// Methods & Approaches
// Runtime: 7ms (11/02/2025 | 1pm - GMT+7)

// Complexity:
// Time: O(n * m) where n is length of s, m is length of part
// - contains() and replaceFirst() both take O(n) time
// - In worst case, we might need to scan the string n/m times
// Space: O(n) for storing the modified string after each replacement

class Solution {
    /**
     * Removes all occurrences of a substring from a string
     * @param s The input string
     * @param part The substring to remove
     * @return String with all occurrences of part removed
     */
    public String removeOccurrences(String s, String part) {
        // Keep removing part until it's no longer found in s
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}


