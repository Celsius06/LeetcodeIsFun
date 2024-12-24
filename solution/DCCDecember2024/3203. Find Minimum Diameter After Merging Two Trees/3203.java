// 3203. Find Minimum Diameter After Merging Two Trees

// BFS
// Runtime: 148ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = getDiameter(edges1);
        int diameter2 = getDiameter(edges2);
        int combinedDiameter = (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1;
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    private int getDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = buildGraph(edges, n);

        // Identify connected components using BFS
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int maxDiameter = 0;
        for (int root : uf.getRoots()) {
            maxDiameter = Math.max(maxDiameter, findDiameter(graph, root));
        }
        return maxDiameter;
    }

    private int findDiameter(List<Integer>[] graph, int root) {
        // Use BFS to find the diameter within this connected component
        int farthest = bfs(graph, root)[0];
        return bfs(graph, farthest)[1];
    }

    private int[] bfs(List<Integer>[] graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.offer(start);
        visited[start] = true;

        int farthestNode = start;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int node = q.poll();
                farthestNode = node;
                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
            distance++;
        }

        return new int[] { farthestNode, distance - 1 };
    }

    private List<Integer>[] buildGraph(int[][] edges, int n) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public List<Integer> getRoots() {
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            roots.add(find(i));
        }
        return new ArrayList<>(roots);
    }
}
