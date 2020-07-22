/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res=new ArrayList();
        dfs(root,1);
        return res;
    }
    
    public void dfs(TreeNode root,int h){
        if(root==null)
            return;
        if(res.size()<h)
            res.add(new ArrayList());
        if(h%2==0)
            res.get(h-1).add(0,root.val);
        else
            res.get(h-1).add(root.val);
        dfs(root.left,h+1);
        dfs(root.right,h+1);
    }
}
