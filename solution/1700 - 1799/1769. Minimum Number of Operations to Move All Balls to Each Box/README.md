<!-- problem:start -->
# [1769. Minimum Number of Operations to Move All Balls to Each Box](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box)
## Solutions
<!-- solution:start -->
### 1/ Prefix Sum
<!-- tabs:start -->
##### Java
```java
// 1769. Minimum Number of Operations to Move All Balls to Each Box

// Prefix Sum
// Runtime: 3ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        int balls = 0, moves = 0;
        // Left to right
        for (int i = 0; i < n; i++) {
            result[i] += moves;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
            moves += balls;
        }

        balls = 0;
        moves = 0;
        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            result[i] += moves;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
            moves += balls;
        }

        return result;
    }
}
```


### 2/ Brute Force (not very ideal)
<!-- tabs:start -->
##### Java
```java
// 1769. Minimum Number of Operations to Move All Balls to Each Box

// Prefix Sum
// Runtime: 146ms

// Complexity:
// + Time: O(n^2)
// + Space: O(1)

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    result[i] += Math.abs(i - j);
                }
            }
        }
        return result;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
