// 2375. Construct Smallest Number From DI String | Medium
// https://leetcode.com/problems/construct-smallest-number-from-di-string/

// Stack | Greedy Approach
// Runtime: 1ms (19/02/2025 | 1am - GMT+7)

// Complexity:
// + Time: O(n) 
// + Space: O(n) 
// with n is the length of the pattern

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        // Use a stack to help reverse subsequences.
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pattern.length();

        // Iterate from 0 to n (inclusive) to process n+1 digits.
        for (int i = 0; i <= n; i++) {
            // Push the current number (i+1) onto the stack.
            stack.push(i + 1);

            // If we are at the end of pattern or the current pattern character is 'I',
            // then pop all numbers from the stack and add to result.
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}
