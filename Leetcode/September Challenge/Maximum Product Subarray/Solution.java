/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int prev=1;
        int mul=1;
        int res=Integer.MIN_VALUE;
        boolean flag=false;
    
        for(int i=0;i<nums.length;i++){
            mul=mul*nums[i];
             
            if(mul<0 && !flag){
                prev=mul;
                flag=true;
                res=Math.max(res,mul);
            }else if(mul<0)
                res=Math.max(res,mul/prev);
             else
                res=Math.max(res,mul);
            if(mul==0){
                mul=1;
                prev=1;
                flag=false;
            }
        }
        return res;
    }
}
