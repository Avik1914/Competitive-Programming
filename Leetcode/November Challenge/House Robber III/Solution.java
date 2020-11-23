/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
    Map<TreeNode,Integer> dp;
    public int rob(TreeNode root) {
        dp=new HashMap();
        return dfs(root);
    }
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.val;
        if(dp.get(root)!=null)
            return dp.get(root);
        int taken=root.val;
        int notTaken=0;
        if(root.left!=null)
            taken+=dfs(root.left.left)+dfs(root.left.right);
        if(root.right!=null)
            taken+=dfs(root.right.left)+dfs(root.right.right);
        notTaken+=dfs(root.right);
        notTaken+=dfs(root.left);
        dp.put(root,Math.max(taken,notTaken));
        return dp.get(root);
    }
}
