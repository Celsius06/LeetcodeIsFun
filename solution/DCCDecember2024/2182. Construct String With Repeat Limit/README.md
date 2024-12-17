---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Greedy
    - Hash Table
    - String
    - Counting
    - Heap (Priority Queue)
---

<!-- problem:start -->
# [2182. Construct String With Repeat Limit](https://leetcode.com/problems/construct-string-with-repeat-limit)
## Description
<!-- description:start -->
<p>You are given a string <code>s</code> and an integer <code>repeatLimit</code>. Construct a new string <code>repeatLimitedString</code> using the characters of <code>s</code> such that no letter appears <strong>more than</strong> <code>repeatLimit</code> times <strong>in a row</strong>. You do <strong>not</strong> have to use all characters from <code>s</code>.</p>
<p>Return <em>the <strong>lexicographically largest</strong> </em><code>repeatLimitedString</code> <em>possible</em>.</p>
<p>A string <code>a</code> is <strong>lexicographically larger</strong> than a string <code>b</code> if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears later in the alphabet than the corresponding letter in <code>b</code>. If the first <code>min(a.length, b.length)</code> characters do not differ, then the longer string is the lexicographically larger one.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> s = &quot;cczazcc&quot;, repeatLimit = 3
<strong>Output:</strong> &quot;zzcccac&quot;
<strong>Explanation:</strong> We use all of the characters from s to construct the repeatLimitedString &quot;zzcccac&quot;.
The letter &#39;a&#39; appears at most 1 time in a row.
The letter &#39;c&#39; appears at most 3 times in a row.
The letter &#39;z&#39; appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return &quot;zzcccac&quot;.
Note that the string &quot;zzcccca&quot; is lexicographically larger but the letter &#39;c&#39; appears more than 3 times in a row, so it is not a valid repeatLimitedString.
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> s = &quot;aababab&quot;, repeatLimit = 2
<strong>Output:</strong> &quot;bbabaa&quot;
<strong>Explanation:</strong> We use only some of the characters from s to construct the repeatLimitedString &quot;bbabaa&quot;. 
The letter &#39;a&#39; appears at most 2 times in a row.
The letter &#39;b&#39; appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return &quot;bbabaa&quot;.
Note that the string &quot;bbabaaa&quot; is lexicographically larger but the letter &#39;a&#39; appears more than 2 times in a row, so it is not a valid repeatLimitedString.
</pre>

### Constraints
<ul>
	<li><code>1 &lt;= repeatLimit &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
<!-- description:end -->


<p>&nbsp;</p>


## Solutions
<!-- solution:start --
<!-- tabs:start -->
#### Java
```java
// 2182. Construct String With Repeat Limit

// Priority Queue (Max-Heap)
// Runtime: 32ms

// Complexity:
// + Time: O(k * log(n))
// + Space: O(n)

import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (char i = 'a'; i <= 'z'; i++) {
            if (freq[i - 'a'] > 0) {
                maxHeap.offer(new int[]{i, freq[i - 'a']});
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            char ch = (char) current[0];
            int count = Math.min(current[1], repeatLimit);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }

            if (current[1] > repeatLimit) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                result.append((char) next[0]);
                next[1]--;

                if (next[1] > 0) {
                    maxHeap.offer(next);
                }

                maxHeap.offer(new int[]{ch, current[1] - repeatLimit});
            }
        }

        return result.toString();
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
