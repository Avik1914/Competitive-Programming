/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    int itr=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        itr=inorder.length-1;
        return build(inorder,postorder,0,itr,map);
    }
    
    public TreeNode build(int[] inorder,int[] postorder,int lo,int hi,Map<Integer,Integer> map){
        if(itr<0 || lo>hi)
            return null;
        int val=postorder[itr--];
        TreeNode t=new TreeNode(val);
        t.right=build(inorder,postorder,map.get(val)+1,hi,map);
        t.left=build(inorder,postorder,lo,map.get(val)-1,map);
        return t;
        
    }
}
