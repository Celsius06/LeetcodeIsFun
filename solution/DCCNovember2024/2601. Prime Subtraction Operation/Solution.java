class Solution {
    // Function to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // Find largest prime number less than n
    private int findLargestPrime(int n) {
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime(i)) return i;
        }
        return 0;
    }
    
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        // Start from the first element
        int prev = 0;
        
        for (int i = 0; i < n; i++) {
            // If current number is not greater than previous, operation is impossible
            if (nums[i] <= prev) return false;
            
            // Find the maximum value we can subtract while keeping array strictly increasing
            int maxSubtract = nums[i] - prev - 1;
            
            // If no subtraction needed, continue
            if (maxSubtract <= 0) {
                prev = nums[i];
                continue;
            }
            
            // Find largest prime less than or equal to maxSubtract
            int prime = findLargestPrime(maxSubtract + 1);
            
            // Subtract prime if found
            if (prime > 0) {
                nums[i] -= prime;
            }
            
            prev = nums[i];
        }
        
        return true;
    }
}