class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            boolean isConsecutive = true;
            int prev = nums[i] - 1;
            
            for (int j = i; j < i + k; j++) {
                if (nums[j] != prev + 1) {
                    isConsecutive = false;
                    break;
                }
                max = Math.max(max, nums[j]);
                prev = nums[j];
            }
            
            results[i] = isConsecutive ? max : -1;
        }
        
        return results;
    }
}

