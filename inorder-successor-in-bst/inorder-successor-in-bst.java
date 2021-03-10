/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null){
            p=p.right;
            while(p.left!=null)
                p=p.left;
            return p;
        }
        TreeNode prev=null;
        while(root!=p){
            if(root.val>p.val)
                prev=root;
            root=root.val<p.val?root.right:root.left;
        }
        return prev;
    }
}