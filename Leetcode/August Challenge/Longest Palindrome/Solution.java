/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        char[] arr=s.toCharArray();
        int odd=0;
        int cnt=0;
        int res=0;
        int[] lkp=new int[128];
        
        for(char c:arr)
            lkp[c]++;
        for(int i=0;i<128;i++){
            if(lkp[i]%2==0)
                res+=lkp[i];
            else{
                res+=lkp[i]-1;
                odd=1;
            }
                
        }
        return res+odd;
    }
}
