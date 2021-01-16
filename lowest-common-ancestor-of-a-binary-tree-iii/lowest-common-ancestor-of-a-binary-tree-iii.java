/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
​
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set=new HashSet();
        Node temp=p;
        while(p!=null){
            p=p.parent;
            if(p==q)
                return p;
            set.add(p);
        }
        
        while(q!=null){
            q=q.parent;
            if(q==temp || set.contains(q)){
               return q;
            }
        }
        
        return null;
    }
}
