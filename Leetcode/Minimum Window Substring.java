/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
    public String minWindow(String s, String t) {
        int[] lkp=new int[256];
        for(char c:t.toCharArray())
            lkp[c]++;
        int[] lkp1=new int[256];
        int len=t.length();
        int start=0;
        int i1=-1;
        int i2=-1;
        int res=Integer.MAX_VALUE;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(lkp[c]>0){
                if(lkp[c]>lkp1[c])
                    len--;
            }
            lkp1[c]++;
            while(len==0){
                char d=s.charAt(start);
                if(lkp[d]>0 && lkp1[d]==lkp[d]){
                    if(res>i-start+1){
                        res=i-start+1;
                        i1=start;
                        i2=i+1;
                    }
                    len++;
                }
                lkp1[d]--;
                start++;
            }
        }
        
        return i1==-1?"":s.substring(i1,i2);
    }
}
