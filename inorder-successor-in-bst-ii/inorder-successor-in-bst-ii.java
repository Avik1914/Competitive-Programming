/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right==null){
            while(node.parent!=null){
                if(node.parent.left==node)
                    return node.parent;
                node=node.parent;
            }
            return null;    
        }
            
        node=node.right;
        while(node.left!=null)
            node=node.left;
        return node;
    }
}