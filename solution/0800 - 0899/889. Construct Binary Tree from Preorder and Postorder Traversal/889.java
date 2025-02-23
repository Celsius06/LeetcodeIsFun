// 889. Construct Binary Tree from Preorder and Postorder Traversal | Medium
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

// Hash Map | Recursion
// Runtime: 1ms (23/02/2025 | 9pm - GMT+7)

// Complexity:
// + Time: O(n)
// + Space: O(n)

/**
 * Definition for a binary tree node.
 * class TreeNode {
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
    HashMap<Integer, Integer> postMap = new HashMap<>();
    int[] pre, post;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pre = preorder;
        post = postorder;
        for (int i = 0; i < post.length; i++)
            postMap.put(post[i], i);
        return build(0, 0, pre.length);
    }

    private TreeNode build(int preStart, int postStart, int size) {
        if (size == 0)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (size == 1)
            return root;

        int leftRoot = pre[preStart + 1];
        int leftSize = postMap.get(leftRoot) - postStart + 1;
        int rightSize = size - 1 - leftSize;

        root.left = build(preStart + 1, postStart, leftSize);
        root.right = build(preStart + 1 + leftSize, postStart + leftSize, rightSize);
        return root;
    }
}
