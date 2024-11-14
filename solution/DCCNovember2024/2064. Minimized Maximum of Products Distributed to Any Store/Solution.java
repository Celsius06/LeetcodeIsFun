// 2064. Minimized Maximum of Products Distributed to Any Store

// Binary Search
// Runtime: 22ms

// Complexity:
// + Time: O(mlog(max quantity))
// + Space: O(1)

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1; 
        int right = 0; 
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left; 
    }
    
    private boolean canDistribute(int[] quantities, int n, int x) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + x - 1) / x; 
            if (storesNeeded > n) { 
                return false;
            }
        }
        return storesNeeded <= n;
    }
}