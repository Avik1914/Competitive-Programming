/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] lkp=new int[128];
        
        for(char c:s.toCharArray())
            lkp[c]++;
        int o=0,e=0;
        
        for(int i=0;i<128;i++){
            if(lkp[i]==0)
                continue;
            if(lkp[i]%2==0)
                e++;
            else
                o++;
        }
        
        return o<=1;
    }
}
