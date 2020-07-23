/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int len=nums.length;
        int xor=0;
        for(int num:nums)
            xor=xor^num;
        int val=xor;
        int mask=1;
        int itr=0;
        while((val&1)!=1){
            itr++;
            val=val>>1;
        }
        mask=1<<itr;
        int a=xor;
        int b=xor;
        
        
        for(int num:nums){
            if((num&mask)==0)
                a=a^num;
            else
                b=b^num;
        }
        
        return new int[]{a,b};
    }
}
