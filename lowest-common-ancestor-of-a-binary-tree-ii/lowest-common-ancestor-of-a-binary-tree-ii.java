/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count=0;
    TreeNode ans;
    TreeNode p;
    TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=null;
        this.p=p;
        this.q=q;
        dfs(root,false);
        return count<2 ? null:ans;
    }
    
    public boolean dfs(TreeNode root,boolean flag){
        if(root==null)
            return flag;
        if(root==p || root==q){
            count++;
            if(ans==null)
                ans=root;
            flag=true;
        }
        boolean lc=dfs(root.left,flag);
        boolean rc=dfs(root.right,flag);
        if(rc && lc)
            ans=root;
        return lc|| rc;
    }
}
