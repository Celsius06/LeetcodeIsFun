// 1790. Check if One String Swap Can Make Strings Equal
// Difficulty: Medium

// Hash Map, Map, Array, Two Pointers
// Runtime: 170ms (06/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(n^2)
// + Space: O(n)

// 2nd Approach

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                res += 8 * map.getOrDefault(prod, 0);
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        return res;

    }
}