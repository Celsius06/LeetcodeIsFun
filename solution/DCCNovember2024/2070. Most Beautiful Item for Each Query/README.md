# 2070. Most Beautiful Item for Each Query

## Problem Statement

You are given a 2D integer array `items` where `items[i] = [price_i, beautyi]` denotes the price and beauty of an item. You are also given a 0-indexed integer array `queries`. For each `queries[j]`, you want to determine the maximum beauty of an item whose price is less than or equal to `queries[j]`. If no such item exists, the answer to this query is 0.

Return an array `answer` of the same length as `queries` where `answer[j]` is the answer to the jth query.

### Examples

#### Example 1:
- **Input**: `items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]`
- **Output**: `[2,4,5,5,6,6]`
- **Explanation**:
  - For `queries[0]=1`, only `[1,2]` has `price <= 1`, so the answer is 2.
  - For `queries[1]=2`, items `[1,2]` and `[2,4]` have prices ≤ 2, so the answer is 4.
  - For `queries[2]=3` and `queries[3]=4`, items `[1,2]`, `[3,2]`, `[2,4]`, and `[3,5]` have prices ≤ 3 and ≤ 4, so the answer is 5.
  - For `queries[4]=5` and `queries[5]=6`, all items have prices ≤ 5 and ≤ 6, so the answer is 6.

#### Example 2:
- **Input**: `items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]`
- **Output**: `[4]`

#### Example 3:
- **Input**: `items = [[10,1000]], queries = [5]`
- **Output**: `[0]`

### Constraints
- `1 <= items.length, queries.length <= 10^5`
- `items[i].length == 2`
- `1 <= pricei, beautyi, queries[j] <= 10^9`

## Solution Approach

### Steps
1. **Sorting**: Sort `items` by price in ascending order. If prices are the same, sort by beauty in descending order.
2. **Precompute Maximum Beauty**: Create an array `maxBeauty`, where each element stores the highest beauty up to that price.
3. **Binary Search for Queries**: For each query, use binary search to find the highest price that is less than or equal to the query, and return the corresponding beauty.

### Helper Functions
#### Binary Search
Use binary search to find the highest price in `items` that is less than or equal to each query.

### Solution Code
```java
import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items by price (ascending). If prices are equal, sort by beauty (descending).
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });
        
        int n = items.length;
        
        // Step 2: Precompute max beauty up to each price.
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        
        int m = queries.length;
        int[] answer = new int[m];
        
        // Step 3: Process each query using binary search.
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int left = 0, right = n - 1;
            
            // Binary search for the highest price less than or equal to the query.
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            // Step 4: If found, add the maximum beauty for the found price to answer.
            if (right >= 0) {
                answer[i] = maxBeauty[right];
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}
