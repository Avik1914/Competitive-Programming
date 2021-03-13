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
    public int kthSmallest(TreeNode root, int k) {
        int val=countNodes(root.left);
        if(val==k-1)
            return root.val;
        if(val>=k)
            return kthSmallest(root.left,k);
        return kthSmallest(root.right,k-val-1);
    }
    
    public int countNodes(TreeNode root){
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}