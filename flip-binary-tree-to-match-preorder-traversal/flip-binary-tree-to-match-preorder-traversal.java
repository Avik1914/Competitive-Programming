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
    List<Integer> res;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        res=new ArrayList();
        if(!dfs(root,null,voyage)){
            res.clear();
            res.add(-1);
        }
            
        return res;
    }
    
    public boolean dfs(TreeNode root,TreeNode prev,int[] voyage){
        if(root==null){
            return true;
        }
        
        if(root.val==voyage[itr]){
            itr++;
            if(root.left==null && root.right==null)
                return true;
            else if(root.left!=null && voyage[itr]==root.left.val)
                return dfs(root.left,root,voyage) && dfs(root.right,root,voyage);
            else if(root.right!=null && voyage[itr]==root.right.val){
                if(root.left!=null)
                    res.add(root.val);
                return dfs(root.right,root,voyage) && dfs(root.left,root,voyage);
            }
                
        }
        return false;
    }
}