/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
*/

class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        return nums[dfs(nums,0,len-1)];
    }
    
    public int dfs(int[] nums,int lo,int hi){
        if(lo>hi)
            return 0;
        
        int mid=(lo+hi)/2;
        if(mid-1>=0 && nums[mid-1]>nums[mid])
            return mid;
        if(mid+1<nums.length && nums[mid+1]<nums[mid])
            return mid+1;
        if(nums[mid]>nums[lo])
            return dfs(nums,mid+1,hi);
        else if(nums[hi]>nums[mid])
            return dfs(nums,lo,mid-1);
        else{
            int val=dfs(nums,lo,mid-1);
            if(val==0)
                val=dfs(nums,mid+1,hi);
            return val;
        }
    }
}
