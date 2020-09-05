/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> firstTreeVal=helper(root1,new ArrayList());
        List<Integer> secTreeVal=helper(root2,new ArrayList());
       
        List<Integer> finalRes=new ArrayList();
        
        int len1=firstTreeVal.size();
        int len2=secTreeVal.size();
        
        int i=0;
        int j=0;
        
        while(i<len1 || j<len2){
            if(i<len1 && j<len2){
                if(firstTreeVal.get(i)<secTreeVal.get(j))
                    finalRes.add(firstTreeVal.get(i++));
                else
                    finalRes.add(secTreeVal.get(j++));
            }else if(i<len1)
                 finalRes.add(firstTreeVal.get(i++));
            else
                finalRes.add(secTreeVal.get(j++));
            
        }
        return finalRes;
    }
    
    public List<Integer> helper(TreeNode root,List<Integer> res){
        if(root==null)
            return res;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
        return res;
    }
}
