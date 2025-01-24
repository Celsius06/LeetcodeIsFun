// 802. Find Eventual Safe States
// Difficulty: Medium

// DFS
// Runtime: 5ms (24/01/2025 | 5pm - GMT+7)

// Complexity:
// + Time: O(V + E)
// + Space: O(V)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i, state)) {
                result.add(i);
            }
        }
        return result;
    }

    // DFS Helper function
    private boolean isSafe(int[][] graph, int node, int[] state) {
        if (state[node] > 0) {
            return state[node] == 2;
        }
        state[node] = 1; // Mark as visiting
        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor, state)) {
                return false;
            }
        }
        state[node] = 2; // Mark as safe
        return true;
    }
}
