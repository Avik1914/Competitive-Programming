class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int lo=0;
        int hi=len-1;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi])
                lo=mid+1;
            else
                hi=mid;
        }
        return nums[lo];
    }
}