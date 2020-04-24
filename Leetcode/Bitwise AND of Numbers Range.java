/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/

/O(32) solution ---> O(1) */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res=0;
        int itr=1;
        int shift=0;
        int val=n-m+1;
        while(m!=0 && n!=0){
            if(val<=itr)
                 res|=(m & 1)==1 && (n & 1)==1 ?(1<<shift):res;
            shift++;
            itr=itr<<1;
            m=m>>1;
            n=n>>1;
        }
        
        return res;
    }
}
