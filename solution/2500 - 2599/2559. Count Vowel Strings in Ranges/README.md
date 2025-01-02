<!-- problem:start -->
# [2559. Count Vowel Strings in Ranges](https://leetcode.com/problems/count-vowel-strings-in-ranges)

## Solutions
<!-- solution:start -->
### 1/ Prefix Sum Array, Range Query Handling
<!-- tabs:start -->
##### Java
```java
// 2559. Count Vowel Strings in Ranges

// 1st Approach
// Prefix Sum Array, Range Query Handling
// Runtime: 6ms

// Complexity:
// + Time: O(n + m)
// + Space: O(n + m)

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] valid = new int[n];
        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                valid[i] = 1;
            } else {
                valid[i] = 0;
            }
        }

        // Prefix sum array
        int[] prefix = new int[n];
        prefix[0] = valid[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + valid[i];
        }

        // Answer queries
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int li = queries[q][0], ri = queries[q][1];
            result[q] = prefix[ri] - (li > 0 ? prefix[li - 1] : 0);
        }
        return result;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
```
<!-- tabs:end -->


<p>&nbsp;</p>


### 2/ Preprocessing + Binary Search
<!-- tabs:start -->
##### Java
```java
// 2559. Count Vowel Strings in Ranges

// 2nd Approach
// DSs: ArrayList, Set, Array    
// As: Vowel Checking, Binary Search  
// Runtime: 36ms

// Complexity:
// + Time: O(n + m * log k)
// + Space: O(k + m)

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
    private List<Integer> nums = new ArrayList<>();

    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < words.length; ++i) {
            char a = words[i].charAt(0), b = words[i].charAt(words[i].length() - 1);
            if (vowels.contains(a) && vowels.contains(b)) {
                nums.add(i);
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = search(r + 1) - search(l);
        }
        return ans;
    }

    private int search(int x) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
