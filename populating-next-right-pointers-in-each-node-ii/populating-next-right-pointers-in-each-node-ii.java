/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
​
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
​
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
​
class Solution {
    public Node connect(Node root) {
        dfs(root,null);
        return root;
    }
    
    public void dfs(Node root,Node prev){
        if(root==null)
            return;
        if(prev!=null){
            if(prev.left==root && prev.right!=null)
                root.next=prev.right;
            else if(prev.next!=null){
                prev=prev.next;
                while(prev!=null && prev.left==null && prev.right==null)
                    prev=prev.next;
                if(prev!=null)    
                root.next=prev.left!=null?prev.left:prev.right;
            }
        }
        dfs(root.right,root);
        dfs(root.left,root);
    }
}
