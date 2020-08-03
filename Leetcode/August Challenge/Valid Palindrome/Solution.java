/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/


class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int hi=s.length()-1;
        int lo=0;
        char[] arr=s.toCharArray();
        
        while(lo<hi){
            if(!isAlphaNumeric(arr[lo]))
                lo++;
            else if(!isAlphaNumeric(arr[hi]))
                hi--;
            else{
                if(arr[lo]!=arr[hi])
                    return false;
                lo++;
                hi--;
            }
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c){
        return Character.isDigit(c) || Character.isLetter(c); 
    }
}
