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
    int height=0;
    TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        res=null;
        getHeight(root,0);
        deep(root,0);
        return res;
    }
    
    public void getHeight(TreeNode root,int count){
      height=Math.max(height,count);
      if(root==null)
            return;
        
        getHeight(root.left,count+1);
        getHeight(root.right,count+1);
    }
    
    public boolean deep(TreeNode root,int count){
        if(count==height)
            return true;
        if(root==null)
            return false;
        
        boolean lc=deep(root.left,count+1);
        boolean rc=deep(root.right,count+1);
        
        if(lc && rc)
            res=root;
        return lc||rc;
    }
}
