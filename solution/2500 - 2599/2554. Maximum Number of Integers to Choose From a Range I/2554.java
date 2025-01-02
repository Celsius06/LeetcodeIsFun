// 2554. Maximum Number of Integers to Choose From a Range I

// Sort and Greedy Selection
// Runtime: 47ms

// Complexity:
// + Time: O(b + n)
// + Space: O(b)

import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int currentSum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue; // Skip banned integers
            }

            if (currentSum + i > maxSum) {
                break; // Stop if adding the current integer exceeds maxSum
            }

            currentSum += i;
            count++;
        }

        return count;
    }
}
