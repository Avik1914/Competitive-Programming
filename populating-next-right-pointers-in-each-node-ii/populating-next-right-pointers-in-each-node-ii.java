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
        Queue<Node> queue=new LinkedList();
        if(root==null)
            return root;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            Node prev=null;
            while(size-->0){
                Node val=queue.poll();
                if(prev!=null)
                    prev.next=val;
                prev=val;
                if(val.left!=null)
                    queue.add(val.left);
                if(val.right!=null)
                    queue.add(val.right);
            }
        }
        return root;
    }
}
