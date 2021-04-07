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
    int res=0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public boolean dfs(TreeNode root){
        if(root==null)
            return true;
        boolean lc=dfs(root.left);
        boolean rc=dfs(root.right);
        
        if(lc && rc){
            if(root.left!=null && root.val!=root.left.val)
                return false;
            if(root.right!=null && root.val!=root.right.val)
                return false;
            res++;
        }
        
        return lc && rc;
    }
}