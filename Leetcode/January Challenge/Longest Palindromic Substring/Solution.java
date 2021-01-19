/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/


class Solution {
    int start;
    int end;
    public String longestPalindrome(String s) {
        start=0;
        end=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            growPals(arr,i,i);       
            growPals(arr,i,i+1);       
        }
        return s.substring(start,end+1);
    }
    
    public void growPals(char[] arr,int i,int j){
        
        while(i>=0 && j<arr.length && arr[i]==arr[j]){
            if(end-start<j-i){
                start=i;
                end=j;
            }
            i--;
            j++;
        }
        
    }
}
