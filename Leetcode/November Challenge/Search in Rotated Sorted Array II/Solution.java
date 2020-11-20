/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/

class Solution {
    public boolean search(int[] nums, int target) {
       int len=nums.length; 
        int lo=0;
        int hi=len-1;
        
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target || nums[hi]==target || nums[lo]==target)
                return true;
                if(nums[lo]<nums[hi]){
                    if(nums[mid]<target)
                        lo=mid+1;
                    else
                        hi=mid;
                }
                else{
                    lo++;
                    hi--;
                }
        }
        return lo<len && nums[lo]==target;
    }
}
