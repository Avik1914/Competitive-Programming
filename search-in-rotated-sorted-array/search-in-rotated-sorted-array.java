class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int lo=0,hi=len-1;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[0]<=nums[mid]){
                if(target>=nums[0] && target<nums[mid])
                    hi=mid-1;
                else
                    lo=mid+1;
            }else{
                if(target>nums[mid] && target<=nums[len-1])
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        return nums[lo]==target?lo:-1;
    }
}