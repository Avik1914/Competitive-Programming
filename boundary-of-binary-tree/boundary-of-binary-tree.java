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
    int maxDepth=-1;
    List<Integer> ansLeft;
    List<Integer> ansRight;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ansLeft=new ArrayList();
        ansRight=new ArrayList();
        ansLeft.add(root.val);
        leftCalc(root.left);
        rightCalc(root.right);
        inorder(root.left);
        inorder(root.right);
        ansLeft.addAll(ansRight);
        return ansLeft;
    }
    
    public void leftCalc(TreeNode root){
        if(root==null || (root.left==null && root.right==null))
            return;
        ansLeft.add(root.val);
        if(root.left!=null)
           leftCalc(root.left);
        else
          leftCalc(root.right);
    }
    
    public void rightCalc(TreeNode root){
        if(root==null || (root.left==null && root.right==null))
            return;
        ansRight.add(0,root.val);
        if(root.right!=null)
           rightCalc(root.right);
        else
           rightCalc(root.left);
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            ansLeft.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }
}