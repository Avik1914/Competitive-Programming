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
        Node cur=root,prev=null,head=null;
        
        while(cur!=null){
            while(cur!=null){
                if(cur.left!=null){
                    if(prev!=null)
                        prev.next=cur.left;
                    else
                        head=cur.left;
                    prev=cur.left;
                }
                if(cur.right!=null){
                    if(prev!=null)
                        prev.next=cur.right;
                    else
                        head=cur.right;
                    prev=cur.right;
                }
                cur=cur.next;
            }
            cur=head;
            prev=null;
            head=null;
        }
        return root;
    }
}