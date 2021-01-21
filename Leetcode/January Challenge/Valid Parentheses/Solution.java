/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        char[] arr=s.toCharArray();  
        Map<Character,Character> map=new HashMap();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='{' || arr[i]=='(' || arr[i]=='[')
                stack.push(arr[i]);
            else{
                if(stack.isEmpty() || stack.peek()!=map.get(arr[i]))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
