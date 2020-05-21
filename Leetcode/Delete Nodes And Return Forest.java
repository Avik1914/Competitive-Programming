/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
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
class TreeNodeWrapper{
    TreeNode node;
    boolean isRoot;
    TreeNodeWrapper(TreeNode node,boolean isRoot){
        this.node=node;
        this.isRoot=isRoot;
    }
}
class Solution {
  /*Iterative Approach*/
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> lkp=new HashSet();
        for(int i:to_delete)
            lkp.add(i);
        List<TreeNode> res=new ArrayList();
        Stack<TreeNodeWrapper> stack=new Stack();
        TreeNodeWrapper t=new TreeNodeWrapper(root,true);
        stack.push(t);
        TreeNodeWrapper u;
        while(!stack.isEmpty()){
            t=stack.pop();
            boolean flag=lkp.contains(t.node.val);
            if(t.isRoot && !flag)
                res.add(t.node);
            if(t.node.left!=null){
                u=new TreeNodeWrapper(t.node.left,flag);
                    if(lkp.contains(t.node.left.val))
                        t.node.left=null;
                stack.push(u);
            }
            if(t.node.right!=null){
                u=new TreeNodeWrapper(t.node.right,flag);
                    if(lkp.contains(t.node.right.val))
                        t.node.right=null;
                stack.push(u);
            }
        }
        
        
        //dfs(root,lkp,res,true);
        return res;
    }
    /*Recursive Approach*/
    public TreeNode dfs(TreeNode root,Set<Integer> lkp,List<TreeNode> res,boolean flag){
        if(root==null)
            return null;
        boolean isDelete=lkp.contains(root.val);
        if(flag && !isDelete)
            res.add(root);
        root.left=dfs(root.left,lkp,res,isDelete);
        root.right=dfs(root.right,lkp,res,isDelete);
        return isDelete?null:root;
    }
}
