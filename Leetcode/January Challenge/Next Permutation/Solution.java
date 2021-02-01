/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/


class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int prev=-101;
        int itr=len-1;
        while(itr>=0 && nums[itr]>=prev){
            prev=nums[itr];
            itr--;
        }
       
        if(itr<0)
            reverse(nums,0,len-1);
        else{
            int startIndex=itr;
            
            int lo=itr+1;
            int hi=len-1;
            while(lo<hi){
                int mid=lo+(hi-lo)/2+1;
                if(nums[mid]>nums[startIndex])
                    lo=mid;
                else
                    hi=mid-1;
            }
            int temp=nums[startIndex];
            nums[startIndex]=nums[lo];
            nums[lo]=temp;
            reverse(nums,startIndex+1,len-1);
        }
        
    }
    
    public void reverse(int[] nums,int lo,int hi){
        while(lo<hi){
            int temp=nums[lo];
            nums[lo]=nums[hi];
            nums[hi]=temp;
            lo++;
            hi--;
        }
    }
}
