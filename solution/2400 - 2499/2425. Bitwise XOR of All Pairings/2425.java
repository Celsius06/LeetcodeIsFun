// 2425. Bitwise XOR of All Pairings

// Mathematical XOR Operations
// Runtime: 1ms (dd/mm/yyyy GMT+7)

// Complexity:
// + Time: O(1)
// + Space: O(1)

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;
        for (int num : nums1) xor1 ^= num;
        for (int num : nums2) xor2 ^= num;
        return ((nums2.length % 2) * xor1) ^ ((nums1.length % 2) * xor2);
    }
}