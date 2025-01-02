// 2415. Reverse Odd Levels of Binary Tree

// BFS, Array
// Iterative Level-Order Traversal
// Runtime: 7ms

// Complexity:
// + Time: O(n)
// + Space: O(n)

import java.util.LinkedList;
import java.util.Queue;

abstract class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOddLevel = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] levelNodes = new TreeNode[size];
            int index = 0;

            // Collect nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes[index++] = node;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // Reverse values of nodes if the level is odd
            if (isOddLevel) {
                int left = 0, right = levelNodes.length - 1;
                while (left < right) {
                    int temp = levelNodes[left].val;
                    levelNodes[left].val = levelNodes[right].val;
                    levelNodes[right].val = temp;
                    left++;
                    right--;
                }
            }

            isOddLevel = !isOddLevel;
        }

        return root;
    }
}
