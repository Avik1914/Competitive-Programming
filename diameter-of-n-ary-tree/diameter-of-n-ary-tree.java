/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int res=0;
    public int diameter(Node root) {
        dfs(root);
        return res;
    }
    
    public int dfs(Node root){
        if(root==null)
            return 0;
        int max1=0,max2=0;
        
        for(Node n:root.children){
            int val=1+dfs(n);
            if(max1<=val){
                max2=max1;
                max1=val;
            }else
                max2=Math.max(max2,val);
        }
        //System.out.println(root.val+","+max1+","+max2);
        res=Math.max(max1+max2,res);
        return max1;
    }
}