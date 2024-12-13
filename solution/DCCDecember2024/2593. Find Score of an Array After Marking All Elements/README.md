---
Difficulty: Medium
Utilizable DSAs/Methods/Approaches:
    - Array
    - Hash Table
    - Sorting
    - Simulation
    - Heap (Priority Queue)
---

<!-- problem:start -->
# [2593. Find Score of an Array After Marking All Elements](https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements)
## Description
<!-- description:start -->
<p>You are given an array <code>nums</code> consisting of positive integers.</p>
<p>Starting with <code>score = 0</code>, apply the following algorithm:</p>
<ul>
	<li>Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.</li>
	<li>Add the value of the chosen integer to <code>score</code>.</li>
	<li>Mark <strong>the chosen element and its two adjacent elements if they exist</strong>.</li>
	<li>Repeat until all the array elements are marked.</li>
</ul>
<p>Return <em>the score you get after applying the above algorithm</em>.</p>

### Examples
<p><strong class="example">1.</strong></p>
<pre>
<strong>Input:</strong> nums = [2,1,3,4,5,2]
<strong>Output:</strong> 7
<strong>Explanation:</strong> We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [<u>2</u>,<u>1</u>,<u>3</u>,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [<u>2</u>,<u>1</u>,<u>3</u>,4,<u>5</u>,<u>2</u>].
- 4 is the only remaining unmarked element, so we mark it: [<u>2</u>,<u>1</u>,<u>3</u>,<u>4</u>,<u>5</u>,<u>2</u>].
Our score is 1 + 2 + 4 = 7.
</pre>

<p><strong class="example">2.</strong></p>
<pre>
<strong>Input:</strong> nums = [2,3,5,1,3,2]
<strong>Output:</strong> 5
<strong>Explanation:</strong> We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,<u>5</u>,<u>1</u>,<u>3</u>,2].
- 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [<u>2</u>,<u>3</u>,<u>5</u>,<u>1</u>,<u>3</u>,2].
- 2 is the only remaining unmarked element, so we mark it: [<u>2</u>,<u>3</u>,<u>5</u>,<u>1</u>,<u>3</u>,<u>2</u>].
Our score is 1 + 2 + 2 = 5.
</pre>

### Constraints
<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>
<!-- description:end -->


## Solutions
<!-- solution:start -->
### Solution 1: Priority Queue (Min Heap)

We use a priority queue to maintain the unmarked elements in the array, and each item in the queue is a tuple $(x, i)$, where $x$ and $i$ represent the element value and index of the array respectively. An array $vis$ is used to record whether the element in the array is marked.

Each time we take out the smallest element $(x, i)$ from the queue, we add $x$ to the answer, and then mark the element at the $i$ position, and the left and right adjacent elements at the $i$ position, that is, the elements at the $i-1$ and $i+1$ positions. Then we determine whether the top element of the heap is marked. If it is marked, pop the top element of the heap until the top element is unmarked or the heap is empty.

Finally, return the answer.

The time complexity is $O(n \times \log n)$ and the space complexity is $O(n)$, where $n$ is the length of the array.

<!-- tabs:start -->
#### Java
```java
class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> q
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            q.offer(new int[] {nums[i], i});
        }
        long ans = 0;
        while (!q.isEmpty()) {
            var p = q.poll();
            ans += p[0];
            vis[p[1]] = true;
            for (int j : List.of(p[1] - 1, p[1] + 1)) {
                if (j >= 0 && j < n) {
                    vis[j] = true;
                }
            }
            while (!q.isEmpty() && vis[q.peek()[1]]) {
                q.poll();
            }
        }
        return ans;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->



<!-- solution:start -->
### Solution 2: Sorting

We can create an index array $idx$ where $idx[i]=i$, and then we sort the index array $idx$ according to the element values in the array $nums$. If the element values are the same, then sort them according to the index values.

Next, create an array $vis$ of length $n+2$ where $vis[i]=false$, which means whether the element in the array is marked.

We traverse the index array $idx$, and for each index $i$ in the array, if $vis[i+1]$ is $false$, that is, the element at position $i$ is not marked, we add $nums[i]$ to the answer, and then mark the element at position $i$, and the left and right adjacent elements at position $i$, that is, the elements at positions $i-1$ and $i+1$. Continue to traverse the index array $idx$ until the end.

Finally, return the answer.

The time complexity is $O(n \times \log n)$ and the space complexity is $O(n)$, where $n$ is the length of the array.

<!-- tabs:start -->
#### Java
```java
class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n + 2];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        long ans = 0;
        for (int i : idx) {
            if (!vis[i + 1]) {
                ans += nums[i];
                vis[i] = true;
                vis[i + 2] = true;
            }
        }
        return ans;
    }
}
```
<!-- tabs:end -->
<!-- solution:end -->
<!-- problem:end -->
