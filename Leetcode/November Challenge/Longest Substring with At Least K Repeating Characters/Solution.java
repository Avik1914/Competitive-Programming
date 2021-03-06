/*
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
*/

class Solution {
    public int longestSubstring(String s, int k) {
        int[] lkp=new int[26];
        int unique=0;
        char[] arr=s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            if(lkp[arr[i]-'a']++==0)
                unique++;
        }
        int res=0;
        for(int i=0;i<unique;i++){
            res=Math.max(res,slide(arr,i+1,k));
        }
        return res;
    }
    
    public int slide(char[] arr,int unique,int k){
        int[] lkp=new int[26];
        int start=0;
        int cnt=0;
        int res=0;
        int noOfK=0;
        for(int i=0;i<arr.length;i++){
            if(lkp[arr[i]-'a']==0)
                cnt++;
            while(start<i && cnt>unique){
                int val=lkp[arr[start]-'a'];
                if(val==k)
                    noOfK--;
                else if(val==1)
                    cnt--;
                lkp[arr[start]-'a']--;
                start++;
            }
            if(++lkp[arr[i]-'a']==k)
                noOfK++;
        
            if(noOfK==cnt)
                res=Math.max(res,i-start+1);
        }
        return res;
    }
}
