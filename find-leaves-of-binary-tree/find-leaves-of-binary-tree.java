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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res=new ArrayList();
        dfs(root);
        return res;
    }
    
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lc=dfs(root.left);
        int rc=dfs(root.right);
        
        int val=Math.max(lc,rc);
        if(res.size()<=val){
            res.add(new ArrayList());
        }
        res.get(val).add(root.val);
        return val+1;
    }
}