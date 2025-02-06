// 1790. Check if One String Swap Can Make Strings Equal
// Difficulty: Medium

// Hash Map, Map, Array, Two Pointers
// Runtime: 206ms (06/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(n^2)
// + Space: O(n^2)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        
        // Phase 1: Build frequency map of products from all pairs.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        
        // Phase 2: For each product count, compute the number of valid tuples.
        int result = 0;
        for (int count : productCount.values()) {
            if (count > 1) {
                // For each group of pairs with the same product,
                // the number of valid tuples is 8 * C(count, 2)
                result += 8 * (count * (count - 1) / 2);
            }
        }
        return result;
    }
}

