// 1028. Recover a Tree From Preorder Traversal | Difficulty: Hard
// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

// Stack | Iteration
// Runtime: 6ms (22/02/2025 | 11pm - GMT+7)

// Complexity:
// + Time: O(n) - n is the length of the traversal string
// + Space: O(n) - n is the length of the traversal string

import java.util.Stack;

class TreeNode {
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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            int val = 0;
            while (i < n && traversal.charAt(i) != '-') {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(val);
            while (stack.size() > depth)
                stack.pop(); // Pop until parent depth
            if (!stack.isEmpty()) {
                if (stack.peek().left == null)
                    stack.peek().left = node;
                else
                    stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.firstElement(); // Root is at bottom of stack
    }
}
