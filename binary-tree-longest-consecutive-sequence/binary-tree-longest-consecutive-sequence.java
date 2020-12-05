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
    int max=0;
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,root.val,1);
        return max;
    }
    
    public void dfs(TreeNode root,int prev,int count){
        max=Math.max(count,max);
        if(root==null)
            return;
        
        if(prev+1==root.val){
            dfs(root.left,root.val,count+1);
            dfs(root.right,root.val,count+1);
        }
        else{
            dfs(root.left,root.val,1);
            dfs(root.right,root.val,1);
        }
        
    }
}
