/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
*/

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
/*BFS Method*/
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


/*DFS Method*/

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
