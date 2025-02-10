// 3174. Clear Digits
// Difficulty: Easy

// Stack
// Runtime: 2ms (10/02/2025 | 11pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    public String clearDigits(String s) {
        StringBuilder stk = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stk.deleteCharAt(stk.length() - 1);
            } else {
                stk.append(c);
            }
        }
        return stk.toString();
    }
}
