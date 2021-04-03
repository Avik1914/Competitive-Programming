/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack();
        char[] arr=s.toCharArray();
        int len=arr.length;
        int res=0;
        int[] dp=new int[len];
        
        for(int i=0;i<len;i++){
            int prev=-1;
            if(arr[i]==')'){
                if(!stack.isEmpty()){
                    prev=stack.pop();
                    dp[i]=i-prev+1;
                }
                if(prev>0)
                    dp[i]+=dp[prev-1];
                res=Math.max(res,dp[i]);
            }else
                stack.push(i);
        }
        
        return res;
    }
}
