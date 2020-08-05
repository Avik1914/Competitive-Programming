/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
*/
class Solution {
    public boolean isPowerOfFour(int num) {
        char[] arr=Integer.toBinaryString(num).toCharArray();
        int noOfOne=0;
        int noOfZeroes=0;
        
        for(char a:arr){
            if(a=='1')
                noOfOne++;
            else
                noOfZeroes++;
        }
        
        
        return noOfZeroes%2==0 && noOfOne==1;
    }
}
