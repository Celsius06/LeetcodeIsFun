---
Difficulty: Medium
Potential DSAs:
    - Hash Table
    - String
    - Sliding Window
---

<!-- problem:start -->
# [2516. Take K of Each Character From Left and Right](https://leetcode.com/problems/take-k-of-each-character-from-left-and-right)

## Description
<!-- description:start -->
<p>You are given a string <code>s</code> consisting of the characters <code>&#39;a&#39;</code>, <code>&#39;b&#39;</code>, and <code>&#39;c&#39;</code> and a non-negative integer <code>k</code>. Each minute, you may take either the <strong>leftmost</strong> character of <code>s</code>, or the <strong>rightmost</strong> character of <code>s</code>.</p>
<p>Return<em> the <strong>minimum</strong> number of minutes needed for you to take <strong>at least</strong> </em><code>k</code><em> of each character, or return </em><code>-1</code><em> if it is not possible to take </em><code>k</code><em> of each character.</em></p>

<p><strong class="example">Example 1:</strong></p>
<pre>
<strong>Input:</strong> s = &quot;aabaaaacaabc&quot;, k = 2
<strong>Output:</strong> 8
<strong>Explanation:</strong> 
Take three characters from the left of s. You now have two &#39;a&#39; characters, and one &#39;b&#39; character.
Take five characters from the right of s. You now have four &#39;a&#39; characters, two &#39;b&#39; characters, and two &#39;c&#39; characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.
</pre>

<p><strong class="example">Example 2:</strong></p>
<pre>
<strong>Input:</strong> s = &quot;a&quot;, k = 1
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is not possible to take one &#39;b&#39; or &#39;c&#39; so return -1.
</pre>

<p><strong>Constraints:</strong></p>
<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only the letters <code>&#39;a&#39;</code>, <code>&#39;b&#39;</code>, and <code>&#39;c&#39;</code>.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>
<!-- description:end -->


## Solutions
<!-- solution:start -->
<!-- tabs:start -->

#### Java
```java
// 2516. Take K of Each Character From Left and Right

// Sliding Window
// Runtime: 17ms

// Complexity:
// + Time: O(n)
// + Space: O(1)

class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0; // No characters needed.

        int n = s.length();
        int[] count = new int[3]; // Count of 'a', 'b', 'c'

        // Count total frequencies of 'a', 'b', and 'c'.
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // If any character's total count is less than k, return -1.
        for (int i = 0; i < 3; i++) {
            if (count[i] < k)
                return -1;
        }

        // Sliding window to find the longest valid substring.
        int[] windowCount = new int[3];
        int maxWindowSize = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;

            // Shrink the window if the outside counts fall below k.
            while (count[0] - windowCount[0] < k ||
                    count[1] - windowCount[1] < k ||
                    count[2] - windowCount[2] < k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum window size.
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        // Minimum minutes = total length - max window size.
        return n - maxWindowSize;
    }
}
```

<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
