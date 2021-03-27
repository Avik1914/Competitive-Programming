/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.
*/

/*Extend Palindrome Solution*/
class Solution {
    public int countSubstrings(String s) {
        char[] arr=s.toCharArray();
        int res=0;
        for(int i=0;i<arr.length;i++){
            res+=calPal(arr,i,i);
            res+=calPal(arr,i,i+1);
        }
        return res;
    }
    
    public int calPal(char[] arr,int lo,int hi){
        int res=0;
        while(lo>=0 && hi<arr.length && arr[lo]==arr[hi]){
            res++;
            lo--;
            hi++;
        }
        return res;
    }
}

/*Dynamic Programming Memoization */

class Solution {
    Boolean[][] dp;
    int res=0;
    public int countSubstrings(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        dp=new Boolean[len][len];
        dfs(arr,0,len-1);
        return res;
    }
    
    public boolean dfs(char[] arr,int lo,int hi){
        if(lo>hi)
            return true;
        if(dp[lo][hi]!=null)
            return dp[lo][hi];
        
        dfs(arr,lo,hi-1);
        dfs(arr,lo+1,hi);
        dp[lo][hi]=arr[lo]==arr[hi] && dfs(arr,lo+1,hi-1);
        if(dp[lo][hi])
            res++;
        return dp[lo][hi];
    }
}

/*DP Solution*/

class Solution {
    
    public int countSubstrings(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        int res=0;
        boolean[][] dp=new boolean[len][len];
        
        for(int i=0;i<len;i++){
            int r=0;
            int c=i;
            while(c<len){
                if(c-r<2)
                    dp[r][c]=arr[r]==arr[c];
                else
                    dp[r][c]=arr[r]==arr[c] && dp[r+1][c-1];
                if(dp[r][c])
                    res++;
                c++;
                r++;
            }
        }
        
        
        return res;
    }
}


