/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new Stack();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    
    
    public int next() {
        TreeNode popped=stack.pop();
        if(popped.right!=null){
            TreeNode newRoot=popped.right;
            while(newRoot!=null){
                stack.push(newRoot);
                newRoot=newRoot.left;
            }
        }
        return popped.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
​
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
