// 1346. Check If N and Its Double Exist

// Brute Force
// Runtime: 2ms

// Complexity:
// + Time: O(n^2)
// + Space: O(1)

class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
