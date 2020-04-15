/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int mul=1;
        if(len==0)
            return nums;
        int[] answer=new int[len];
        
        for(int i=0;i<len;i++){
            mul=mul*nums[i];
            answer[i]=mul;
        }
        mul=1;
        
        for(int i=len-1;i>0;i--){
            answer[i]=answer[i-1]*mul;
            mul*=nums[i];
        }
        answer[0]=mul;
        return answer;
    }
}
