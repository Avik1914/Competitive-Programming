class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int lo=0;
        int hi=len-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>=nums[0]){
                if(target<nums[mid] && target>=nums[0])
                    hi=mid-1;
                else
                    lo=mid+1;
            }else{
                if(target>nums[mid] && target<=nums[hi])
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        return -1;
    }
}