/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int[] lkp1=new int[26];
        int[] lkp2=new int[26];
        
        if(arr1.length!=arr2.length)
            return false;
        
        for(char c:arr1)
            lkp1[c-'a']++;
        for(char c:arr2)
            lkp2[c-'a']++;
        for(int i=0;i<26;i++){
            if(lkp1[i]!=lkp2[i])
                return false;
        }
        return true;
    }
}
