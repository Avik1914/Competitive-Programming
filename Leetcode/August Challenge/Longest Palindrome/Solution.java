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


/*Python Solution*/
/*class Solution:
    def longestPalindrome(self, s: str) -> int:
        size=len(s)
        dp=[0 for i in range(128)]
        odd=0
        cnt=0
        for i in range(size):
            dp[ord(s[i])]+=1
        
        for i in range(128):
            if dp[i]%2==1:
                odd=1
                cnt+=dp[i]-1
            else:
                cnt+=dp[i]
                
                
        return cnt+odd;
 */
