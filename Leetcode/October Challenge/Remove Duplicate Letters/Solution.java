/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lkp=new int[26];
        int[] des=new int[26];
        for(char c:s.toCharArray())
            lkp[c-'a']++;
        Stack<Character> stack=new Stack();
        
        for(char c:s.toCharArray()){
            
            while(!stack.isEmpty() && c<stack.peek() && lkp[stack.peek()-'a']>0 && des[c-'a']==0){
                char d=stack.pop();
                des[d-'a']=0;
            }
            if(des[c-'a']==0){
                stack.push(c);
                des[c-'a']=1;
            }
            lkp[c-'a']--;
        }
        
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
