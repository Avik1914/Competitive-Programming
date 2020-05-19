/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        List<Integer> res=new ArrayList();
        if(root==null)
            return res;
        while(!queue.isEmpty()){
            int size=queue.size();
            int val=-1;
            while(size-->0){
                TreeNode t=queue.poll();
                val=t.val;
                if(t.left!=null)
                    queue.add(t.left);
                if(t.right!=null)
                    queue.add(t.right);
            }
            res.add(val);
        }
        return res;
    }
}
