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
    Set<TreeNode> set;
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<>(Arrays.asList(nodes));
        res=null;
        dfs(root);
        return res;
    }
    
    public boolean dfs(TreeNode root){
        if(root==null)
            return false;
        if(set.contains(root)){
            res=res==null?root:res;
            return true;
        }
        boolean lc=dfs(root.left);
        boolean rc=dfs(root.right);
        
        if(lc && rc)
            res=root;
        
        return lc || rc;
    }
}
