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
    double res=0.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int[] dfs(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int[] lc=dfs(root.left);
        int[] rc=dfs(root.right);
        int num=(lc[0]+rc[0]+root.val);
        int deno=(lc[1]+rc[1]+1);
        res=Math.max(res,(double)num/(double)deno);
        
        return new int[]{num,deno};
        
    }
}
