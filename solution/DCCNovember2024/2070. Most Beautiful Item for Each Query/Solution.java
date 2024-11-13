// Sorting, Prefix Maximums, Binary Search

// The overall runtime complexity is O(n log n + m log n), where n is the number of items, and m is the number of queries. 
// Sorting items takes O(n log n), building the maxBeauty array takes O(n), and each query is answered in O(log n) due to binary search.

import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]); 
            }
        });
        
        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1]; 
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }
        
        int m = queries.length;
        int[] answer = new int[m];
        
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }

            if (right >= 0) {
                answer[i] = maxBeauty[right];
            } else {
                answer[i] = 0; 
            }
        }
        
        return answer;
    }
}