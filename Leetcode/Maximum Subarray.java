/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
       return maxSubSum(nums,0,nums.length-1);        
    }
    
    public int maxSubSum(int[] nums,int lo,int hi){
        if(lo==hi)
            return nums[hi];
        int mid=lo+(hi-lo)/2;
        int left=maxSubSum(nums,lo,mid);
        int right=maxSubSum(nums,mid+1,hi);
        int crossSum=maxCrossingSum(nums,mid,lo,hi);
        return Math.max(left,Math.max(right,crossSum));
    }
    
    public int maxCrossingSum(int[] nums,int mid,int lo,int hi){
        int sum=nums[mid];
        int loRes=nums[mid];
        int val=mid-1;
        while(val>=lo){
            sum+=nums[val--];
            loRes=Math.max(loRes,sum);
        }
        sum=nums[mid];
        val=mid+1;
        int hiRes=nums[mid];
        while(val<=hi){
            sum+=nums[val++];
            hiRes=Math.max(hiRes,sum);
        }
        return hiRes+loRes-nums[mid];
    }
}
