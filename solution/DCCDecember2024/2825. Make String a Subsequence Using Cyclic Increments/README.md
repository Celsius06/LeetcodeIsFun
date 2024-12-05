---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches::
    - Two Pointers
    - String
---

<!-- problem:start -->
# [2825. Make String a Subsequence Using Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments)
## Description
<!-- description:start -->
<p>You are given two <strong>0-indexed</strong> strings <code>str1</code> and <code>str2</code>.</p>
<p>In an operation, you select a <strong>set</strong> of indices in <code>str1</code>, and for each index <code>i</code> in the set, increment <code>str1[i]</code> to the next character <strong>cyclically</strong>. That is <code>&#39;a&#39;</code> becomes <code>&#39;b&#39;</code>, <code>&#39;b&#39;</code> becomes <code>&#39;c&#39;</code>, and so on, and <code>&#39;z&#39;</code> becomes <code>&#39;a&#39;</code>.</p>
<p>Return <code>true</code> <em>if it is possible to make </em><code>str2</code> <em>a subsequence of </em><code>str1</code> <em>by performing the operation <strong>at most once</strong></em>, <em>and</em> <code>false</code> <em>otherwise</em>.</p>
<p><strong>Note:</strong> A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.</p>

<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> str1 = &quot;abc&quot;, str2 = &quot;ad&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Select index 2 in str1.
Increment str1[2] to become &#39;d&#39;. 
Hence, str1 becomes &quot;abd&quot; and str2 is now a subsequence. Therefore, true is returned.</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> str1 = &quot;zc&quot;, str2 = &quot;ad&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Select indices 0 and 1 in str1. 
Increment str1[0] to become &#39;a&#39;. 
Increment str1[1] to become &#39;d&#39;. 
Hence, str1 becomes &quot;ad&quot; and str2 is now a subsequence. Therefore, true is returned.</pre>

<p><strong class="example">3.</strong></p>
<pre>
<strong>Input:</strong> str1 = &quot;ab&quot;, str2 = &quot;d&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> In this example, it can be shown that it is impossible to make str2 a subsequence of str1 using the operation at most once. 
Therefore, false is returned.</pre>

### Constraints
<ul>
	<li><code>1 &lt;= str1.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= str2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>str1</code> and <code>str2</code> consist of only lowercase English letters.</li>
</ul>
<!-- description:end -->

## Solutions
<!-- solution:start -->
### 1. Two Pointers
This problem actually requires us to determine whether a string $s$ is a subsequence of another string $t$. However, the characters do not have to match exactly. If two characters are the same, or one character is the next character of the other, they can match.
The time complexity is $O(m + n)$, where $m$ and $n$ are the lengths of the strings $str1$ and $str2$ respectively. The space complexity is $O(1)$.
<!-- tabs:start -->
#### Java
```java
// 2825. Make String a Subsequence Using Cyclic Increments

// Two-Pointer Greedy Matching
// Runtime: 6ms

// Complexity:
// + Time: O(n + m)
// + Space: O(1)

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0; // Pointers for str1 and str2
        
        while (i < str1.length() && j < str2.length()) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                j++; 
            }
            i++;
        }
        
        return j == str2.length();
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
