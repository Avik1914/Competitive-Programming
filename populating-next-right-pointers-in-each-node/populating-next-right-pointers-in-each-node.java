/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node prev=null,ptr=root,head=root;
        
        while(ptr!=null){
            prev=null;
            while(ptr!=null){
                if(ptr.left!=null){
                    ptr.left.next=ptr.right;
                    if(prev==null)
                    prev=ptr.left;
                }
                if(ptr.right!=null && ptr.next!=null)
                    ptr.right.next=ptr.next.left;
                ptr=ptr.next;
            }
            ptr=prev;
        }
        return root;
    }
}