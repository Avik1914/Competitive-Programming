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
    Map<TreeNode,TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map=new HashMap<>();
        dfs(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        Set<TreeNode> seen=new HashSet<>();
        seen.add(target);
        List<Integer> res=new ArrayList<>();
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(level==K){
                while(!queue.isEmpty())
                    res.add(queue.poll().val);
                return res;
            }
            while(size-->0){
                TreeNode poll=queue.poll();
                
                if(map.get(poll)!=null && !seen.contains(map.get(poll))){
                    queue.add(map.get(poll));
                    seen.add(map.get(poll));
                }
                if(poll.left!=null && !seen.contains(poll.left)){
                    queue.add(poll.left);
                    seen.add(poll.left);
                }
                if(poll.right!=null && !seen.contains(poll.right)){
                    queue.add(poll.right);
                    seen.add(poll.right);
                }
            }
            level++;
        }
        return res;
    }
    
    public void dfs(TreeNode root,TreeNode par){
        if(root==null)
            return;
        map.put(root,par);
        dfs(root.left,root);
        dfs(root.right,root);
    }
}