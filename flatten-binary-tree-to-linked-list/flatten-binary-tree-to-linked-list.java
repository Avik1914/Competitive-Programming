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
    TreeNode lastSeen=null;
    public void flatten(TreeNode root) {
        dfs(root);
        
    }
    
    public TreeNode dfs(TreeNode root){
        if(root==null)
            return null;
        lastSeen=root;
        TreeNode lc=dfs(root.left);
       
        
        if(root.left!=null){
            
            lastSeen.right=root.right;
            root.right=root.left;
            root.left=null;
        }
         TreeNode rc=dfs(root.right);
        return root;
    }
}