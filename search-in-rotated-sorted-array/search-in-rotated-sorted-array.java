class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        
        int lo=0;
        int hi=len-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[lo]){
                if(nums[mid]>target && target>=nums[lo])
                    hi=mid-1;
                else
                    lo=mid+1;
            }else{
                if(nums[mid]<target && target<=nums[hi])
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        
        return -1;
    }
}