// 2097. Valid Arrangement of Pairs

// Hierholzer's Algorithm
// Runtime: 169ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build adjacency list and degree maps
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        
        // Step 2: Find the starting node
        int startNode = pairs[0][0]; // Default start
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }
        
        // Step 3: Perform Hierholzer's algorithm
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).pop());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }
        
        // Step 4: Return result
        Collections.reverse(result);
        return result.toArray(new int[0][0]);
    }
}
