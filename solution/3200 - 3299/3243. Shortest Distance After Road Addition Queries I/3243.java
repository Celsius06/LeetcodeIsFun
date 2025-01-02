// 3243. Shortest Distance After Road Addition Queries I

// BFS 
// Runtime: 91ms

// Complexity:
// + Time: O(queries.length * (n + edges))
// + Space: O(n + edges)

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Initialize the linear graph: i -> i+1
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(v); // Add the new road

            result[i] = bfs(graph, n);
        }

        return result;
    }

    private int bfs(List<List<Integer>> graph, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(new int[] { 0, 0 }); // {node, distance}
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], dist = curr[1];

            if (node == n - 1)
                return dist;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[] { neighbor, dist + 1 });
                }
            }
        }

        return Integer.MAX_VALUE; // Should never reach here
    }
}
