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
    public boolean isValidBST(TreeNode root) {
        return isBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean isBst(TreeNode root,long lo,long hi){
        if(root==null)
            return true;
        if(root.val<=lo || root.val>=hi)
            return false;
        return isBst(root.left,lo,root.val) && isBst(root.right,root.val,hi);
    }
}