/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node prev;
    Node ret=null;
    public Node treeToDoublyList(Node root) {
        prev=null;
        if(root==null)
            return root;
        dfs(root);
        prev.right=ret;
        ret.left=prev;
        return ret;
    }
    
    public void dfs(Node root){
        if(root==null)
            return;
        dfs(root.left);
        if(prev!=null){
            prev.right=root;
            root.left=prev;
        }else
            ret=root;
        prev=root;
        dfs(root.right);
    }
}