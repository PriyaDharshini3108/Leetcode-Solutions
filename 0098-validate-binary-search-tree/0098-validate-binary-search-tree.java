/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean validate(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return validate(root.left, root.val, minValue) &&
               validate(root.right, maxValue, root.val);
    }
}