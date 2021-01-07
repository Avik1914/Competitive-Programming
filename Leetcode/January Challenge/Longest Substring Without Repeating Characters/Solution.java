/*
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lkp=new int[256];
        char[] arr=s.toCharArray();
        int start=0;
        int res=0;
        
        for(int i=0;i<arr.length;i++){
            lkp[arr[i]]++;
            while(lkp[arr[i]]>1){
                lkp[arr[start]]--;
                start++;
            }
            res=Math.max(i-start+1,res);
        }
        return res;
    }
}
