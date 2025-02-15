// 2698. Find the Punishment Number of an Integer
// Difficulty: Medium
// Link: https://leetcode.com/problems/find-the-punishment-number-of-an-integer/

// DSAs
// Methods & Approaches
// Runtime: 24ms (15/02/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O(n * log(n)) | n = input number
// + Space: O(1) | no extra space

class Solution {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf((long) i * i);
            if (canPartition(s, i, 0)) {
                total += i * i;
            }
        }
        return total;
    }

    private boolean canPartition(String s, int target, int index) {
        if (index == s.length())
            return target == 0;
        if (target < 0)
            return false;

        long num = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > target)
                break;
            if (canPartition(s, target - (int) num, i + 1))
                return true;
        }
        return false;
    }
}
