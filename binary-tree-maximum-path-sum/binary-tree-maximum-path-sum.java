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
    int res=-1001;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lc=dfs(root.left);
        int rc=dfs(root.right);
        
        int a=root.val+Math.max(Math.max(0,lc),Math.max(rc,lc+rc));
        res=Math.max(res,a);
        
        return root.val+Math.max(0,Math.max(lc,rc));
        
    }
}