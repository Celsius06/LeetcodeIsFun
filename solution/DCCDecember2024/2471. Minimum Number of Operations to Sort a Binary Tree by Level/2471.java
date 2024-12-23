// 2471. Minimum Number of Operations to Sort a Binary Tree by Level

// BFS, Queue, ArrayList, Map
// Runtime: 71ms

// Complexity:
// + Time: O(n log(k))
// + Space: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalOperations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Collect all node values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Calculate minimum swaps for the current level
            totalOperations += calculateMinimumSwaps(level);
        }

        return totalOperations;
    }

    private int calculateMinimumSwaps(List<Integer> level) {
        int n = level.size();
        int[] arr = level.stream().mapToInt(i -> i).toArray();

        // Map values to their sorted indices
        Map<Integer, Integer> indexMap = new LinkedHashMap<>();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        for (int i = 0; i < n; i++) {
            indexMap.put(sortedArr[i], i);
        }

        // Replace array values with their sorted indices
        for (int i = 0; i < n; i++) {
            arr[i] = indexMap.get(level.get(i));
        }

        // Count cycles for minimum swaps
        boolean[] visited = new boolean[n];
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == i)
                continue;

            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j];
                cycleLength++;
            }

            swapCount += (cycleLength - 1);
        }

        return swapCount;
    }
}
