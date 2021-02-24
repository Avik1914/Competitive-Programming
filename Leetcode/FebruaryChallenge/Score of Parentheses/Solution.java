/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6
 

Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
*/

class Solution {
    public int scoreOfParentheses(String S) {
        char[] arr=S.toCharArray();
        Stack<String> stack=new Stack();
        
        for(char c:arr){
            if(c=='(')
                stack.push("(");
            else{
                int res=0;
                while(!stack.isEmpty() && !stack.peek().equals("("))
                    res+=Integer.parseInt(stack.pop());
                stack.pop();
                if(res==0)
                    stack.push("1");
                else
                    stack.push(""+(2*res));
            }
            
        }
        int sum=0;
        while(!stack.isEmpty())
            sum+=Integer.parseInt(stack.pop());
        return sum;
    }
}
