/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/


class Solution {
    public String decodeString(String s) {
         char[] arr=s.toCharArray();
         int dig=0;
        Stack<String> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(Character.isDigit(arr[i]))
                dig=dig*10+arr[i]-'0';
            else{
                if(dig>0){
                    stack.push(Integer.toString(dig));
                    dig=0;
                    stack.push(""+arr[i]);
                }else if(arr[i]==']'){
                    StringBuilder sb=new StringBuilder();
                    while(!stack.peek().equals("["))
                        sb.insert(0,stack.pop());
                    stack.pop();
                    int val=Integer.parseInt(stack.pop());
                    StringBuilder sbNew=new StringBuilder();
                    for(int j=0;j<val;j++)
                        sbNew.append(sb);
                    stack.push(sbNew.toString());
                }else
                    stack.push(""+arr[i]);
            }
        }
        
                StringBuilder sb=new StringBuilder();
                    while(!stack.isEmpty())
                        sb.insert(0,stack.pop());
        return sb.toString();
    }
}
