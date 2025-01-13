// 3223. Minimum Length of String After Operations

// Frequency Counting
// Runtime: 9ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        int ans = 0;
        for (int x : cnt) {
            if (x > 0) {
                ans += x % 2 == 1 ? 1 : 2;
            }
        }
        return ans;
    }
}
