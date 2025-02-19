// 1415. The k-th Lexicographical String of All Happy Strings of Length n | Medium
// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

// ArrayList, String | Backtracking (Recursive Generation)
// Runtime: 9ms (19/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(3^n) - 3 choices for each character
// + Space: O(n)

class Solution {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        backtrack("", n, k);
        return result;
    }

    private void backtrack(String s, int n, int k) {
        if (s.length() == n) {
            count++;
            if (count == k) {
                result = s;
            }
            return;
        }

        if (count >= k)
            return; // Early exit if we've found k strings

        for (char c : new char[] { 'a', 'b', 'c' }) {
            if (s.isEmpty() || s.charAt(s.length() - 1) != c) {
                backtrack(s + c, n, k);
            }
        }
    }
}
