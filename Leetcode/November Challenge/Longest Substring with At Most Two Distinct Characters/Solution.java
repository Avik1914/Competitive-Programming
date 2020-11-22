/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        int[] lkp=new int[256];
        int cnt=0;
        int res=0;
        int start=0;
        
        
        for(int i=0;i<len;i++){
            if(lkp[arr[i]]==0)
                cnt++;
            lkp[arr[i]]++;
            while(cnt>2){
                if(--lkp[arr[start]]==0)cnt--;
                start++;
            }
            res=Math.max(res,i-start+1);   
        }
        return res;
    }
}
