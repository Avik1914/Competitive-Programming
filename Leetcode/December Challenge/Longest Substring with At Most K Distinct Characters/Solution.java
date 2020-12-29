/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        int start=0;
        Map<Character,Integer> map=new HashMap();
        int cnt=0;
        int res=0;
        for(int i=0;i<len;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])==1)
                cnt++;
            while(cnt>k){
                map.put(arr[start],map.get(arr[start])-1);
                if(map.get(arr[start])==0)
                    cnt--;
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
