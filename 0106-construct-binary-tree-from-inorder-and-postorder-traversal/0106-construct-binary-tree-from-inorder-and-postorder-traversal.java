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
int idx;    
    HashMap<Integer, Integer> mp = new HashMap<>();

  

    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=postorder.length-1;
         for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);  
        }
        return build(postorder, 0, inorder.length - 1);
    }
        
        public TreeNode build(int[] postorder, int st, int end) {
        if (st > end) {
            return null;
        }
 
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

   
        int mid = mp.get(rootVal);

        root.right = build(postorder, mid + 1, end);
        root.left = build(postorder, st, mid - 1);
      

        return root;
        
    }
}