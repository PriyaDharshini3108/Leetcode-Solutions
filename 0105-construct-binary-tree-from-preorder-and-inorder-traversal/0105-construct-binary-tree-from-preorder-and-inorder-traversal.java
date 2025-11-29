import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> rec = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rec.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, rec);
    }

    private TreeNode helper(int[] preorder, int[] inorder,
                            int preStart, int preEnd,
                            int inStart, int inEnd,
                            HashMap<Integer, Integer> rec) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int idx = rec.get(val);
        int leftSubtreeSize = idx - inStart;

        root.left = helper(preorder, inorder,
                            preStart + 1, preStart + leftSubtreeSize,
                            inStart, idx - 1,
                            rec);

        root.right = helper(preorder, inorder,
                             preStart + leftSubtreeSize + 1, preEnd,
                             idx + 1, inEnd,
                             rec);

        return root;
    }
}