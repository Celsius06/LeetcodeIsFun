// 684. Redundant Connection
// Difficulty: Medium

// Disjoint Set Union
// Runtime: 0ms (29/01/2025 | 10pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

class Solution {
    private int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int i = 0;; ++i) {
            int pa = find(edges[i][0] - 1);
            int pb = find(edges[i][1] - 1);
            if (pa == pb) {
                return edges[i];
            }
            p[pa] = pb;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
