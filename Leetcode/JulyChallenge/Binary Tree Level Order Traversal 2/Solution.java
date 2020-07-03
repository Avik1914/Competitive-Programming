/*
107. Binary Tree Level Order Traversal II
Easy

1425

212

Add to List

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res=new ArrayList();
        dfs(root,1);
        return res;
        
    }
    
    public void dfs(TreeNode root,int level){
        if(root==null)
            return;
        if(level>res.size())
            res.add(0,new ArrayList());
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        res.get(res.size()-level).add(root.val);
        
    }
}
