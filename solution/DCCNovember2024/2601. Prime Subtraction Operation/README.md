# Prime Subtraction Operation (LeetCode #2601)

## 💡 Problem Statement
Given a 0-indexed integer array `nums`, design an algorithm to make it strictly increasing by subtracting prime numbers. Each element can have one prime number subtracted from it, where the prime must be strictly less than the element.

### Examples
#### Example 1:
Input: nums = [4,9,6,10]
Output: true
Explanation:
Operation 1: Pick i=0, p=3 → nums[0] = 4-3 = 1 → [1,9,6,10]
Operation 2: Pick i=1, p=7 → nums[1] = 9-7 = 2 → [1,2,6,10]
Final array [1,2,6,10] is strictly increasing
#### Example 2:
Input: nums = [6,8,11,12]
Output: true
Explanation: Array is already strictly increasing
#### Example 3:
Input: nums = [5,8,3]
Output: false
Explanation: Cannot make array strictly increasing through allowed operations

## 🛠️ Solution Approach

### Core Algorithm
1. Iterate through array maintaining previous value
2. For each element:
   - Check if it can be made greater than previous element
   - Calculate maximum value that can be subtracted
   - Find and subtract largest possible prime

### Detailed Components

#### 1. Prime Number Validator
```java
private boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

2. Largest Prime Finder


private int findLargestPrime(int n) {
    for (int i = n - 1; i >= 2; i--) {
        if (isPrime(i)) return i;
    }
    return 0;
}
3. Main Solution



public boolean primeSubOperation(int[] nums) {
    int n = nums.length;
    int prev = 0;
    
    for (int i = 0; i < n; i++) {
        if (nums[i] <= prev) return false;
        
        int maxSubtract = nums[i] - prev - 1;
        if (maxSubtract <= 0) {
            prev = nums[i];
            continue;
        }
        
        int prime = findLargestPrime(maxSubtract + 1);
        if (prime > 0) {
            nums[i] -= prime;
        }
        
        prev = nums[i];
    }
    return true;
}
