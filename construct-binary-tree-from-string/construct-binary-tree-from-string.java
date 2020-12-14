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
class Solution {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack=new Stack();
        char[] arr=s.toCharArray();
        int len=arr.length;
        if(len==0)
            return null;
        int itr=0;
        TreeNode root=null;
        while(itr<len){
            int val=0;
            int neg=1;
            boolean flag=false;
            if(arr[itr]=='('){
                itr++;
                continue;
            }
                
            while(itr<arr.length && (arr[itr]=='-' || Character.isDigit(arr[itr]))){
                if(arr[itr]=='-')
                    neg=-1;
                else
                    val=val*10+arr[itr]-'0';
                itr++;
                flag=true;
            }
            if(flag)
                stack.push(new TreeNode(val*neg));
            if(itr<len && arr[itr]==')'){
                TreeNode uy=stack.pop();
                if(!stack.isEmpty() && stack.peek().left==null)
                    stack.peek().left=uy;
                else if(!stack.isEmpty())
                    stack.peek().right=uy;
                itr++;
            }
        }
        
        return stack.pop();
    }
}
