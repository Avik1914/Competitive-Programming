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
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev=null;
        dfs(root);
        
    }
    
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.right);
        dfs(root.left);
        if(prev!=null)
            root.right=prev;
        prev=root;
        root.left=null;
        
    }
}