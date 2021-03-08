class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int lo=0;
        int hi=len-1;
        
        while(lo<hi){
            if(nums[lo]<nums[hi])
                return nums[lo];
            int mid=(lo+hi)/2;
            if(nums[mid]>=nums[lo]){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return nums[lo];
    }
}