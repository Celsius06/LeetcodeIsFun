// 1261. Find Elements in a Contaminated Binary Tree | Medium
// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

// DSAs | Methods & Approaches
// Runtime: 20ms (21/02/2025 | 11pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)
// n is the number of nodes in the binary tree

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

class FindElements {
    private HashSet<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recover(root, 0);
    }

    private void recover(TreeNode node, int val) {
        if (node == null)
            return;
        node.val = val;
        values.add(val);
        recover(node.left, 2 * val + 1);
        recover(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
