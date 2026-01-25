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
class BSTIterator {
     private static Stack<TreeNode> memory = new Stack<>();
    public static void insertNode(TreeNode root){
        if(root == null) return;
          TreeNode temp = root;
            while(temp != null){
                memory.push(temp);
                temp = temp.left;
            }
    }

    public BSTIterator(TreeNode root) {
        insertNode(root);
    }
    
    public int next() {
        TreeNode top = memory.pop();
        insertNode(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return (memory.size() != 0);
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */