/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".
*/

class Solution {
    public int titleToNumber(String s) {
        int len=s.length();
        char[] arr=s.toCharArray();
        int itr=26;
        int res=0;
        for(int i=0;i<len-1;i++){
            res+=itr;
            itr=itr*26;
        }
        res+=arr[len-1]-'A'+1;
        itr=26;
        for(int i=len-2;i>=0;i--){
            res+=(arr[i]-'A')*itr;
            itr=itr*26;
        }
        return res;
    }
}
