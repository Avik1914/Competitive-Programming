/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack=new Stack();
        if(root==null)
            return 0;
        stack.push(root);
        int sum=0;
        
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null){
                if(node.left.right==null && node.left.left==null)
                    sum+=node.left.val;
                else 
                    stack.push(node.left);
            }
            if(node.right!=null)
                stack.push(node.right);
        }
        return sum;
    }
}
