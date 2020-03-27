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
   
  /* Recursive Approach*/
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
            root.left=deleteNode(root.left,key);
        else if(root.val<key)
            root.right=deleteNode(root.right,key);
        else{
           if(root.left==null)
               return root.right;
            if(root.right==null)
                return root.left;
            TreeNode max=findMax(root.left);
            root.val=max.val;
            root.left=deleteNode(root.left,root.val);
        }
        return root;
    }
    public TreeNode findMax(TreeNode root){
        while(root.right!=null)
            root=root.right;
        return root;
    }
}

/*Iterative Approach*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        TreeNode curr=root; 
        TreeNode par=null;
        
        while(curr!=null && curr.val!=key){
            par=curr;
            if(curr.val>key)
                curr=curr.left;
            else if(curr.val<key)
                curr=curr.right;
            else
                break;
        }
        if(curr!=null){
            if(curr.right==null){
                if(par==null){
                    curr=curr.left;
                    root=curr;
                }
                else if(par.right==curr)
                    par.right=curr.left;
                else
                    par.left=curr.left;
            }
            else if(curr.left==null){
                if(par==null){
                    curr=curr.right;
                    root=curr;
                }
                else if(par.right==curr)
                    par.right=curr.right;
                else
                    par.left=curr.right;
            }else{
                TreeNode[] max=findMax(curr.left,curr);
                curr.val=max[0].val;
                
                 if(max[1].left==max[0])
                    max[1].left=max[0].left;
                 else
                    max[1].right=max[0].left;
                if(par==null)
                    root=curr;
            }
        }
        return root;
    }
    
    public TreeNode[] findMax(TreeNode root,TreeNode par){
        while(root.right!=null){
            par=root;
            root=root.right;
        }
       
        return new TreeNode[]{root,par};
    }
}
