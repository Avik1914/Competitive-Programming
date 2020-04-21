/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
*/

/* O(n) solution */

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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    
    public TreeNode dfs(int[] preorder,int max,int min){
        if(i==preorder.length || preorder[i]>max || preorder[i]<min)
            return null;
        TreeNode node=new TreeNode(preorder[i++]);
        node.left=dfs(preorder,node.val,min);
        node.right=dfs(preorder,max,node.val);
        return node;
    }
}


/* O(nlogn) Solution */

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
    int start;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=preorder.clone();
        start=0;
        Arrays.sort(inorder);
        return create(inorder,preorder,0,inorder.length-1);
    }
    
    public TreeNode create(int[] inorder,int[] preorder,int lo,int hi){
        if(lo>hi)
            return null;
        TreeNode node=new TreeNode(preorder[start]);
        int val=search(inorder,preorder[start],lo,hi);
        if(val==-1)
            return node;
        start++;
        node.left=create(inorder,preorder,lo,val-1);
        node.right=create(inorder,preorder,val+1,hi);
        return node;
    }
    
    public int search(int[] in,int val,int lo,int hi){
        
        
        for(int i=lo;i<=hi;i++){
            if(in[i]==val)
                return i;
        }
        return -1;
    }
}
