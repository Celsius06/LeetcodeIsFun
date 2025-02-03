// 2493. Divide Nodes Into the Maximum Number of Groups
// Difficulty: Hard

// Array, List, Queue (BFS)
// Bipartite Checking, Component Processing 
// Runtime: 343ms (03/02/2025 | 4pm - GMT+7)

// Complexity:
// + Time: O(m + n)
// + Space: O(m + n)

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        // Build graph (0-indexed)
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }

        boolean[] globalVisited = new boolean[n];
        int totalGroups = 0;

        // Process each component once.
        for (int i = 0; i < n; ++i) {
            if (!globalVisited[i]) {
                int groupsForComponent = processComponent(i, g, globalVisited, n);
                if (groupsForComponent == -1)
                    return -1;
                totalGroups += groupsForComponent;
            }
        }
        return totalGroups;
    }

    private int processComponent(int start, List<Integer>[] g, boolean[] globalVisited, int n) {
        // Collect all nodes in the component via BFS.
        List<Integer> compNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        globalVisited[start] = true;
        compNodes.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nei : g[cur]) {
                if (!globalVisited[nei]) {
                    globalVisited[nei] = true;
                    compNodes.add(nei);
                    queue.offer(nei);
                }
            }
        }

        // For the current component, try each node as a potential starting point
        // to determine the maximum levels (groups) possible.
        int maxGroups = 0;
        for (int node : compNodes) {
            int groups = bfsGroups(node, g, compNodes.size(), n);
            if (groups == -1)
                return -1;
            maxGroups = Math.max(maxGroups, groups);
        }
        return maxGroups;
    }

    // Perform BFS starting at node 'start' and check bipartiteness while computing
    // levels.
    private int bfsGroups(int start, List<Integer>[] g, int compSize, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, 0);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 1;
        int mx = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : g[cur]) {
                if (dist[nei] == 0) {
                    dist[nei] = dist[cur] + 1;
                    mx = Math.max(mx, dist[nei]);
                    q.offer(nei);
                } else if (Math.abs(dist[nei] - dist[cur]) != 1) {
                    return -1; // bipartite condition violated
                }
            }
        }
        return mx;
    }
}
