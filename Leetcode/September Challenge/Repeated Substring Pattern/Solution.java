/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        
        for(int i=len/2;i>0;i--){
            if(len%i==0 && check(s.substring(0,i),s)){
                return true;
            }
        }
        return false;
    }
    
    public boolean check(String pat,String s){
        int len=pat.length();
        char[] p=pat.toCharArray();
        char[] a=s.toCharArray();
        int itr=0;
        for(int i=len;i<s.length();i++){
            if(a[i]!=p[itr])
                return false;
            itr++;
            itr=itr%len;
        }
        return true;
    }
}
