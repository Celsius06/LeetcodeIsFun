// 2683. Neighboring Bitwise XOR

// XOR Operations
// Runtime: 2ms (17/01/2025 GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int d : derived)
            xorSum ^= d;
        // Valid if XOR of all elements is 0
        return xorSum == 0;
    }
}