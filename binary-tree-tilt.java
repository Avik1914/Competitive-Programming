/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lc=dfs(root.left);
        int rc=dfs(root.right);
        sum+=Math.abs(lc-rc);
        return lc+rc+root.val;
        
    }
}
