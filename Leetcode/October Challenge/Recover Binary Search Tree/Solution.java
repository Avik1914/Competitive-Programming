/*
You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
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
    
    public void recoverTree(TreeNode root) {
        TreeNode[] obj=new TreeNode[3];
        dfs(root,obj);
        int temp=obj[1].val;
        obj[1].val=obj[2].val;
        obj[2].val=temp;
    }
    
    public void dfs(TreeNode root,TreeNode[] obj){
        if(root==null)
            return;
        dfs(root.left,obj);
        if(obj[0]!=null && obj[0].val>root.val){
            if(obj[1]==null){
                obj[1]=obj[0];
                obj[2]=root;
            }
            else
                obj[2]=root;
        }
        obj[0]=root;
        dfs(root.right,obj);
    }
    
}
