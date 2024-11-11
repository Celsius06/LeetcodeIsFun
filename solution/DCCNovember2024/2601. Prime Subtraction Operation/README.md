# 2601. Prime Subtraction Operation 

## Problem Statement
Given a 0-indexed integer array `nums`, create an algorithm that makes `nums` strictly increasing by subtracting a prime number from each element at most once. The prime number must be less than the element itself.

### Examples
#### Example 1:
- **Input**: `nums = [4,9,6,10]`
- **Output**: `true`
- **Explanation**:
    - Operation 1: Pick index `0`, prime `3` → `nums[0] = 4 - 3 = 1` → Result: `[1,9,6,10]`
    - Operation 2: Pick index `1`, prime `7` → `nums[1] = 9 - 7 = 2` → Result: `[1,2,6,10]`
    - The final array `[1,2,6,10]` is strictly increasing.

#### Example 2:
- **Input**: `nums = [6,8,11,12]`
- **Output**: `true`
- **Explanation**: The array is already strictly increasing.

#### Example 3:
- **Input**: `nums = [5,8,3]`
- **Output**: `false`
- **Explanation**: It's impossible to make the array strictly increasing with the allowed operations.

## Solution Approach

### Steps
1. **Iterate Through Array**: Track the last modified element (`prev`).
2. **Condition Check**: For each element `nums[i]`, check if it's greater than `prev` (if not, the task is impossible).
3. **Prime Subtraction**:
   - Calculate the maximum value that can be subtracted from `nums[i]` to ensure it stays above `prev`.
   - Find the largest prime number less than or equal to this maximum.
4. **Update Array**: Subtract the prime (if one exists) and update `prev`.

### Helper Functions
#### Prime Validator
Checks if a number is prime:
```java
private boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

#### Largest Prime Finder
Finds the largest prime number less than a given number:
```java
private int findLargestPrime(int n) {
    for (int i = n - 1; i >= 2; i--) {
        if (isPrime(i)) return i;
    }
    return 0;
}
```

### Main Function
Implements the core logic:
```java
public boolean primeSubOperation(int[] nums) {
    int prev = 0;  // Initialize `prev` to track last modified element

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= prev) return false;  // If `nums[i]` is not greater than `prev`, return false

        int maxSubtract = nums[i] - prev - 1;  // Calculate max possible value to subtract

        if (maxSubtract > 0) {
            int prime = findLargestPrime(maxSubtract + 1);  // Find the largest prime within the limit
            if (prime > 0) nums[i] -= prime;  // Subtract prime if found
        }

        prev = nums[i];  // Update `prev` to current element
    }
    return true;
}
```

## Complexity Analysis
- **Time Complexity**: `O(n * m * √m)`
    - `n`: Length of array
    - `m`: Maximum number in array
    - `√m`: Checking for prime numbers
- **Space Complexity**: `O(1)`: Uses constant extra space.

## Constraints
- `1 ≤ nums.length ≤ 1000`
- `1 ≤ nums[i] ≤ 1000`
