/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
       Queue<TreeNode> stack=new LinkedList();
       Set<TreeNode> set=new HashSet();
       stack.add(root);
       set.add(root);
       
        while(!stack.isEmpty()){
           TreeNode tr=stack.poll();
           if(tr.right!=null){
               if(set.contains(tr.right.right)){
                   tr.right=null;
                   return root;
               }
               stack.add(tr.right);
               set.add(tr.right);
           }
           if(tr.left!=null){
               if(set.contains(tr.left.right)){
                   tr.left=null;
                   return root;
               }
               stack.add(tr.left);
               set.add(tr.left);
           }  
       }
        
      return root;
    }
}
