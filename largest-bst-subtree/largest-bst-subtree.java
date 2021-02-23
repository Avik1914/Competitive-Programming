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
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int[] dfs(TreeNode root){
        if(root==null)
            return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0,0};
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
       
        if(left[3]==0 && right[3]==0 && root.val>left[0] && root.val<right[1]){
            res=Math.max(res,left[2]+right[2]+1);
            return new int[]{Math.max(root.val,right[0]),Math.min(left[1],root.val),left[2]+right[2]+1,0};
        }
        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0,1}; 
    }
}