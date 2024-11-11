Main Idea:
We need to make the array strictly increasing by subtracting prime numbers
For each position, we want to subtract the largest possible prime number while ensuring the array remains strictly increasing
Helper Functions:
java

Copy
private boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
This function checks if a number is prime
We only need to check divisors up to square root of n for efficiency
Finding Largest Prime:
java

Copy
private int findLargestPrime(int n) {
    for (int i = n - 1; i >= 2; i--) {
        if (isPrime(i)) return i;
    }
    return 0;
}
This finds the largest prime number less than n
Returns 0 if no prime found
Main Algorithm:
java

Copy
int prev = 0;  // Previous number in the sequence
for (int i = 0; i < n; i++) {
    // If current number <= previous, impossible to make strictly increasing
    if (nums[i] <= prev) return false;
    
    // Calculate maximum value we can subtract
    int maxSubtract = nums[i] - prev - 1;
We maintain a 'prev' variable to track the previous number
At each position, we calculate how much we can subtract while keeping the array strictly increasing
Making Decisions:
If nums[i] ≤ prev, it's impossible to make the array strictly increasing
For each number, we:
Calculate maximum value we can subtract (nums[i] - prev - 1)
Find largest prime less than or equal to this value
Subtract this prime if found
Example: nums = [4,9,6,10]
First number (4):
prev = 0
maxSubtract = 4 - 0 - 1 = 3
Subtract 3 (prime) → 4-3 = 1
Second number (9):
prev = 1
maxSubtract = 9 - 1 - 1 = 7
Subtract 7 (prime) → 9-7 = 2
And so on...
Time Complexity: O(n * m * √m), where n is array length and m is maximum number in array
Space Complexity: O(1)
