/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/


class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder sb=new StringBuilder();
        int carry=0;
        char[] arr1=a.toCharArray();
        char[] arr2=b.toCharArray();
        
        while(i>=0 || j>=0){
            int val=(i>=0?arr1[i]-'0':0)+(j>=0?arr2[j]-'0':0)+carry;
            sb.insert(0,val%2);
            carry=val/2;
            i--;
            j--;
        }
        if(carry>0)
            sb.insert(0,1);
        return sb.toString();
    }
}
