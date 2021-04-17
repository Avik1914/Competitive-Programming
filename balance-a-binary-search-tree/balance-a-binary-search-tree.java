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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes=new ArrayList<>();
        dfs(root,nodes);
        return builder(nodes,0,nodes.size()-1);
    }
    
    public TreeNode builder(List<Integer> nodes,int lo,int hi){
        if(lo>hi)
            return null;
        int mid=(lo+hi)/2;
        TreeNode node=new TreeNode(nodes.get(mid));
        node.left=builder(nodes,lo,mid-1);
        node.right=builder(nodes,mid+1,hi);
        return node;
    }
    
    public void dfs(TreeNode root,List<Integer> res){
        if(root==null)
            return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
}