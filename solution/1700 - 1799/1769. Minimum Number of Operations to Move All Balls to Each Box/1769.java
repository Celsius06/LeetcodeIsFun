// 1769. Minimum Number of Operations to Move All Balls to Each Box

// Prefix Sum
// Runtime: 3ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int balls = 0, moves = 0;
        // Left to right
        for (int i = 0; i < n; i++) {
            result[i] += moves;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
            moves += balls;
        }

        balls = 0;
        moves = 0;
        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += moves;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
            moves += balls;
        }

        return result;
    }
}
