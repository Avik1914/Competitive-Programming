/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
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
    int height;
    int sum;
    public int deepestLeavesSum(TreeNode root) {
        height=-1;
        sum=0;
        dfs(root,0);
        return sum;
    }
    
    public void dfs(TreeNode root,int h){
        if(root==null)
            return;
        if(h>height){
            height=h;
            sum=root.val;
        }else if(h==height)
            sum+=root.val;
        dfs(root.left,h+1);
        dfs(root.right,h+1);
    }
}
