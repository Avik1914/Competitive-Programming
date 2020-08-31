/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root,key,null);
    }
    
    public TreeNode dfs(TreeNode node,int key,TreeNode prev){
        if(node==null)
            return null;
        if(node.val>key)
            node.left=dfs(node.left,key,node);
        else if(node.val<key)
            node.right=dfs(node.right,key,node);
        else if(node.left==null && node.right==null)
            return null;
        else{
            TreeNode temp=node;
            if(temp.left!=null){
                prev=temp;
                temp=temp.left;
                while(temp.right!=null){
                    prev=temp;
                    temp=temp.right;
                }
                if(prev.right==temp)
                    prev.right=temp.left;
                else
                    prev.left=temp.left;
                node.val=temp.val;
            }else{
                prev=temp;
                temp=temp.right;
                while(temp.left!=null){
                    prev=temp;
                    temp=temp.left;
                }
                if(prev.right==temp)
                    prev.right=temp.right;
                else
                    prev.left=temp.right;
                node.val=temp.val;
            }
        }
        return node;
    }
    
    
}
