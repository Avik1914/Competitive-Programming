/*
Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Constraints:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        int[] lkp1=new int[26];
        int[] lkp2=new int[26];
        int len1=A.length();
        int len2=B.length();
        if(len1!=len2)
            return false;
        int cnt=0;
        for(int i=0;i<len1;i++){
            lkp1[A.charAt(i)-'a']++;
            lkp2[B.charAt(i)-'a']++;
            if(A.charAt(i)!=B.charAt(i))
                cnt++;
        }
        if(cnt>2)
            return false;
        boolean isDouble=false;
        for(int i=0;i<26;i++){
            if(lkp1[i]!=lkp2[i])
                return false;
            if(lkp1[i]>1)
                isDouble=true;
        }
        return cnt==2 || isDouble;
    }
}
