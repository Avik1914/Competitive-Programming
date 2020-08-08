/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
*/

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
    public double diff;
    public int res;
    public int closestValue(TreeNode root, double target) {
        diff=Double.MAX_VALUE;
        dfs(root,target);
        return res;
        
    }
    public void dfs(TreeNode root,double target){
        if(root==null)
            return;
        double val=Math.abs(root.val-target);
        if(val<diff){
            diff=val;
            res=root.val;
        }
        if(root.val>target)
            dfs(root.left,target);
        else
            dfs(root.right,target);
    }
}
